package com.wkclz.sql2api.manager.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author shrimp
 */
@Data
public class TableInfoPo implements Serializable {

    private String tableSchema;
    private String tableName;
    private List<String> tableNames;

}
