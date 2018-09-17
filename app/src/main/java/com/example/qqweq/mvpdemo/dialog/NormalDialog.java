package com.example.qqweq.mvpdemo.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.qqweq.mvpdemo.R;

/**
 * Created by qqweq on 2018/9/13.
 */

public class NormalDialog extends BaseDialog implements View.OnClickListener {
    private TextView dialog_tv_msg;
    private TextView dialog_tv_confirm;
    private TextView dialog_tv_cancel;
    private setClickListener listener;
    private Context mContext;

    public NormalDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_custom_con;
    }

    @Override
    protected void initView(View view) {
        dialog_tv_msg = view.findViewById(R.id.dialog_tv_msg);
        dialog_tv_confirm = view.findViewById(R.id.dialog_tv_confirm);
        dialog_tv_cancel = view.findViewById(R.id.dialog_tv_cancel);
        dialog_tv_confirm.setOnClickListener(this);
        dialog_tv_cancel.setOnClickListener(this);
    }

    /**
     * 资源ID信息
     *
     * @param resId
     */
    public void setMessage(int resId) {
        String string = mContext.getString(resId);
        setMessage(string);
    }

    /**
     * 设置信息
     *
     * @param message
     */
    public void setMessage(String message) {
        if (dialog_tv_msg != null) {
            dialog_tv_msg.setText(message);
        }
    }

    @Override
    public void onClick(View v) {
        checkForNum();
        switch (v.getId()) {
            case R.id.dialog_tv_confirm:
                listener.setClickListener(1);
                break;
            case R.id.dialog_tv_cancel:
                dismiss();
                listener.setClickListener(2);
                break;
        }
    }

    private void checkForNum() {
        if (listener == null) {
            return;
        }
    }

    public void setClickListener(setClickListener clickListener) {
        listener = clickListener;
    }

    public interface setClickListener {
        //1 代表确认 2 代表取消
        public void setClickListener(int type);
    }
}
