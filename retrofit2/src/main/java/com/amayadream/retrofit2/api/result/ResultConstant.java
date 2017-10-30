package com.amayadream.retrofit2.api.result;

/**
 * @author : Amayadream
 * @date :   2017-08-17 14:40
 */
public enum  ResultConstant {

    SUCCESS(0, "ok"),

    SYSTEM_BUSY(1, "系统繁忙, 请稍后重试!"),

    SIGN_EMPTY(1000, "签名信息缺失"),
    SIGN_ERROR(1001, "签名校验失败"),
    REQUEST_TIMEOUT(1002, "请求过期"),

    ;

    public long code;
    public String message;

    ResultConstant(long code, String message) {
        this.code = code;
        this.message = message;
    }

}
