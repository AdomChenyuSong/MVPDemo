package com.example.qqweq.mvpdemo.fragment;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.dialog.LoadingDialog;
import com.example.qqweq.mvpdemo.dialog.NormalDialog;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;

/**
 * Created by qqweq on 2018/9/15.
 */

public class WelcomeFragment extends MvpFragment<WelcomeView, WelcomeFresenter> implements WelcomeView {
    private WelcomeFresenter welcomeFresenter;

    @Override
    public int setContentLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initData(Bundle data) {

    }

    @Override
    public void initView(View view) {
        welcomeFresenter.getVersion();
    }

    @Override
    public WelcomeFresenter initPresenter() {
        welcomeFresenter = new WelcomeFresenter();
        return welcomeFresenter;
    }

    @Override
    public void getVersion(AppVersionModel versionCode) {
        if (versionCode.getIslast() != 2) {
            NormalDialog normalDialog = new NormalDialog(getContext());
            normalDialog.setMessage(versionCode.getContent());
            normalDialog.setClickListener(new NormalDialog.setClickListener() {
                @Override
                public void setClickListener(int type) {

                }
            });
            normalDialog.show();
            // 将对话框的大小按屏幕大小的百分比设置
            WindowManager windowManager = getActivity().getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            WindowManager.LayoutParams lp = normalDialog.getWindow().getAttributes();
            lp.width = (int) (display.getWidth() * 0.40); //设置宽度
            lp.height = (int) (display.getHeight() * 0.40);
            normalDialog.getWindow().setAttributes(lp);
        }
    }
}
