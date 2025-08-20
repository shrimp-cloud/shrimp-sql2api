package com.wkclz.sql2api.manager.domain.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shrimp
 */

@Data
public class SsBaseEntity implements Serializable {

    // 基本字段
    private Long id;
    private Integer sort;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
    private String remark;
    private Integer version;

   // 分页
    private Long current;
    private Long size;
    private Long offset;
    protected Long total;
}
