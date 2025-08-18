package com.wkclz.sql2api.manager.domain.entity;

import com.wkclz.sql2api.manager.domain.base.BaseEntity;
import lombok.Data;

@Data
public class ApiDefinition extends BaseEntity {

    private String apiCode;
    private String apiName;
    private String apiMethod;
    private String apiUri;
    private String resultType;
    private Integer enableFlag;
    private String apiScript;
    private String apiScriptCount;
    private Integer humpConversionSwitch;


}
