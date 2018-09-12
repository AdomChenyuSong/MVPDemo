package com.example.qqweq.mvpdemo.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseActivity;
import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.bean.BaseEntity;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qqweq on 2018/9/10.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    protected int setContentLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle bundle) {
        //RxClient.<AppVersionModel>create()
        RxClient.getVersion(1)
                .compose(new RxClient.DefaultTransformer<AppVersionModel>())
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }
}
