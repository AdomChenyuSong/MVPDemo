package com.example.qqweq.mvpdemo.base;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.tree.TreeStatusFragment;
import com.example.qqweq.mvpdemo.base.tree.TreeStatusKnowledgesFragment;
import com.example.qqweq.mvpdemo.base.tree.TreeStatusSectionFragment;
import com.example.qqweq.mvpdemo.bean.SectionModel;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvpview.ChapterTreeStatusView;
import com.example.qqweq.mvpdemo.presenter.ChapterTreeStatusPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqweq on 2018/10/16.
 */

public class ChapterTreeStatusFragment extends MvpFragment<ChapterTreeStatusView, ChapterTreeStatusPresenter> implements ChapterTreeStatusView, TreeStatusFragment.setTreeChapterListener {
    private ChapterTreeStatusPresenter presenter;
    private TreeStatusFragment treeStatusFragment;
    private TreeStatusFragment treeStatusSectionFragment;
    private TreeStatusFragment treeStatusKnowledgesFragment;
    private List<SectionModel> sectionModels = new ArrayList<>();

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
        FragmentTransaction transaction = getfragmentTransaction();
        treeStatusFragment = new TreeStatusFragment();
        treeStatusFragment.setChapterListener(this);
        treeStatusSectionFragment = new TreeStatusFragment();
        treeStatusSectionFragment.setChapterListener(this);
        treeStatusKnowledgesFragment = new TreeStatusFragment();
        treeStatusSectionFragment.setChapterListener(this);
        transaction.add(R.id.fl_chaper, treeStatusFragment);
        transaction.add(R.id.fl_section, treeStatusSectionFragment);
        transaction.add(R.id.fl_knowledges, treeStatusKnowledgesFragment);
        transaction.commitAllowingStateLoss();
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
        this.sectionModels = sectionModels;
        int size = sectionModels.size();
        for (int i = 0; i < size; i++) {
            SectionModel model = sectionModels.get(i);
            model.setType(3);
        }
        treeStatusFragment.changeData(sectionModels);
    }

    @Override
    public void treeChapter(int position, int type) {
        List<SectionModel> children = sectionModels.get(position).getChildren();
        if (type == 3) {
            treeStatusSectionFragment.changeData(children);
        } else if (type == 1) {
            List<SectionModel> childrens = sectionModels.get(position).getChildren().get(position).getChildren();
            treeStatusKnowledgesFragment.changeData(childrens);
        }
    }
}
