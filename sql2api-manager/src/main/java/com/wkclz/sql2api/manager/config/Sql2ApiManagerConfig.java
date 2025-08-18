package com.wkclz.sql2api.manager.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class Sql2ApiManagerConfig {

    // 当表不存在时，是否自动创建表
    @Value("${sqp2api.auto-create-table:1}")
    private Integer autoCreateTable;

}
