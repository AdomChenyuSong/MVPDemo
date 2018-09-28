package com.example.qqweq.mvpdemo.connection.netinterface;

import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.bean.LoginModel;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by qqweq on 2018/9/10.
 */

public interface LoginService {
    @POST("/s/v1/student/login")
    Observable<LoginModel> setLogin(@Body RequestBody body);
}
