package com.example.qqweq.mvpdemo.demomvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qqweq.mvpdemo.MainActivity;
import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.bean.FinishedDataBean;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvp.MvpView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by qqweq on 2018/7/17.
 */

public class DemoFragment extends MvpFragment<MvpView, DemoPresenter> implements MvpView {
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
        tv_name = mView.findViewById(R.id.tv_name);
//        tv_name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EventBus.getDefault().post(new MainActivity.TestEvent("2222"));
//            }
//        });
    }

    @Override
    public DemoPresenter initPresenter() {
        return new DemoPresenter();
    }

    @Override
    public void getData(String data) {
        tv_name.setText(data);
    }


    @Override
    public void setEmptyImageRescoure(int rescoure) {
        super.setEmptyImageRescoure(rescoure);
    }
}
