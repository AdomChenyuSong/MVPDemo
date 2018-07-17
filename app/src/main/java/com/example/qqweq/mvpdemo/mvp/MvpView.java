package com.example.qqweq.mvpdemo.mvp;

/**
 * Created by qqweq on 2018/7/17.
 */

public interface MvpView extends BaseView {
    /**
     * 数据源接口
     *
     * @param data
     */
    void getData(String data);
}
