package com.wkclz.sql2api.manager.domain.entity;

import com.wkclz.sql2api.manager.domain.base.SsBaseEntity;
import lombok.Data;

@Data
public class ApiDefinitionParam extends SsBaseEntity {

    private String apiCode;
    private String fieldName;
    private String fieldFormType;
    private String placeholder;
    private Integer required;
    private String dictType;

}
