package com.example.qqweq.mvpdemo.presenter;

import com.example.qqweq.mvpdemo.bean.LoginModel;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;
import com.example.qqweq.mvpdemo.mvp.BasePresenter;
import com.example.qqweq.mvpdemo.mvpview.HomeView;
import com.example.qqweq.mvpdemo.mvpview.LoginView;

/**
 * Created by qqweq on 2018/9/17.
 */

public class HomePresenter extends BasePresenter<HomeView> {
    public void setLogin(String userName, String passWord) {
        RxClient.setLogin(userName, passWord)
                .compose(RxClient.<LoginModel>create())
                .subscribe(new ApiSubscriber<LoginModel>(mContext) {
                    @Override
                    public void onNext(LoginModel loginModel) {
                        getView().getLogin(loginModel);
                    }
                });
    }
}
