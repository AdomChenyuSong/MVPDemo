package com.example.qqweq.mvpdemo.bean;

import java.io.Serializable;

/**
 * Created by qqweq on 2018/9/11.
 */

public class BaseEntity implements Serializable {
    //{"code":50002,"msg":"用户名和密码不匹配，请重新输入。","detail":"用户名和密码不匹配，请重新输入。","time":1537866062480,"timestamp":1537866062481}
    public int code = 200;
    public String msg;

    public int getStatus_code() {
        return code;
    }

    public void setStatus_code(int code) {
        this.code = code;
    }

    public String getError_msg() {
        return msg;
    }

    public void setError_msg(String msg) {
        this.msg = msg;
    }

}
