package com.example.qqweq.mvpdemo.fragment;

import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.mvp.BaseView;

/**
 * Created by qqweq on 2018/9/15.
 */

public interface WelcomeView extends BaseView{
    void getVersion(AppVersionModel model);
}
