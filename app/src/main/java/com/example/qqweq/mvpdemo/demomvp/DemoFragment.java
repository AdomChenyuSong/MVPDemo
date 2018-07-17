package com.example.qqweq.mvpdemo.demomvp;

import android.os.Bundle;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvp.MvpView;

/**
 * Created by qqweq on 2018/7/17.
 */

public class DemoFragment extends MvpFragment<MvpView, DemoPresenter> {
    private DemoPresenter demoPresenter;

    @Override
    public int setContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle data) {
        demoPresenter = new DemoPresenter();
        demoPresenter.getData();
    }

    @Override
    public DemoPresenter initPresenter() {
        return demoPresenter;
    }

    @Override
    public void getData(String data) {

    }

}
