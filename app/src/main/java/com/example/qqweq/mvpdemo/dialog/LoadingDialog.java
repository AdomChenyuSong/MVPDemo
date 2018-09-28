package com.example.qqweq.mvpdemo.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.qqweq.mvpdemo.R;

/**
 * Created by qqweq on 2018/9/11.
 */

/**
 * 正在加载loading
 * Created by tjy on 2017/6/19.
 */
public class LoadingDialog extends BaseDialog {
    private TextView tipTextView;
    private Activity context;

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    protected void initView(View view) {
        tipTextView = view.findViewById(R.id.tipTextView);
    }

    public void setTipTextView(int resID) {
        String string = context.getString(resID);
        setTipTextView(string);
    }

    public void setTipTextView(String text) {
        if (tipTextView != null) {
            tipTextView.setText(text);
        }
    }

    public LoadingDialog(Activity context) {
        super(context, R.style.MyDialogStyle);
        this.context = context;
    }
}
