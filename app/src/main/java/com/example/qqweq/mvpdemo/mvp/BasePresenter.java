package com.example.qqweq.mvpdemo.mvp;


import okhttp3.Call;

/**
 * Created by qqweq on 2018/7/16.
 */

public abstract class BasePresenter<V extends BaseView> {
    private V mView;
    public Call mCall;

    /**
     * 绑定view
     * @param mView
     */
    public void attachView(V mView) {
        this.mView = mView;
    }
    /**
     * 释放view
     */
    public void dettachView(){
        this.mView = null;
        if (mCall != null) {
            mCall.cancel();
        }
    }


}
