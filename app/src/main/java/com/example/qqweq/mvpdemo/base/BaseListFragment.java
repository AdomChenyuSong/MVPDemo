package com.example.qqweq.mvpdemo.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.connection.BaseListProvider;
import com.example.qqweq.mvpdemo.connection.SCObserver;
import com.example.qqweq.mvpdemo.untils.AppRefreshUtils;
import java.util.List;


/**
 * Created by qqweq on 2018/5/3.
 */

public abstract class BaseListFragment<T> extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private View base_list_container;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter adapter;
    private BaseListProvider<T> provider;

    public abstract RecyclerView.Adapter createAdapter();

    public abstract BaseListProvider<T> createProvider();


    protected RecyclerView.Adapter getAdapter() {
        if (adapter == null) {
            adapter = createAdapter();
        }
        return adapter;
    }

    @Override
    public void onRefresh() {
        getProvider().refresh();
    }

    /**
     * @return 数据提供者
     */
    @NonNull
    protected final BaseListProvider getProvider() {
        if (provider == null) {
            provider = createProvider();
            provider.setSubscriber(getSubscriber());
        }
        return provider;
    }

    protected SCObserver<List<T>> getSubscriber() {
        return new SCObserver<List<T>>() {
            @Override
            public void onComplete() {
                setSwipeRefreshLayout(false);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                e.printStackTrace();
            }

            @Override
            public void onNext(List<T> list) {
                Log.e("SCY",list.toString());
                if (isAdded()) {
                    getAdapter().notifyDataSetChanged();
                }
            }

            @Override
            public void onStart() {
                super.onStart();
                setSwipeRefreshLayout(true);
            }
        };
    }

    public void setSwipeRefreshLayout(boolean isRefresh) {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(isRefresh);
        }
    }
    protected RecyclerView getRecyclerView() {
        return recyclerView;
    }

    protected SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_base_list;
    }

    @Override
    public void initView(View view) {
        base_list_container = view.findViewById(R.id.base_list_container);
        swipeRefreshLayout = view.findViewById(R.id.refresh_layout);
        recyclerView = view.findViewById(R.id.list_layout);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initData(Bundle bundle) {
        AppRefreshUtils.initRefresh(getActivity(), swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(getAdapter());
        getProvider().bindRecyclerView(recyclerView);
        getProvider().loadData(true);
    }

}
