package com.example.qqweq.mvpdemo.connection.netinterface;

import com.example.qqweq.mvpdemo.bean.LoginModel;
import com.example.qqweq.mvpdemo.bean.ObjectModel;
import com.example.qqweq.mvpdemo.bean.SectionModel;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by qqweq on 2018/9/10.
 */

public interface LoginService {
    @POST("/s/v1/student/login")
    Observable<LoginModel> setLogin(@Body RequestBody body);
    @GET("/c/v1/student/{userId}/course")
    Observable<List<ObjectModel>> getObject(@Path("userId")int userId,@Query("token")String token);
    @GET("/s/v1/status/course/{userId}")
    Observable<List<SectionModel>> getCourse(@Path("userId")int userId,@Query("token")String token);


}
