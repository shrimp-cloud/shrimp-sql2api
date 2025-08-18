package com.wkclz.sql2api.manager.domain.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shrimp
 */

@Data
public class BaseEntity implements Serializable {

    private Long id;
    private Integer sort;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
    private String remark;
    private Integer version;
}
