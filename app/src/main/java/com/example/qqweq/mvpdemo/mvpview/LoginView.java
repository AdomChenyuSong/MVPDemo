package com.example.qqweq.mvpdemo.mvpview;

import com.example.qqweq.mvpdemo.bean.LoginModel;
import com.example.qqweq.mvpdemo.mvp.BaseView;

/**
 * Created by qqweq on 2018/9/17.
 */

public interface LoginView extends BaseView {
    public void getLogin(LoginModel loginModel);
}
