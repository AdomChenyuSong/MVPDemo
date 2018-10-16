package com.example.qqweq.mvpdemo.base;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.bean.SectionModel;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvpview.ChapterTreeStatusView;
import com.example.qqweq.mvpdemo.presenter.ChapterTreeStatusPresenter;

import java.util.List;

/**
 * Created by qqweq on 2018/10/16.
 */

public class ChapterTreeStatusFragment extends MvpFragment<ChapterTreeStatusView, ChapterTreeStatusPresenter> implements ChapterTreeStatusView {
    private LinearLayout ll_tree_views;
    private ChapterTreeStatusPresenter presenter;

    @Override
    public int setContentLayout() {
        return R.layout.fragment_chapter_tree_status;
    }

    @Override
    public void initData(Bundle data) {
        presenter.getChapterTress();
    }

    @Override
    public void initView(View view) {
        ll_tree_views = view.findViewById(R.id.ll_tree_views);
    }

    @Override
    public ChapterTreeStatusPresenter initPresenter() {
        presenter = new ChapterTreeStatusPresenter();
        return presenter;
    }

    @Override
    public void getChapterTreeStatus(List<SectionModel> sectionModels) {
        if (sectionModels == null || sectionModels.size() == 0) {
            showNoData();
        }
        setMode(sectionModels);
    }

    public void setMode(List<SectionModel> sectionModels) {
        for (SectionModel model : sectionModels) {
            Log.e("SCY", model.getName());
            if (model != null && model.getChildren() != null && model.getChildren().size() > 0) {
                setMode(model.getChildren());
            }
        }
    }
}
