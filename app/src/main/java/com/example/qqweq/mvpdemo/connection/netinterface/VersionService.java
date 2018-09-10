package com.example.qqweq.mvpdemo.connection.netinterface;

import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.bean.FinishedDataBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qqweq on 2018/9/10.
 */

public interface VersionService {
    @GET("/c/v1/version/1")
    Observable<AppVersionModel> getVersion(@Query("versioncode") int versioncode);
}
