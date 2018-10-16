package com.example.qqweq.mvpdemo.presenter;

import com.example.qqweq.mvpdemo.bean.SectionModel;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;
import com.example.qqweq.mvpdemo.mvp.BasePresenter;
import com.example.qqweq.mvpdemo.mvpview.ChapterTreeStatusView;

import java.util.List;

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
    }
}
