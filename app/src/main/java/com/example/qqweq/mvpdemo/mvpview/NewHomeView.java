package com.example.qqweq.mvpdemo.mvpview;

import com.example.qqweq.mvpdemo.bean.ObjectModel;
import com.example.qqweq.mvpdemo.mvp.BaseView;

import java.util.List;

/**
 * Created by qqweq on 2018/9/29.
 */

public interface NewHomeView extends BaseView {
   void getObject(List<ObjectModel> objectModel);
}
