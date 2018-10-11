package com.example.qqweq.mvpdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseCommenAdapter;
import com.example.qqweq.mvpdemo.base.BaseRecycleFragment;
import com.example.qqweq.mvpdemo.common.base.ViewHolder;
import com.example.qqweq.mvpdemo.view.ColorProgressView;
import com.example.qqweq.mvpdemo.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by qqweq on 2018/10/9.
 */

public class TitleFragment extends BaseRecycleFragment {
    public int names[] = {R.string.chapter_state, R.string.self_test, R.string.pretest_sprint, R.string.home_work, R.string.practice_with_the_hall, R.string.test_evaluation, R.string.online_classroom, R.string.wrong_title_summary, R.string.ask_for_explanation};
    public int picture[] = {R.drawable.new_main_chapter, R.drawable.new_main_testing, R.drawable.new_main_sprint, R.drawable.new_main_work, R.drawable.new_main_practice, R.drawable.new_main_exam, R.drawable.new_main_class, R.drawable.new_main_errors, R.drawable.new_main_explain};

    @Override
    public RecyclerView.LayoutManager manager() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 5);
        return manager;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getRecyclerView().addItemDecoration(new SpacesItemDecoration(10, 0));
    }

    @Override
    public BaseCommenAdapter getAdapter() {
        List<Integer> resultList = new ArrayList<>(names.length);
        for (Integer name : names) {
            resultList.add(name);
        }
        TitleAdapter titleAdapter = new TitleAdapter(getActivity(), R.layout.item_gridview, resultList);
        return titleAdapter;
    }

    private class TitleAdapter extends BaseCommenAdapter<Integer> {

        public TitleAdapter(Context context, int layoutId, List<Integer> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(final ViewHolder holder, Integer name, int position) {
            holder.setText(R.id.gv_names, getString(name));
            holder.setImageResource(R.id.gv_image, picture[position]);
            final ColorProgressView colorProgressView = holder.getView(R.id.seekar_circular);
            holder.setOnClickListener(R.id.cl_item_info, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    times(colorProgressView);
                }
            });
        }
    }

    // 参数说明：
    // 参数1 = 事件序列起始点；
    // 参数2 = 事件数量；
    // 参数3 = 第1次事件延迟发送时间；
    // 参数4 = 间隔时间数字；
    // 参数5 = 时间单位
    boolean isStart = false;

    private void times(final ColorProgressView colorProgressView) {
        if (isStart) {
            return;
        }
        isStart = true;
        Observable.intervalRange(1, 100, 5, 6, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                // 该例子发送的事件序列特点：
                // 1. 从3开始，一共发送10个事件；
                // 2. 第1次延迟2s发送，之后每隔2秒产生1个数字（从0开始递增1，无限个）
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        colorProgressView.setMaxCount(99);
                        colorProgressView.setScroce(99 + "");
                    }
                    // 默认最先调用复写的 onSubscribe（）

                    @Override
                    public void onNext(Long value) {
                        colorProgressView.setCurrentCount(value);
                        colorProgressView.invalidate();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        isStart = false;
                        changeFragment(new MainFragment());
                    }

                });
    }
}
