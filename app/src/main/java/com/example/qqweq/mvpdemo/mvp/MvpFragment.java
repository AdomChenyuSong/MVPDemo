package com.example.qqweq.mvpdemo.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.qqweq.mvpdemo.base.BaseFragment;

/**
 * Created by qqweq on 2018/7/16.
 */

public abstract class MvpFragment<V, P extends BasePresenter<V>> extends BaseFragment implements BaseView {
    public P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V)this);
        }
    }

    public abstract P initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.dettachView();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showErr() {

    }

    @Override
    public Context getContext() {
        return super.getContext();
    }
}

