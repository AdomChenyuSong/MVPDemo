package com.example.qqweq.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.example.qqweq.mvpdemo.R;

/**
 * Created by qqweq on 2018/7/16.
 */

public abstract class BaseFragment extends Fragment {
    private FrameLayout fl_container;
    private LinearLayout ll_base_error_content;
    private LinearLayout ll_layout_base_no_data;
    private Button bt_error_refresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment, null, false);
        initView(view);
        addContentView(inflater);
        Bundle bundle = getArguments();
        if (bundle == null) {
            bundle = savedInstanceState;
        }
        initData(bundle);
        return view;
    }

    private void addContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(setContentLayout(), null, false);
        fl_container.addView(contentView);
    }

    private View initView(View view) {
        fl_container = view.findViewById(R.id.fl_container);
        ll_base_error_content = view.findViewById(R.id.ll_base_error_content);
        ll_layout_base_no_data = view.findViewById(R.id.ll_layout_base_no_data);
        bt_error_refresh = view.findViewById(R.id.bt_error_refresh);
        return view;
    }

    public abstract int setContentLayout();

    public abstract void initData(Bundle data);

}
