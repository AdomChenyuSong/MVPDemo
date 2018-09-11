package com.example.qqweq.mvpdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.example.qqweq.mvpdemo.base.BaseActivity;
import com.example.qqweq.mvpdemo.bean.FinishedDataBean;
import com.example.qqweq.mvpdemo.demomvp.DemoFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity {

    @Override
    protected int setContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

//        List<String> list = new ArrayList<String>();
//        for (int i = 0; i < 100; i++) {
//            list.add(i + "");
//        }
//        Observable<String> observable = Observable.fromIterable(list);
//        Observer observer = new Observer() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Object o) {
//                Log.e("SCY", " - - - --  " + o);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e("SCY", " - - - onComplete -- -- ");
//            }
//        };
//        observable.subscribe(observer);
    }
//
//    public static class TestEvent {
//        public String test;
//
//        public TestEvent(String test) {
//            this.test = test;
//        }
//    }
//
//    public static class TestEventTwo {
//        public String test;
//
//        public TestEventTwo(String test) {
//            this.test = test;
//        }
//    }
//
//    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true, priority = 100)
//    public void onEventTest(final TestEvent dataBean) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainActivity.this, "POSTING" + dataBean.test, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMainEventTest(TestEventTwo dataBean) {
//        Toast.makeText(this, "MAIN", Toast.LENGTH_SHORT).show();
//    }

    @Override
    protected void initData(Bundle bundle) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_container, new DemoFragment());
        transaction.commitAllowingStateLoss();
    }
}
