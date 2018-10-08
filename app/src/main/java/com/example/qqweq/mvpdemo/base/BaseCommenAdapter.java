package com.example.qqweq.mvpdemo.base;

import android.content.Context;
import android.view.View;
import com.example.qqweq.mvpdemo.common.CommonAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqweq on 2018/10/8.
 */

public abstract class BaseCommenAdapter<T> extends CommonAdapter<T> {
    private List<T> list;
    private OnRecyclerItemClickListener mOnItemClickListener;
    private onRecyclerItemLongClickListener mOnItemLongClickListener;

    public BaseCommenAdapter(Context context, int layoutId, List<T> datas) {
        super(context, layoutId, datas);
    }


    public interface OnRecyclerItemClickListener {
        public void onItemClick(View view, int position);
    }

    public interface onRecyclerItemLongClickListener {
        public void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnRecyclerItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public OnRecyclerItemClickListener getListener() {
        return mOnItemClickListener;
    }

    public void setOnItemLongClickListener(onRecyclerItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }
    public onRecyclerItemLongClickListener getLongListener() {
        return mOnItemLongClickListener;
    }
    public void clearData() {
        checkList();
        list.clear();
        notifyDataSetChanged();
    }

    private void checkList() {
        if (list == null) {
            list = new ArrayList<T>();
        }
    }

    public void addAllData(ArrayList<T> data) {
        checkList();
        list.addAll(list.size(), data);
    }

    /**
     * 向指定位置添加元素
     */
    public void addItem(int position, T value) {
        if (position > list.size()) {
            position = list.size();
        }
        if (position < 0) {
            position = 0;
        }
        list.add(position, value);
        notifyItemInserted(position);
    }

    /**
     * 移除指定位置元素
     */
    public T removeItem(int position) {
        if (position > list.size() - 1) {
            return null;
        }
        T value = list.remove(position);
        notifyItemRemoved(position);
        return value;
    }
}
