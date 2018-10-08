package com.example.qqweq.mvpdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.bean.ObjectModel;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;
import com.example.qqweq.mvpdemo.dialog.NormalDialog;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvpview.WelcomeView;
import com.example.qqweq.mvpdemo.presenter.WelcomeFresenter;

/**
 * Created by qqweq on 2018/9/15.
 */

public class WelcomeFragment extends MvpFragment<WelcomeView, WelcomeFresenter> implements WelcomeView {
    private WelcomeFresenter welcomeFresenter;

    @Override
    public int setContentLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initData(Bundle data) {

    }

    @Override
    public void initView(View view) {
        welcomeFresenter.getVersion();
    }

    @Override
    public WelcomeFresenter initPresenter() {
        welcomeFresenter = new WelcomeFresenter();
        return welcomeFresenter;
    }

    @Override
    public void getVersion(AppVersionModel versionCode) {
        if (versionCode.getIslast() != 2) {
            NormalDialog normalDialog = new NormalDialog(getActivity());
            normalDialog.setMessage(versionCode.getContent());
            normalDialog.setClickListener(new NormalDialog.setClickListener() {
                @Override
                public void setClickListener(int type) {
                    if (type == 2) {
                        transToLogin();
                    }
                }
            });
            normalDialog.show();
        } else {
            transToLogin();
        }
    }

    /**
     * 切换fragment
     */
    private void transToLogin() {
        changeFragment(new LoginFragment());
    }
}
