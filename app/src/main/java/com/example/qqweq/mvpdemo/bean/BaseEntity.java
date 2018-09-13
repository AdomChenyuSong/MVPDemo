package com.example.qqweq.mvpdemo.bean;

import java.io.Serializable;

/**
 * Created by qqweq on 2018/9/11.
 */

public class BaseEntity implements Serializable {
    public int code;
    public String msg;

    public int getStatus_code() {
        return code;
    }

    public void setStatus_code(int status_code) {
        this.code = status_code;
    }

    public String getError_msg() {
        return msg;
    }

    public void setError_msg(String error_msg) {
        this.msg = error_msg;
    }

}
