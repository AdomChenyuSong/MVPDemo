package com.example.qqweq.mvpdemo.presenter;

import com.example.qqweq.mvpdemo.bean.LoginModel;
import com.example.qqweq.mvpdemo.bean.ObjectModel;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;
import com.example.qqweq.mvpdemo.mvp.BasePresenter;
import com.example.qqweq.mvpdemo.mvpview.HomeView;
import com.example.qqweq.mvpdemo.mvpview.NewHomeView;
import com.example.qqweq.mvpdemo.untils.SharedPrefenceUtils;

import java.util.List;

/**
 * Created by qqweq on 2018/9/17.
 */

public class NewHomePresenter extends BasePresenter<NewHomeView> {
    public void getObject() {
        RxClient.getObject()
                .compose(RxClient.<List<ObjectModel>>create())
                .subscribe(new ApiSubscriber<List<ObjectModel>>(mContext) {
                    @Override
                    public void onNext(List<ObjectModel> loginModel) {
                        getView().getObject(loginModel);
                    }
                });
    }
}
