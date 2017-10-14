package com.amayadream.retrofit2.api.result;

/**
 * @author : Amayadream
 * @date :   2017-08-17 14:40
 */
public enum  ResultConstant {

    SUCCESS(0, "ok"),

    SYSTEM_BUSY(1, "系统繁忙, 请稍后重试!"),

    ;

    public long code;
    public String message;

    ResultConstant(long code, String message) {
        this.code = code;
        this.message = message;
    }

}
