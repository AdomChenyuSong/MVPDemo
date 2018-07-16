package com.example.qqweq.mvpdemo.connection;

import com.example.qqweq.mvpdemo.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qqweq on 2018/2/28.
 */

public class BaseRetrofit {
    private Retrofit retrofit;

    private BaseRetrofit() {
        init();
    }

    public void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Configuration.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//新的配置
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    MyService upApiService() {
        return retrofit.create(MyService.class);
    }

    private volatile static BaseRetrofit INSTANCE = null;

    //获取单例
    public static BaseRetrofit getInstance() {
        if (INSTANCE == null) {
            synchronized (BaseRetrofit.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BaseRetrofit();
                }
            }
        }
        return INSTANCE;
    }
}