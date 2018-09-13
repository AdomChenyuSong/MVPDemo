package com.example.qqweq.mvpdemo.connection;

import com.example.qqweq.mvpdemo.bean.AppVersionModel;
import com.example.qqweq.mvpdemo.bean.BaseEntity;
import com.example.qqweq.mvpdemo.bean.FinishedDataBean;
import com.example.qqweq.mvpdemo.connection.netinterface.MyService;
import com.example.qqweq.mvpdemo.connection.netinterface.VersionService;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by qqweq on 2018/2/28.
 */

public class RxClient<T> {
    /**
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
                            int status_code = ((BaseEntity)tBaseEntity).getStatus_code();
                            String status_msg =  ((BaseEntity)tBaseEntity).getError_msg();
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

//    public <T> ObservableTransformer<T, T> create() {
//        return new ObservableTransformer<T, T>() {
//
//            @Override
//            public ObservableSource<T> apply(Observable<T> upstream) {
//                return upstream.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new Function<T, T>() {
//                    @Override
//                    public T apply(T t) throws Exception {
//                        int status_code = ((BaseEntity<T>) t).getStatus_code();
//                        String status_msg = ((BaseEntity<T>) t).getError_msg();
//                        if (status_code != 200) {
//                            throw new ApiException(status_code, status_msg);
//                        }
//                        return t;
//                    }
//                });
//            }
//        };
//    }
}
