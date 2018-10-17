package com.example.qqweq.mvpdemo.presenter;

import com.example.qqweq.mvpdemo.bean.SectionModel;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;
import com.example.qqweq.mvpdemo.mvp.BasePresenter;
import com.example.qqweq.mvpdemo.mvpview.ChapterTreeStatusView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * Created by qqweq on 2018/10/16.
 */

public class ChapterTreeStatusPresenter extends BasePresenter<ChapterTreeStatusView> {
    public void getChapterTress() {
        RxClient.getCourse()
                .compose(RxClient.<List<SectionModel>>create())
                .subscribe(new ApiSubscriber<List<SectionModel>>(mContext) {
                    @Override
                    public void onNext(List<SectionModel> loginModel) {
                        getView().getChapterTreeStatus(loginModel);
                    }
                });
        RxClient.getCode()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<RequestBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RequestBody body) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
