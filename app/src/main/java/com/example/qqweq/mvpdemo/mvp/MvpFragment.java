package com.example.qqweq.mvpdemo.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

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
            mPresenter.attachView((V) this, getContext());
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
        setRefresh();
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        showErrorPage();
    }

    @Override
    public void emptyData() {
        showNoData();
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }
}

