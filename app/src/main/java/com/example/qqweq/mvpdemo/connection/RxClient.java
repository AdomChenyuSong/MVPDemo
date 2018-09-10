package com.example.qqweq.mvpdemo.connection;

import com.example.qqweq.mvpdemo.bean.FinishedDataBean;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by qqweq on 2018/2/28.
 */

public class RxClient<T> {
    /**
     * @param page
     * @param size
     * @return
     */
    public static Observable<List<FinishedDataBean>> getDisReviewedList(int page, int size) {

        return BaseRetrofit.getInstance().upApiService().getText(page, size, 1, 1, "");
    }

    private Observable<T> getTransform(Observable<T> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }


}
