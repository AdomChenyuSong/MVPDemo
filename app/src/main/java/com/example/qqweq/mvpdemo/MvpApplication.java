package com.example.qqweq.mvpdemo;

import android.app.Application;

import com.example.qqweq.mvpdemo.bean.FinishedDataBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;

/**
 * Created by qqweq on 2018/8/15.
 */

public class MvpApplication extends Application {
    public static MvpApplication mvpApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        mvpApplication=this;
    }
}
