package com.example.qqweq.mvpdemo.connection;

/**
 * 统一处理异常类
 * Created by qqweq on 2018/9/11.
 */

public class ApiException extends IllegalArgumentException {
    private double code;

    public ApiException(double code, String msg) {
        super(msg);
        this.code = code;
    }

    public double getCode() {
        return code;
    }
}
