package com.example.qqweq.mvpdemo.activity;

import android.os.Bundle;
import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseActivity;
import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;
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
        RxClient.getVersion(1)
                .compose(RxClient.<AppVersionModel>create())
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiSubscriber<AppVersionModel>(this) {
                    @Override
                    public void onNext(AppVersionModel appVersionModel) {

                    }
                });

    }
}
