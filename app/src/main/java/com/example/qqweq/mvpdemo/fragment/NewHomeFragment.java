package com.example.qqweq.mvpdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.bean.ObjectModel;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvpview.NewHomeView;
import com.example.qqweq.mvpdemo.presenter.NewHomePresenter;
import com.example.qqweq.mvpdemo.view.WrapLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqweq on 2018/9/29.
 */

public class NewHomeFragment extends MvpFragment<NewHomeView, NewHomePresenter> implements NewHomeView {
    private NewHomePresenter newHomePresenter;
    private WrapLayout myFlowLayout;

    @Override
    public NewHomePresenter initPresenter() {
        newHomePresenter = new NewHomePresenter();
        return newHomePresenter;
    }

    @Override
    public int setContentLayout() {
        return R.layout.activity_new_main;
    }

    @Override
    public void initData(Bundle data) {
        newHomePresenter.getObject();
    }

    @Override
    public void initView(View view) {
        myFlowLayout = view.findViewById(R.id.myFlowLayout);
        FragmentTransaction fragmentTransaction = getfragmentTransaction();
        fragmentTransaction.add(R.id.fr_gridview, new TitleFragment());
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void getObject(List<ObjectModel> objectModel) {
        if (objectModel == null || objectModel.size() == 0) {
            return;
        }
        final List<String> list = new ArrayList<>();
        for (ObjectModel model : objectModel) {
            list.add(model.getTitle());
        }
        myFlowLayout.setMarkClickListener(new WrapLayout.MarkClickListener() {
            @Override
            public void clickMark(int position) {

            }
        });
        myFlowLayout.setData(list, getContext(), 10, 0, 0, 0, 0, 25, 0, 0, 0, 120, 50);
    }
}
