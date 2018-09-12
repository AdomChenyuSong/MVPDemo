package com.example.qqweq.mvpdemo.bean;

/**
 * 韩梦飞沙 韩亚飞 313134555@qq.com yue31313 han_meng_fei_sha
 * on 2017/9/26.
 */

public class AppVersionModel {
    /**
     * islast : 1
     * versionno : 1.0.6
     * appurl : http://47.93.172.224/app/pad/pad-dev.apk
     * isforce : 2
     * content : ["本次更新：","1.兼容安卓8.0","2.修复部分已知问题"]
     */

    private int islast;
    private String versionno;
    private String appurl;
    private int isforce;
    private String content;
    private String code;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIslast() {
        return islast;
    }

    public void setIslast(int islast) {
        this.islast = islast;
    }

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno;
    }

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl;
    }

    public int getIsforce() {
        return isforce;
    }

    public void setIsforce(int isforce) {
        this.isforce = isforce;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
