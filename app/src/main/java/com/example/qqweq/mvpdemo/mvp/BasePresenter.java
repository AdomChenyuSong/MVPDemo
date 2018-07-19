package com.example.qqweq.mvpdemo.mvp;


import java.lang.ref.WeakReference;

import okhttp3.Call;

/**
 * Created by qqweq on 2018/7/16.
 */

public abstract class BasePresenter<V> {
    private WeakReference<V> mView;
    public Call mCall;


    /**
     * 绑定view
     * @param mView
     */
    public void attachView(V mView) {
        this.mView = new WeakReference<>(mView);
    }
    /**
     * 释放view
     */
    public void dettachView(){
        if (mView!=null){
            mView.clear();
            mView = null;
        }
        if (mCall != null) {
            mCall.cancel();
        }
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mView!= null;
    }

    public V getView(){
        return mView.get();
    }
}
