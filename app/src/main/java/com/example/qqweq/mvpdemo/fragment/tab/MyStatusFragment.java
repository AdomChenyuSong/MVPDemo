package com.example.qqweq.mvpdemo.fragment.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseCommenAdapter;
import com.example.qqweq.mvpdemo.base.BaseListFragment;
import com.example.qqweq.mvpdemo.base.BaseRecycleFragment;
import com.example.qqweq.mvpdemo.bean.SectionModel;
import com.example.qqweq.mvpdemo.common.CommonAdapter;
import com.example.qqweq.mvpdemo.common.MultiItemTypeAdapter;
import com.example.qqweq.mvpdemo.common.base.ViewHolder;
import com.example.qqweq.mvpdemo.connection.BaseListProvider;
import com.example.qqweq.mvpdemo.connection.RxClient;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvpview.MyStatusView;
import com.example.qqweq.mvpdemo.presenter.MyStatusPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qqweq on 2018/10/11.
 */

public class MyStatusFragment extends BaseRecycleFragment {
    private List<SectionModel> modelList = new ArrayList<>();
    private CourseAdapter courseAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxClient.getCourse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<SectionModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<SectionModel> modelList) {
                        courseAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public RecyclerView.LayoutManager manager() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        return manager;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        courseAdapter = new CourseAdapter(getActivity(), R.layout.item_chapter, modelList);
        return courseAdapter;
    }

    private class CourseAdapter extends CommonAdapter<SectionModel> {
        public CourseAdapter(Context context, int layoutId, List<SectionModel> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder holder, SectionModel sectionModel, int position) {

        }
    }


}
