package com.example.qqweq.mvpdemo.demomvp;

import com.example.qqweq.mvpdemo.mvp.BasePresenter;
import com.example.qqweq.mvpdemo.mvp.MvpView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by qqweq on 2018/7/17.
 */

public class DemoPresenter extends BasePresenter<MvpView> {
    public void getData() {
        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

}
