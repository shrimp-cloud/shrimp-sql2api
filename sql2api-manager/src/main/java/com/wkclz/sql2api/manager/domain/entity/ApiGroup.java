package com.wkclz.sql2api.manager.domain.entity;

import com.wkclz.sql2api.engine.domain.base.SaBaseEntity;
import lombok.Data;

@Data
public class ApiGroup extends SaBaseEntity {

    private String groupCode;
    private String groupName;

}
