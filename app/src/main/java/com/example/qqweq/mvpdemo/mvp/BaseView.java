package com.example.qqweq.mvpdemo.mvp;

import android.content.Context;

/**
 * Created by qqweq on 2018/7/16.
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showToast(String msg);
    void showErr();
    Context getContext();
}
