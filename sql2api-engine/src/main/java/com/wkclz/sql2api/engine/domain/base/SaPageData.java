package com.wkclz.sql2api.engine.domain.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author shrimp
 */

@Data
public class SaPageData<T> implements Serializable {

    private List<T> rows;

    private Long current = 1L;
    private Long size = 20L;
    private Long total;
    private Long page;
    private Long offset = 0L;

    public SaPageData() {
        init();
    }

    public <M extends SaBaseEntity> SaPageData(M entity) {
        this.current = entity.getCurrent();
        this.size = entity.getSize();
        if (this.current != null && this.size != null){
            this.offset = (this.current -1) * this.size;
        }
    }

    public SaPageData(Long current, Long size) {
        this.current = current;
        this.size = size;
        if (this.current != null && this.size != null){
            this.offset = (this.current -1) * this.size;
        }
    }

    public SaPageData(Long current, Long size, Long total, List<T> list) {
        this.current = current;
        this.size = size;
        this.total = total;
        init();
        this.rows = list;
    }


    public static SaPageData newInstance() {
        return new SaPageData();
    }
    public static <T extends SaBaseEntity> SaPageData<T> newInstance(T entity) {
        return new SaPageData(entity);
    }
    public static SaPageData newInstance(Long current, Long size) {
        return new SaPageData(current, size);
    }
    public static <T> SaPageData<T> newInstance(Long current, Long size, Long total, List<T> list) {
        return new SaPageData(current, size, total, list);
    }

    public void setTotal(Long total) {
        this.total = total;
        init(); // 只有设置了总数据数的时候才做分页处理
    }


    private void init() {
        if (this.current == null || this.current < 1) {
            this.current = 1L;
        }
        if (this.size == null || this.size < 1) {
            this.size = 20L;
        }
        if (this.total == null) {
            this.total = 0L;
        }

        this.page = this.total / this.size;
        long remainder = this.total % this.size;
        if (remainder > 0) {
            this.page = this.page + 1;
        }
        this.current = this.current > this.page ? this.page : this.current;
        this.offset = (this.current -1 ) * this.size;
    }
}
