package com.example.qqweq.mvpdemo.fragment.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseRecycleFragment;
import com.example.qqweq.mvpdemo.bean.SectionModel;
import com.example.qqweq.mvpdemo.common.CommonAdapter;
import com.example.qqweq.mvpdemo.common.base.ViewHolder;
import com.example.qqweq.mvpdemo.connection.ApiSubscriber;
import com.example.qqweq.mvpdemo.connection.RxClient;

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
                .compose(RxClient.<List<SectionModel>>create())
                .subscribe(new ApiSubscriber<List<SectionModel>>(getActivity()) {
                    @Override
                    public void onNext(List<SectionModel> modelList) {
                        courseAdapter.addAllAdapterDatas(modelList);
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
            holder.setText(R.id.chapter_name, sectionModel.getName());
        }
    }


}
