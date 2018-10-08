package com.example.qqweq.mvpdemo.connection;

import android.util.Log;

import com.example.qqweq.mvpdemo.Configuration;
import com.example.qqweq.mvpdemo.untils.SharedPrefenceUtils;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qqweq on 2018/2/28.
 */

public class BaseRetrofit {
    private Retrofit retrofit;
    private static final int timeout = 10000;

    private BaseRetrofit() {
        init();
    }

    private void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Configuration.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//新的配置
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();


    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .addInterceptor(new AddHeaderInterceptor())
                .addInterceptor(new LoggingInterceptor())
                .build();
        return okHttpClient;
    }

    public class LoggingInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.e("SCY", " - - requestUrl - - " + request.url().toString());
            Response response = chain.proceed(request);
            BufferedSource source = response.body().source();
            source.request(Long.MAX_VALUE); // request the entire body.
            Buffer buffer = source.buffer();
            String responseBodyString = buffer.clone().readString(Charset.forName("UTF-8"));
            Log.e("SCY", " - - requestData - - " + responseBodyString);
            return response;
        }
    }

    public class AddHeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            Object token = SharedPrefenceUtils.getInstance().getValue(SharedPrefenceUtils.USERTOKEN, "token");
            builder.addHeader("token", (String) token);
//            builder.addHeader("token", "token");
            builder.addHeader("type", "android");
            return chain.proceed(request);
        }
    }

    //    MyService upApiService() {
//        return retrofit.create(MyService.class);
//    }
//    VersionService versionApiService() {
//        return retrofit.create(VersionService.class);
//    }
    public <T> T createService(Class<T> tClass) {
        return retrofit.create(tClass);
    }

    private volatile static BaseRetrofit INSTANCE = null;

    //获取单例
    public static BaseRetrofit getInstance() {
        if (INSTANCE == null) {
            synchronized (BaseRetrofit.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BaseRetrofit();
                }
            }
        }
        return INSTANCE;
    }
}