package com.example.qqweq.mvpdemo.connection.netinterface;



import com.example.qqweq.mvpdemo.bean.FinishedDataBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by qqweq on 2018/2/28.
 */

public interface MyService {

    @GET("s/v1/task/testdone")
    Observable<List<FinishedDataBean>> getText(@Query("page") int page, @Query("size") int size, @Query("courseid") int courseid, @Query("type") int type, @Query("token") String token);

}
