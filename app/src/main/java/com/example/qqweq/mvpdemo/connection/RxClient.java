package com.example.qqweq.mvpdemo.connection;

import android.text.TextUtils;
import android.util.Log;

import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.bean.BaseEntity;
import com.example.qqweq.mvpdemo.bean.FinishedDataBean;
import com.example.qqweq.mvpdemo.bean.LoginModel;
import com.example.qqweq.mvpdemo.bean.ObjectModel;
import com.example.qqweq.mvpdemo.bean.SectionModel;
import com.example.qqweq.mvpdemo.connection.netinterface.LoginService;
import com.example.qqweq.mvpdemo.connection.netinterface.MyService;
import com.example.qqweq.mvpdemo.connection.netinterface.VersionService;
import com.example.qqweq.mvpdemo.untils.SharedPrefenceUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * Created by qqweq on 2018/2/28.
 */

public class RxClient {
    /**
     * ；
     *
     * @param page
     * @param size
     * @return
     */
    public static Observable<List<FinishedDataBean>> getDisReviewedList(int page, int size) {

        return BaseRetrofit.getInstance().createService(MyService.class).getText(page, size, 1, 1, "");
    }

    /**
     * 获取是否有新版本
     *
     * @param versionCode
     * @return
     */
    public static Observable<AppVersionModel> getVersion(int versionCode) {
        return BaseRetrofit.getInstance().createService(VersionService.class).getVersion(versionCode);
    }

    /**
     * 登录界面
     *
     * @param userName
     * @param password
     * @return
     */
    public static Observable<LoginModel> setLogin(String userName, String password) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("idcard", userName);
        hashMap.put("pass", password);
        hashMap.put("deviceid", "170976fa8aa11f63705");
        String jsonString = new JSONObject(hashMap).toString();
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonString);
        return BaseRetrofit.getInstance().createService(LoginService.class).setLogin(body);
    }


    /**
     * 获取科目
     *
     * @return
     */
    public static Observable<List<ObjectModel>> getObject() {
        Object value = SharedPrefenceUtils.getInstance().getValue(SharedPrefenceUtils.SHARED_USER_ID, 0);
        String token = (String) SharedPrefenceUtils.getInstance().getValue(SharedPrefenceUtils.USERTOKEN, "token");
        return BaseRetrofit.getInstance().createService(LoginService.class).getObject((Integer) value, token);
    }

    /**
     * 获取科目信息
     *
     * @return
     */
    public static Observable<List<SectionModel>> getCourse() {
        Object value = SharedPrefenceUtils.getInstance().getValue(SharedPrefenceUtils.SHARED_USER_ID, 0);
        String token = (String) SharedPrefenceUtils.getInstance().getValue(SharedPrefenceUtils.USERTOKEN, "token");
        return BaseRetrofit.getInstance().createService(LoginService.class).getCourse((Integer) value, token);
    }

    /**
     * 数据转换
     * ----------------------------------------------------------------------------------------------------------------
     **/
    public static class DefaultTransformer<T> implements ObservableTransformer<T, T> {

        @Override
        public ObservableSource<T> apply(Observable<T> upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(new Function<T, T>() {
                        @Override
                        public T apply(T tBaseEntity) throws Exception {
                            if (tBaseEntity instanceof List) {
                                return tBaseEntity;
                            }
                            double status_code = Double.parseDouble(String.valueOf(((BaseEntity) tBaseEntity).getStatus_code()));
                            String status_msg = ((BaseEntity) tBaseEntity).getError_msg();
                            if (status_code != 200) {
                                throw new ApiException(status_code, status_msg);
                            }
                            return tBaseEntity;
                        }
                    });
        }
    }

    public static <T> DefaultTransformer<T> create() {
        return new DefaultTransformer<>();
    }


}
