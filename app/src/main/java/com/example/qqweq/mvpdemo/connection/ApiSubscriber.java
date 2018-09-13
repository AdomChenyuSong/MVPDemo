package com.example.qqweq.mvpdemo.connection;

import android.app.Dialog;
import android.content.Context;

import com.example.qqweq.mvpdemo.dialog.LoadingDialog;
import com.example.qqweq.mvpdemo.untils.ToastUtils;
import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 统一增加弹窗类
 * Created by qqweq on 2018/9/11.
 */

public abstract class ApiSubscriber<T> implements Observer<T> {
    private Dialog loadingDialog;
    private Context mContext;

    public ApiSubscriber(@NonNull Context context) {
        mContext = context;
    }

    @Override
    public void onComplete() {
        dismiss();
    }

    @Override
    public void onSubscribe(Disposable d) {
        loadingDialog = new LoadingDialog(mContext);
        loadingDialog.show();
    }

    @Override
    public void onError(Throwable e) {
        dismiss();
        if (e instanceof ApiException) {
            //处理服务器返回的错误
            ToastUtils.showToast("日志报错信息＝"+((ApiException) e).getCode());
        } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
            ToastUtils.showToast("网络异常，请检查网络");
        } else if (e instanceof TimeoutException || e instanceof SocketTimeoutException) {
            ToastUtils.showToast("网络不畅，请稍后再试！");
        } else if (e instanceof JsonSyntaxException) {
            ToastUtils.showToast("数据解析异常");
        } else {
            ToastUtils.showToast("服务端错误");
        }
        e.printStackTrace();
    }

    private final void dismiss() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
}
