package com.wkclz.sql2api.manager.domain.entity;

import com.wkclz.sql2api.engine.domain.base.SaBaseEntity;
import lombok.Data;

@Data
public class ApiDefinitionParam extends SaBaseEntity {

    private String apiCode;
    private String fieldName;
    private String fieldFormType;
    private String placeholder;
    private Integer required;
    private String dictType;

}
