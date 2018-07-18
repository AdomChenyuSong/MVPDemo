package com.example.qqweq.mvpdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.qqweq.mvpdemo.base.BaseActivity;
import com.example.qqweq.mvpdemo.demomvp.DemoFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected int setContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle bundle) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.fl_container,new DemoFragment());
        transaction.commitAllowingStateLoss();
    }
}
