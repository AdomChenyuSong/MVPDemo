package com.example.qqweq.mvpdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseActivity;
import com.example.qqweq.mvpdemo.fragment.WelcomeFragment;

/**
 * Created by qqweq on 2018/9/10.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int setContentLayout() {
        return R.layout.activity_inculde;
    }

    @Override
    protected void initView() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_container, new WelcomeFragment());
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void initData(Bundle bundle) {

    }
}
