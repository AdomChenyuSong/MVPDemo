package com.example.qqweq.mvpdemo.base;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by qqweq on 2018/10/16.
 */

public class BaseSwipeRefreshLayout implements SwipeRefreshLayout.OnRefreshListener {
    @Override
    public void onRefresh() {

    }

    public SwipeRefreshLayout swipeRefreshLayout;

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }
}
