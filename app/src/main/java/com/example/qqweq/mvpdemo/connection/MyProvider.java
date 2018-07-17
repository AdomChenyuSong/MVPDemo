package com.example.qqweq.mvpdemo.connection;

import android.support.annotation.NonNull;
import com.example.qqweq.mvpdemo.bean.FinishedDataBean;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by qqweq on 2018/5/9.
 */

public class MyProvider extends DefaultListProvider<FinishedDataBean> {
    @NonNull
    @Override
    public Observable<List<FinishedDataBean>> makeObservable() {
        return RxClient.getDisReviewedList(1, 10);
    }
}
