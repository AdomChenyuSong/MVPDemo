package com.example.qqweq.mvpdemo.base;

/**
 * Created by qqweq on 2018/10/8.
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.qqweq.mvpdemo.R;

/**
 * Created by qqweq on 2018/7/26.
 */

public abstract class BaseRecycleFragment extends BaseFragment implements BaseCommenAdapter.OnRecyclerItemClickListener, BaseCommenAdapter.onRecyclerItemLongClickListener {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle, null, true);
        initView(view);
        return view;
    }

    public void initView(View mView) {
        recyclerView = mView.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(getOrientation());
        recyclerView.setLayoutManager(linearLayoutManager);
        BaseCommenAdapter adapter = getAdapter();
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    public abstract int getOrientation();

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public abstract BaseCommenAdapter getAdapter();

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

}
