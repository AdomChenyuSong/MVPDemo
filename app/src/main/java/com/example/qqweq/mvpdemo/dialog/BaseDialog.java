package com.example.qqweq.mvpdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 通用的dialog框架  需要完善
 * Created by qqweq on 2018/9/13.
 */

public abstract class BaseDialog extends Dialog {
    protected abstract int getLayoutId();

    protected abstract void initView(View view);

    public BaseDialog(@NonNull Context context) {
        super(context);
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private Context context;
    private boolean isCancelable = false;
    private boolean isCancelOutside = false;

    /**
     * 设置是否可以按返回键取消
     *
     * @param isCancelable
     * @return
     */

    public void setCancelable(boolean isCancelable) {
        this.isCancelable = isCancelable;
    }

    /**
     * 设置是否可以取消
     *
     * @param isCancelOutside
     * @return
     */
    public void setCancelOutside(boolean isCancelOutside) {
        this.isCancelOutside = isCancelOutside;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDialog();
    }

    public void createDialog() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(getLayoutId(), null, false);
        initView(view);
        setContentView(view);
        setCancelable(isCancelable);
        setCanceledOnTouchOutside(isCancelOutside);
    }
}
