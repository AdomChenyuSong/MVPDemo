package com.example.qqweq.mvpdemo.bean;

import java.io.Serializable;

/**
 * Created by qqweq on 2018/9/11.
 */

public class BaseEntity<T> implements Serializable {
    public int status_code;
    public String error_msg;
    public T data;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
