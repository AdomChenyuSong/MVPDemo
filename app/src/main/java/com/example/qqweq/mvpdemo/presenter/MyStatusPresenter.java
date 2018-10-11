package com.example.qqweq.mvpdemo.presenter;

import com.example.qqweq.mvpdemo.bean.LoginModel;
import com.example.qqweq.mvpdemo.bean.ObjectModel;
import com.example.qqweq.mvpdemo.bean.SectionModel;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;
import com.example.qqweq.mvpdemo.mvp.BasePresenter;
import com.example.qqweq.mvpdemo.mvpview.HomeView;
import com.example.qqweq.mvpdemo.mvpview.MyStatusView;

import java.util.List;

/**
 * Created by qqweq on 2018/9/17.
 */

public class MyStatusPresenter extends BasePresenter<MyStatusView> {
    public void setCourse() {
        RxClient.getCourse()
                .compose(RxClient.<List<SectionModel>>create())
                .subscribe(new ApiSubscriber<List<SectionModel>>(mContext) {
                    @Override
                    public void onNext(List<SectionModel> loginModel) {
                        getView().getMyStatus(loginModel);
                    }
                });
    }
}
