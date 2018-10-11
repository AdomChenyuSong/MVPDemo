package com.example.qqweq.mvpdemo.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.qqweq.mvpdemo.R;
import com.example.qqweq.mvpdemo.bean.LoginModel;
import com.example.qqweq.mvpdemo.mvp.MvpFragment;
import com.example.qqweq.mvpdemo.mvpview.LoginView;
import com.example.qqweq.mvpdemo.presenter.LoginPresenter;
import com.example.qqweq.mvpdemo.untils.NetworkStateReceiver;
import com.example.qqweq.mvpdemo.untils.SharedPrefenceUtils;
import com.example.qqweq.mvpdemo.untils.ToastUtils;
import com.example.qqweq.mvpdemo.untils.Utils;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by qqweq on 2018/9/17.
 */

public class LoginFragment extends MvpFragment<LoginView, LoginPresenter> implements View.OnClickListener, LoginView {
    private LoginPresenter loginPresenter;
    private EditText login_et_user;
    private EditText login_et_textPassword;
    private ImageView login_iv_clean_pass;
    private ImageView login_iv_clean_user;
    private Button login_tv_login;

    @Override
    public LoginPresenter initPresenter() {
        loginPresenter = new LoginPresenter();
        return loginPresenter;
    }

    @Override
    public int setContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initData(Bundle data) {
//       new Thread(new Runnable() {
//           @Override
//           public void run() {
//               OkHttpClient client = new OkHttpClient();
//               MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//               RequestBody body = RequestBody.create(JSON, "{\"deviceid\":\"170976fa8aa11f63705\",\"idcard\":\"325081199905012817\",\"pass\":\"ce3bb449206aeb547d3d38d74db546b0\"}");
//               Request request = new Request.Builder()
//                       .url("http://192.168.20.151/s/v1/student/login")
//                       .post(body)
//                       .build();
//               Response response = null;
//               try {
//                   response = client.newCall(request).execute();
//                   if (response.isSuccessful()) {
//                       Log.e("SCY", " == = =  " + response.body().string());
//                   } else {
//                       throw new IOException("Unexpected code " + response);
//                   }
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
//           }
//       }).start();

    }

    /**
     * 判断规则
     *
     * @param userName
     * @param passWord
     * @return
     */
    private boolean isNull(String userName, String passWord) {
        if (TextUtils.isEmpty(userName)) {
            ToastUtils.showToast(R.string.string_login_name_null);
            return false;
        } else if (TextUtils.isEmpty(passWord)) {
            ToastUtils.showToast(R.string.string_login_password_null);
            return false;
        } else if (!Utils.isLegelUserName(userName)) {
            ToastUtils.showToast("用户名不正确");
            return false;
        }
//        else if (!NetworkStateReceiver.NetEnumworkStateReceiver.INSTANCE.getInstance().isConnected()) {
//            ToastUtils.showToast(getString(R.string.string_login_wifi_error));
//            return false;
//        }
        return true;
    }

    @Override
    public void initView(View view) {
        login_et_user = view.findViewById(R.id.login_et_user);
        login_et_textPassword = view.findViewById(R.id.login_et_textPassword);
        login_iv_clean_pass = view.findViewById(R.id.login_iv_clean_pass);
        login_iv_clean_pass.setOnClickListener(this);
        login_iv_clean_user = view.findViewById(R.id.login_iv_clean_user);
        login_iv_clean_user.setOnClickListener(this);
        login_tv_login = view.findViewById(R.id.login_tv_login);
        initListener();

    }

    /**
     * 初始化监听事件
     */
    private void initListener() {
        RxView.clicks(login_tv_login)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        setLogin();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //创建输入框的监听
        Observable<CharSequence> userNameObserver = RxTextView.textChanges(login_et_user).skip(1);
        Observable<CharSequence> passWordObserver = RxTextView.textChanges(login_et_textPassword).skip(1);
        Observable.combineLatest(userNameObserver, passWordObserver, new BiFunction<CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean apply(CharSequence charSequence, CharSequence charSequence2) throws Exception {
                if (TextUtils.isEmpty(charSequence)) {
                    login_iv_clean_user.setVisibility(View.INVISIBLE);
                } else {
                    login_iv_clean_user.setVisibility(View.VISIBLE);
                }
                if (TextUtils.isEmpty(charSequence2)) {
                    login_iv_clean_pass.setVisibility(View.INVISIBLE);
                } else {
                    login_iv_clean_pass.setVisibility(View.VISIBLE);
                }
                return TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(charSequence2) && charSequence2.length() >= 6 && !Utils.isLegelUserName(charSequence.toString().trim());
            }
        }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (aBoolean) {
                            setLogin();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 登录方法
     */
    private void setLogin() {
        String userName = login_et_user.getText().toString().trim();
        String passWord = login_et_textPassword.getText().toString().trim();
        boolean isNull = isNull(userName, passWord);
        if (!isNull) {
            return;
        }
        loginPresenter.setLogin(userName, Utils.MD5(passWord));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_iv_clean_pass:
                login_et_textPassword.setText("");
                break;
            case R.id.login_iv_clean_user:
                login_et_user.setText("");
                break;
        }
    }

    @Override
    public void getLogin(LoginModel loginModel) {
        SharedPrefenceUtils.getInstance().putValue(SharedPrefenceUtils.USERTOKEN, loginModel.getToken());
        SharedPrefenceUtils.getInstance().putValue(SharedPrefenceUtils.SHARED_USER_ID, loginModel.getUserid());
        changeFragment(new NewHomeFragment());
    }
}
