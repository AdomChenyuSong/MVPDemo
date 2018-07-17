package com.example.qqweq.mvpdemo.mvp;

import android.content.Context;

/**
 * Created by qqweq on 2018/7/16.
 */

public interface BaseView {
    /**
     * 显示弹窗
     */
    void showLoading();

    /**
     * 关闭弹窗
     */
    void hideLoading();

    /**
     * 显示toast
     *
     * @param msg
     */
    void showToast(String msg);

    /**
     * 展示错误信息
     */
    void showErr();

    /**
     * 获取当前上下文对象
     * @return
     */
    Context getContext();
}
