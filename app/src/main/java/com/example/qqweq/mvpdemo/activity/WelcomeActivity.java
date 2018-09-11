package com.example.qqweq.mvpdemo.activity;

import android.os.Bundle;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseActivity;
import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.bean.BaseEntity;
import com.example.qqweq.mvpdemo.connection.ApiException;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qqweq on 2018/9/10.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    protected int setContentLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle bundle) {
//        RxClient.getVersion(1).compose(DefaultTransformer.<BaseEntity<AppVersionModel>>create())
//                .subscribe(new ApiSubscriber<BaseEntity<AppVersionModel>>(this) {
//                    @Override
//                    public void onNext(BaseEntity<AppVersionModel> appVersionModelBaseEntity) {
//
//                    }
//                });

    }

    public class DefaultTransformer<T> implements ObservableTransformer<T, T> {

        @Override
        public ObservableSource<T> apply(Observable<T> upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(new Function<T, T>() {
                        @Override
                        public T apply(T t) throws Exception {
                            int status_code = ((BaseEntity<T>) t).getStatus_code();
                            String status_msg = ((BaseEntity<T>) t).getError_msg();
                            if (status_code != 200) {
                                throw new ApiException(status_code, status_msg);
                            }
                            return t;
                        }
                    });
        }
    }

    public <T> DefaultTransformer<T> create() {
        return new DefaultTransformer<>();
    }
}
