package com.example.qqweq.mvpdemo.connection;

import com.example.qqweq.mvpdemo.bean.FinishedDataBean;
import java.util.List;
import io.reactivex.Observable;


/**
 * Created by qqweq on 2018/2/28.
 */

public class RxClient {
    /**
     * @param page
     * @param size
     * @return
     */
    public static Observable<List<FinishedDataBean>> getDisReviewedList(int page, int size) {
        return BaseRetrofit.getInstance().upApiService().getText(page, size,1,1,"w1N3dahtnInylGZty4WZsioTMciQHdazBDLrwVmItiMWew6MDLanlWYnyx2btUlWbsxQnbclJiOa1gzdrhVjMt0QTNw04WNa0kjMnAAAdt=0HA");
    }
}
