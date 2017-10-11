package com.amayadream.retrofit2.api.result;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 返回值实体
 * @author : Amayadream
 * @date :   2017-08-17 14:38
 */
public class Results implements Serializable {

    private static final Integer BASE_CODE = 10100000;

    private Long code;
    private String message;
    private Object data = new JSONObject();

    private Results() {
    }

    private Results(Long code, String message, Object data) {
        if (code != ResultConstant.SUCCESS.code) {
            code = BASE_CODE + code;
        }
        this.code = code;
        this.message = message;
        if (data != null) {
            this.data = data;
        }
    }

    public static Results ok() {
        return new Results(ResultConstant.SUCCESS.code, ResultConstant.SUCCESS.message, null);
    }

    public static Results ok(ResultData data) {
        return new Results(ResultConstant.SUCCESS.code, ResultConstant.SUCCESS.message, data.value());
    }

    public static Results ok(String message) {
        return new Results(ResultConstant.SUCCESS.code, message, null);
    }

    public static Results ok(String message, ResultData data) {
        return new Results(ResultConstant.SUCCESS.code, message, data.value());
    }

    public static Results nok(ResultConstant c) {
        return new Results(c.code, c.message, null);
    }

    public static Results nok(ResultConstant c, ResultData data) {
        return new Results(c.code, c.message, data.value());
    }

    public static Results nok(ResultConstant c, String message) {
        return new Results(c.code, message, null);
    }

    public static Results nok(ResultConstant c, String message, ResultData data) {
        return new Results(c.code, message, data.value());
    }

    @Override
    public String toString() {
        return "Results{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
