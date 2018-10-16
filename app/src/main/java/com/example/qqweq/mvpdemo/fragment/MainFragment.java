package com.example.qqweq.mvpdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqweq on 2018/10/9.
 */

public class MainFragment extends BaseFragment implements TabFragment.tabChangListener {
    private TabFragment tabFragment;
    private HomeFragment homeFragment;


    @Override
    public int setContentLayout() {
        return R.layout.activity_main_fragment;
    }

    @Override
    public void initData(Bundle data) {
        homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getfragmentTransaction();
        fragmentTransaction.add(R.id.frame_tab, tabFragment);
        fragmentTransaction.add(R.id.frame_container, homeFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void initView(View view) {
        tabFragment = new TabFragment();
        tabFragment.setListener(this);
    }

    @Override
    public void tabChange(int position) {
        homeFragment.changeFragment(position);
    }
}
