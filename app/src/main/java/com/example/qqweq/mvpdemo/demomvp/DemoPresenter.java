package com.example.qqweq.mvpdemo.demomvp;

import com.example.qqweq.mvpdemo.mvp.BasePresenter;
import com.example.qqweq.mvpdemo.mvp.MvpView;

/**
 * Created by qqweq on 2018/7/17.
 */

public class DemoPresenter extends BasePresenter<MvpView> {
    public void getData() {
        getView().getData("hai");
//        mCall.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
    }

}
