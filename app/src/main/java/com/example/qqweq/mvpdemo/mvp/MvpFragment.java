package com.example.qqweq.mvpdemo.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.qqweq.mvpdemo.base.BaseFragment;

/**
 * Created by qqweq on 2018/7/16.
 */

public abstract class MvpFragment<V, P extends BasePresenter> extends BaseFragment implements BaseView {

    @Override
    public void showErr() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showToast(String msg) {
        if (TextUtils.isEmpty(msg))
            return;
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public Context getContext() {
        return super.getContext();
    }
}

