package com.example.qqweq.mvpdemo.demomvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvp.MvpView;

/**
 * Created by qqweq on 2018/7/17.
 */

public class DemoFragment extends MvpFragment<MvpView, DemoPresenter> implements MvpView{
    private TextView tv_name;

    @Override
    public int setContentLayout() {
        return R.layout.fragment_demo;
    }

    @Override
    public void initData(Bundle data) {
        mPresenter.getData();
    }

    @Override
    public void initView(View mView) {
        tv_name=mView.findViewById(R.id.tv_name);

    }

    @Override
    public DemoPresenter initPresenter() {
        return new DemoPresenter();
    }

    @Override
    public void getData(String data) {
        tv_name.setText(data);
    }
}
