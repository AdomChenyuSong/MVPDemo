package com.example.qqweq.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.qqweq.mvpdemo.R;

import java.io.IOException;

/**
 * 主要是封装基础类
 * Created by qqweq on 2018/7/16.
 */

public abstract class BaseFragment extends Fragment {
    private FrameLayout fl_container;
    private ViewStub viewstub_error_page;
    private ViewStub viewstub_no_data;
    private Button bt_error_refresh;
    private ImageView img_no_data;
    private int img_no_data_rescoure;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment, null, false);
        initBaseView(view);
        addContentView(inflater);
        initView(view);
        Bundle bundle = getArguments();
        if (bundle == null) {
            bundle = savedInstanceState;
        }
        initData(bundle);
        return view;
    }

    /**
     * 添加布局
     *
     * @param inflater
     */
    private void addContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(setContentLayout(), null, false);
        fl_container.addView(contentView);
    }

    public FragmentTransaction getfragmentTransaction() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        return transaction;
    }

    /**
     * 绑定
     *
     * @param view
     * @return
     */
    private View initBaseView(View view) {
        fl_container = view.findViewById(R.id.fl_container);
        viewstub_error_page = view.findViewById(R.id.viewstub_error_page);
        viewstub_no_data = view.findViewById(R.id.viewstub_no_data);
        bt_error_refresh = view.findViewById(R.id.bt_error_refresh);
        img_no_data = view.findViewById(R.id.img_no_data);
        if (img_no_data_rescoure > 0) {
            setEmptyImage(getImageRescoure());
        }
        return view;
    }

    /**
     * 展示错误页面
     */
    public void showErrorPage() {
        viewstub_error_page.inflate();
        viewstub_no_data.setVisibility(View.GONE);
        fl_container.setVisibility(View.GONE);
    }

    /**
     * 展示无数据
     */
    public void showNoData() {
        viewstub_error_page.inflate();
        viewstub_no_data.setVisibility(View.GONE);
        fl_container.setVisibility(View.GONE);
    }

    /**
     * 刷新界面
     */
    public void setRefresh() {
        viewstub_error_page.setVisibility(View.GONE);
        viewstub_no_data.setVisibility(View.GONE);
        fl_container.setVisibility(View.VISIBLE);
    }

    /**
     * 可自定义数据为空状态下图片
     *
     * @param rescoure
     */
    public void setEmptyImage(int rescoure) {
        img_no_data.setImageResource(rescoure);
        img_no_data.invalidate();
    }

    public void setEmptyImageRescoure(int rescoure) {
        this.img_no_data_rescoure = rescoure;
    }

    public int getImageRescoure() {
        return img_no_data_rescoure;
    }

    public abstract int setContentLayout();

    public abstract void initData(Bundle data);

    public abstract void initView(View view);

}
