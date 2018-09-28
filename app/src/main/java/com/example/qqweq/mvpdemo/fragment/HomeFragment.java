package com.example.qqweq.mvpdemo.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvpview.HomeView;
import com.example.qqweq.mvpdemo.presenter.HomePresenter;

/**
 * Created by qqweq on 2018/9/28.
 */

public class HomeFragment extends MvpFragment<HomeView,HomePresenter> {
    HomePresenter homePresenter;
    @Override
    public HomePresenter initPresenter() {
        homePresenter=new HomePresenter();
        return homePresenter;
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initData(Bundle data) {

    }

    @Override
    public void initView(View view) {

    }
}
