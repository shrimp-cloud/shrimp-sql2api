package com.wkclz.sql2api.manager.domain.entity;

import com.wkclz.sql2api.manager.domain.base.SsBaseEntity;
import lombok.Data;

@Data
public class ApiGroup extends SsBaseEntity {

    private String groupCode;
    private String groupName;

}
