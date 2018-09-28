package com.example.qqweq.mvpdemo.presenter;

import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;
import com.example.qqweq.mvpdemo.mvpview.WelcomeView;
import com.example.qqweq.mvpdemo.mvp.BasePresenter;

/**
 * Created by qqweq on 2018/9/15.
 */

public class WelcomeFresenter extends BasePresenter<WelcomeView> {
    public void getVersion() {
        RxClient.getVersion(1)
                .compose(RxClient.<AppVersionModel>create())
                .subscribe(new ApiSubscriber<AppVersionModel>(mContext) {
                    @Override
                    public void onNext(AppVersionModel appVersionModel) {
                        getView().getVersion(appVersionModel);
                    }
                });
    }
}
