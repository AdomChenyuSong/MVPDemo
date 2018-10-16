package com.example.qqweq.mvpdemo.fragment.tab;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.base.BaseFragment;

/**
 * Created by qqweq on 2018/10/11.
 */

public class TabMyStatusFragment extends BaseFragment {
    @Override
    public int setContentLayout() {
        return R.layout.fragment_my_status;
    }

    @Override
    public void initData(Bundle data) {
        FragmentTransaction fragmentTransaction = getfragmentTransaction();
        fragmentTransaction.add(R.id.fl_body, new MyStatusFragment());
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void initView(View view) {

    }
}
