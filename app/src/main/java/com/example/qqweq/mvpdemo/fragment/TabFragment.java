package com.example.qqweq.mvpdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseCommenAdapter;
import com.example.qqweq.mvpdemo.base.BaseRecycleFragment;
import com.example.qqweq.mvpdemo.common.MultiItemTypeAdapter;
import com.example.qqweq.mvpdemo.common.base.ViewHolder;
import com.example.qqweq.mvpdemo.untils.ToastUtils;
import com.example.qqweq.mvpdemo.view.ColorProgressView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqweq on 2018/10/9.
 */

public class TabFragment extends BaseRecycleFragment {
    public int names[] = {R.string.chapter_state, R.string.self_test, R.string.pretest_sprint, R.string.home_work, R.string.practice_with_the_hall, R.string.test_evaluation, R.string.online_classroom, R.string.wrong_title_summary, R.string.ask_for_explanation};
    public int picture[] = {R.drawable.shape_tab_my_status, R.drawable.shape_tab_knowledge, R.drawable.shape_tab_pretest_sprint, R.drawable.shape_tab_homework, R.drawable.shape_tab_task, R.drawable.shape_tab_evaluating, R.drawable.shape_tab_micro_class, R.drawable.shape_tab_wrong_notes, R.drawable.shape_tab_explain};
    private tabChangListener listener;
    private String TAG=TabFragment.class.getName();
    @Override
    public RecyclerView.LayoutManager manager() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        return manager;
    }

    @Override
    public BaseCommenAdapter getAdapter() {
        List<Integer> resultList = new ArrayList<>(names.length);
        for (Integer name : names) {
            resultList.add(name);
        }
        final TitleAdapter titleAdapter = new TitleAdapter(getActivity(), R.layout.item_tab_title, resultList);
        titleAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                mPosition = position;
                titleAdapter.notifyDataSetChanged();
                if (getListener() != null) {
                    getListener().tabChange(position);
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        return titleAdapter;
    }

    private int mPosition = 0;

    private class TitleAdapter extends BaseCommenAdapter<Integer> {

        public TitleAdapter(Context context, int layoutId, List<Integer> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(final ViewHolder holder, Integer name, int position) {
            TextView home_tv_pretest_sprint = holder.getView(R.id.home_tv_pretest_sprint);
            ImageView home_iv_pretest_sprint = holder.getView(R.id.home_iv_pretest_sprint);
            ImageView home_iv_notify_pretest_sprint = holder.getView(R.id.home_iv_notify_pretest_sprint);
            home_tv_pretest_sprint.setText(names[position]);
            home_iv_pretest_sprint.setImageResource(picture[position]);
            if (position == mPosition) {
                home_tv_pretest_sprint.setSelected(true);
                home_iv_pretest_sprint.setSelected(true);
                home_iv_notify_pretest_sprint.setVisibility(View.VISIBLE);
            } else {
                home_tv_pretest_sprint.setSelected(false);
                home_iv_pretest_sprint.setSelected(false);
                home_iv_notify_pretest_sprint.setVisibility(View.GONE);
            }
        }
    }

    public interface tabChangListener {
        public void tabChange(int position);
    }

    public tabChangListener getListener() {
        return listener;
    }

    public void setListener(tabChangListener listener) {
        this.listener = listener;
    }

}
