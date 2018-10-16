package com.example.qqweq.mvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.fragment.tab.MyStatusFragment;
import com.example.qqweq.mvpdemo.fragment.tab.TabMyStatusFragment;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvpview.HomeView;
import com.example.qqweq.mvpdemo.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqweq on 2018/9/28.
 */

public class HomeFragment extends MvpFragment<HomeView, HomePresenter> {
    HomePresenter homePresenter;
    private String TAG = HomeFragment.class.getName();
    private List<Fragment> fragmentList = new ArrayList<>(9);

    @Override
    public HomePresenter initPresenter() {
        homePresenter = new HomePresenter();
        return homePresenter;
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initData(Bundle data) {
        FragmentTransaction transaction = getfragmentTransaction();
        transaction.replace(R.id.fl_home, new TabMyStatusFragment());
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void initView(View view) {

    }
    public void changeFragment(int position){
//        Fragment fragment = fragmentList.get(position);
//        if (fragment==null){
//
//        }
    }
}
