package com.wkclz.sql2api.manager.config;

import com.wkclz.sql2api.manager.dao.SchemaMapper;
import com.wkclz.sql2api.manager.domain.vo.SqlScriptInfo;
import com.wkclz.sql2api.manager.domain.vo.TableInfoPo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shrimp
 */
@Slf4j
@Component
@AutoConfigureAfter(SqlSession.class)
public class DatabaseInitRunner implements ApplicationRunner {

    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SchemaMapper schemaMapper;
    @Autowired
    private Sql2ApiManagerConfig sql2ApiManagerConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 开关
        Integer autoCreateTable = sql2ApiManagerConfig.getAutoCreateTable();
        if (autoCreateTable == null || autoCreateTable != 1) {
            return;
        }

        // 获取所有 DDL 脚本
        List<SqlScriptInfo> scripts = scanDdlScripts();
        if (scripts.isEmpty()) {
            log.debug("tables can not be scan!");
            return;
        }

        // 筛选缺失的表
        List<String> tableNames = scripts.stream()
            .filter(t -> "ddl".equals(t.getType()))
            .map(SqlScriptInfo::getTableName)
            .toList();

        List<String> notExistTables = getNotExistTables(tableNames);

        // 表已追寻情况，将不会再创建表，和不再初始化数据
        if (CollectionUtils.isEmpty(notExistTables)) {
            return;
        }

        log.info("init tables and data...");
        // 创建表
        scripts.forEach(t -> execCreateTableDdl(t, notExistTables));
        // 数据入库
        scripts.forEach(t -> execInsertDml(t, notExistTables));
        log.info("init tables and data  success!");
    }

    // 扫描所有脚本文件
    private List<SqlScriptInfo> scanDdlScripts() throws IOException {
        // 读取所有文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:sql-script/*.sql");
        List<SqlScriptInfo> infos = new ArrayList<>();

        for (Resource resource : resources) {
            try (InputStream inputStream = resource.getInputStream()) {
                // 从文件中获取脚本
                SqlScriptInfo info = new SqlScriptInfo();
                infos.add(info);
                String filename = resource.getFilename();
                info.setFileName(filename);
                info.setTableName(filename.substring(0, filename.indexOf(".")));
                info.setType(filename.endsWith(".ddl.sql") ? "ddl" : "dml");

                String script = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
                String[] splitStrs = script.split(";");
                List<String> scripts = new ArrayList<>();
                info.setScripts(scripts);
                for (String split : splitStrs) {
                    split = split.replaceAll("\\s+", " ").trim();
                    if (!split.isEmpty()) {
                        scripts.add(script);
                    }
                }
            }
        }
        return infos;
    }

    // 获取已经存在的表
    private List<String> getNotExistTables(List<String> tableNames) {
        TableInfoPo po = new TableInfoPo();
        po.setTableSchema(getTableSchema());
        po.setTableNames(tableNames);
        List<TableInfoPo> tables = schemaMapper.getTables(po);
        List<String> existTables = tables.stream().map(TableInfoPo::getTableName).toList();
        return tableNames.stream().filter(t -> !existTables.contains(t)).toList();
    }

    // 获取数据库名
    private String getTableSchema() {
        try {
            Connection connection = dataSource.getConnection();
            if (connection.isClosed()) {
                throw new RuntimeException("数据库连接已关闭!");
            }
            String tableSchema = connection.getCatalog();
            if (StringUtils.hasLength(tableSchema)) {
                return tableSchema;
            }
            DatabaseMetaData metaData = connection.getMetaData();
            String datasourceUrl = metaData.getURL();
            Pattern pattern = Pattern.compile("jdbc:mysql://[^/]+/([^ ?/]+)");
            Matcher matcher = pattern.matcher(datasourceUrl);
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                throw new RuntimeException("未从数据库连接信息中发现数据库名,请联系开发者!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("无法从默认数据源中获取数据库连接信息: " + e.getMessage());
        }
    }

    // 创建表
    private void execCreateTableDdl(SqlScriptInfo info, List<String> notExistTables) {
        if (info == null || !"ddl".equals(info.getType()) || CollectionUtils.isEmpty(info.getScripts())) {
            return;
        }
        String tableName = info.getTableName();
        if (!notExistTables.contains(tableName)) {
            return;
        }
        String ddl = info.getScripts().getFirst();
        String md5 = DigestUtils.md5DigestAsHex(ddl.getBytes(StandardCharsets.UTF_8));
        String statementId = "dynamic.ddl." + tableName + "." + md5;
        Configuration configuration = sqlSession.getConfiguration();
        SqlSource sqlSource = new StaticSqlSource(configuration, ddl);
        MappedStatement.Builder statementBuilder = new MappedStatement.Builder(
            configuration,
            statementId,
            sqlSource,
            SqlCommandType.UPDATE
        );
        MappedStatement statement = statementBuilder.build();
        configuration.addMappedStatement(statement);
        sqlSession.update(statementId);
        log.info("created table: {}", tableName);
    }

    // 初始化数据
    private void execInsertDml(SqlScriptInfo info, List<String> notExistTables) {
        if (!"dml".equals(info.getType()) || CollectionUtils.isEmpty(info.getScripts())) {
            return;
        }
        List<String> scripts = info.getScripts();
        for (String dml : scripts) {
            // 已经存在的表，不再初始化数据
            if (!notExistTables.contains(info.getTableName())) {
                continue;
            }

            // 初始化数据
            String fileName = info.getFileName();
            String md5 = DigestUtils.md5DigestAsHex(dml.getBytes(StandardCharsets.UTF_8));
            String statementId = "dynamic.dml." + fileName + "." + md5;
            Configuration configuration = sqlSession.getConfiguration();
            SqlSource sqlSource = new StaticSqlSource(configuration, dml);
            MappedStatement.Builder statementBuilder = new MappedStatement.Builder(
                configuration,
                statementId,
                sqlSource,
                SqlCommandType.UPDATE
            );
            MappedStatement statement = statementBuilder.build();
            configuration.addMappedStatement(statement);
            sqlSession.update(statementId);
            log.info("exec dml: {}.{}", fileName, md5);
        }
    }

}