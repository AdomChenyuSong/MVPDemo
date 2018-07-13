package com.example.qqweq.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.qqweq.mvpdemo.R;

/**
 * Created by qqweq on 2018/7/13.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private FrameLayout fl_container;

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
        setContentView(R.layout.base_activity);

    }

    public final void initView() {

    }

    public abstract int getConstainerLayout();
}
