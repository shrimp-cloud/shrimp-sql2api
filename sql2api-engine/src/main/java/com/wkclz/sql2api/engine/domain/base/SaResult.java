package com.wkclz.sql2api.engine.domain.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * Created: wangkaicun @ 2017-10-20 下午9:11
 */

@Data
public class SaResult<T> implements Serializable {

    private Integer code = -1;

    private String msg = "success";

    /**
     * 详情
     */
    private T data = (T) "error";


    public T getData() {
        if (code > 0 && data != null) {
            return data;
        }
        return null;
    }

    public static SaResult data(Object data) {
        SaResult result = new SaResult();
        result.data = data;
        result.code = 1;
        return result;
    }

    public static SaResult ok() {
        SaResult result = new SaResult();
        result.data = true;
        result.code = 1;
        return result;
    }

    public static SaResult error(String msg) {
        SaResult result = new SaResult();
        result.msg = msg;
        result.code = -1;
        return result;
    }

}
