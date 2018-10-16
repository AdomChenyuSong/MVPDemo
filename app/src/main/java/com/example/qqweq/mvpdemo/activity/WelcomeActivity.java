package com.example.qqweq.mvpdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseActivity;
import com.example.qqweq.mvpdemo.base.ChapterTreeStatusFragment;
import com.example.qqweq.mvpdemo.fragment.LoginFragment;
import com.example.qqweq.mvpdemo.fragment.MainFragment;
import com.example.qqweq.mvpdemo.fragment.NewHomeFragment;
import com.example.qqweq.mvpdemo.fragment.WelcomeFragment;
import com.example.qqweq.mvpdemo.fragment.tab.MyStatusFragment;

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
        changeFragment(new ChapterTreeStatusFragment());
//        FragmentTransaction transaction = getragmentTransaction();
//        transaction.replace(R.id.fl_container,);
//        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void initData(Bundle bundle) {

    }
}
