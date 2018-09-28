package com.example.qqweq.mvpdemo.mvp;


import android.app.Activity;
import android.content.Context;

import com.example.qqweq.mvpdemo.bean.BaseEntity;
import com.example.qqweq.mvpdemo.connection.ApiException;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;

/**
 * Created by qqweq on 2018/7/16.
 */

public abstract class BasePresenter<V> {
    private WeakReference<V> mView;
    public Call mCall;
    public Activity mContext;

    /**
     * 绑定view
     *
     * @param mView
     */
    public void attachView(V mView, Activity mContext) {
        this.mView = new WeakReference<>(mView);
        this.mContext = mContext;
    }

    /**
     * 释放view
     */
    public void dettachView() {
        if (mView != null) {
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
    public boolean isViewAttached() {
        return mView != null;
    }

    public V getView() {
        return mView.get();
    }
}
