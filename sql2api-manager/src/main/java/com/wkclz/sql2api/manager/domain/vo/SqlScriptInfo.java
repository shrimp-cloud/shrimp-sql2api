package com.wkclz.sql2api.manager.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class SqlScriptInfo {

    // file 全名
    private String fileName;

    // ddl, dml
    private String type;

    // 表名
    private String tableName;

    // 脚本
    List<String> scripts;


}
