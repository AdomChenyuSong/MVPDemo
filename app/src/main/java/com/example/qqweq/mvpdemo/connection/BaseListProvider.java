package com.example.qqweq.mvpdemo.connection;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by qqweq on 2018/5/3.
 */

public abstract class BaseListProvider<E> extends BaseProvider<List<E>> {
    private static final int LOAD_DATA_FROM_LAST_ITEM_COUNT = 2; //从最后的第几个item开始触发加载下一页

    /**
     * 获取数据的总数
     *
     * @return
     */
    public abstract int getItemCount();

    public abstract void loadNext();

    //是否已经加载完毕
    public boolean isEnd;

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    /**
     * 删除position对应数据
     *
     * @param position
     * @return
     */
    public abstract void removePosition(int position);

    /**
     * @param position
     * @return 对应数据
     */
    public abstract E getItem(int position);

    /**
     * @param position
     * @return 对应数据
     */
    public abstract void addData(int position, E data);

    /**
     * 只支持LinearLayoutManager.
     * 给RecyclerView添加翻页的监听
     *
     * @param recyclerView 列表
     */
    public void bindRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (manager.findLastVisibleItemPosition() > manager.getItemCount() - LOAD_DATA_FROM_LAST_ITEM_COUNT
                            && !isEnd() && !isLoading()) {
                        loadNext();
                    }
                }
            }
        });
    }
}
