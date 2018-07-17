package com.example.qqweq.mvpdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.untils.StatusBarUtil;

/**
 * Created by qqweq on 2018/7/13.
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView title;

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        setContentView(addContentView(inflater));
        setStatusBarColor(ContextCompat.getColor(this, R.color.app_bg));
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = savedInstanceState;
        }
        initData(bundle);
    }

    /**
     * 设置状态栏颜色
     */
    public void setStatusBarColor(int resColor) {
        StatusBarUtil.setWindowStatusBarColor(this, resColor, true);
    }

    protected abstract int setContentLayout();

    protected abstract void initData(Bundle bundle);

    public View addContentView(LayoutInflater inflater) {
        LinearLayout mParentView = (LinearLayout) inflater.inflate(R.layout.base_activity, null);
        View subActivityView = inflater.inflate(setContentLayout(), null);
        mParentView.addView(subActivityView);
        initBaseView(mParentView);
        return mParentView;
    }

    private void initBaseView(View view) {
        iv_back = view.findViewById(R.id.img_back);
        title = view.findViewById(R.id.tv_title);
        iv_back.setOnClickListener(this);
    }

    public Context getContext() {
        return BaseActivity.this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}