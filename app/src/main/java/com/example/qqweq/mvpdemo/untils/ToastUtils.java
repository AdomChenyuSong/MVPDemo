package com.example.qqweq.mvpdemo.untils;

import android.content.Context;
import android.widget.Toast;

import static com.example.qqweq.mvpdemo.MvpApplication.mvpApplication;

/**
 * Created by qqweq on 2018/9/11.
 */

public class ToastUtils {
    private static Toast mShortToast;
    private static Toast mLongToast;
    private static Context context = mvpApplication;

    public static void showToast(String message) {
        if (mShortToast == null) {
            mShortToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        mShortToast.setText(message);
        mShortToast.show();
    }

    public static void showToast(int resId) {
        if (mShortToast == null) {
            mShortToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        }
        mShortToast.setText(context.getString(resId));
        mShortToast.show();
    }

}
