package com.wkclz.sql2api.manager.domain.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * Created: wangkaicun @ 2017-10-20 下午9:11
 */

@Data
public class Result<T> implements Serializable {

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

    public static Result data(Object data) {
        Result result = new Result();
        result.data = data;
        result.code = 1;
        return result;
    }

    public static Result ok() {
        Result result = new Result();
        result.data = true;
        result.code = 1;
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = -1;
        return result;
    }

}
