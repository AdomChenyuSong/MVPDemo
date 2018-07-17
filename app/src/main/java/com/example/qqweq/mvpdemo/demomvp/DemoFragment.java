package com.example.qqweq.mvpdemo.demomvp;

import android.os.Bundle;

import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvp.MvpView;

/**
 * Created by qqweq on 2018/7/17.
 */

public class DemoFragment extends MvpFragment<MvpView, DemoPresenter> {

    @Override
    public int setContentLayout() {
        return 0;
    }

    @Override
    public void initData(Bundle data) {

    }

    @Override
    public DemoPresenter initPresenter() {
        return new DemoPresenter();
    }

    @Override
    public void getData(String data) {

    }

}
