package com.wkclz.sql2api.engine.domain.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shrimp
 */

@Data
public class SaBaseEntity implements Serializable {

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
    private Long page;


    public void init() {
        if (this.current == null || this.current < 1) {
            this.current = 1L;
        }
        if (this.size == null || this.size < 1) {
            this.size = 20L;
        }
        this.offset = (this.current -1 ) * this.size;
    }
}
