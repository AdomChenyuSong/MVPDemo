package com.example.qqweq.mvpdemo.base.tree;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseCommenAdapter;
import com.example.qqweq.mvpdemo.base.BaseRecycleFragment;
import com.example.qqweq.mvpdemo.bean.SectionModel;
import com.example.qqweq.mvpdemo.common.MultiItemTypeAdapter;
import com.example.qqweq.mvpdemo.common.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqweq on 2018/10/17.
 */

public class TreeStatusFragment extends BaseRecycleFragment {
    private MyTreeAdapter myTreeAdapter;
    private List<SectionModel> list = new ArrayList<>();

    @Override
    public RecyclerView.LayoutManager manager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return linearLayoutManager;
    }

    private TreeStatusFragment.setTreeChapterListener chapterListener;

    public TreeStatusFragment.setTreeChapterListener getChapterListener() {
        return chapterListener;
    }

    public void setChapterListener(TreeStatusFragment.setTreeChapterListener chapterListener) {
        this.chapterListener = chapterListener;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        myTreeAdapter = new MyTreeAdapter(getActivity(), R.layout.layout_text_select, list);
        myTreeAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (getChapterListener() != null) {
                    mPosition = position;
                    myTreeAdapter.notifyDataSetChanged();
                    chapterListener.treeChapter(position, list.get(position).getType());
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        return myTreeAdapter;
    }


    public void changeData(List<SectionModel> models) {
        myTreeAdapter.addAllData(models);
    }

    public interface setTreeChapterListener {
        public void treeChapter(int position, int type);
    }

    private int mPosition = 0;

    class MyTreeAdapter extends BaseCommenAdapter<SectionModel> {


        public MyTreeAdapter(Context context, int layoutId, List<SectionModel> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder holder, SectionModel sectionModel, int position) {
            holder.setText(R.id.select_tv_name, sectionModel.getName());
            if (mPosition == position) {
                holder.setVisible(R.id.select_iv_math, true);
            } else {
                holder.setVisible(R.id.select_iv_math, false);
            }

        }
    }
}
