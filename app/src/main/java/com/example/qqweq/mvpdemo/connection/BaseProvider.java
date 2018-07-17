package com.example.qqweq.mvpdemo.connection;

/**
 * Created by qqweq on 2018/5/3.
 */

public abstract class BaseProvider<T> {
    /**
     * 设置加载状态标识.
     *
     * @param loading 是否正在加载
     */
    public boolean isLoading;

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }
    /**
     * 得到观察者.
     *
     * @return 得到观察者.
     */
    public SCObserver<T> getSubscriber() {
        return observer;
    }

    /**
     * 设置数据获取后的回调监听.
     *
     * @param observer 观察者 用来获取网络请求的事件回调.
     */
    public void setSubscriber(SCObserver<T> observer) {
        this.observer = observer;
    }

    /**
     * 一个默认回调接口 用来获取网络请求的事件回调.
     */
    private SCObserver<T> observer;

    public abstract void refresh();

    public abstract void loadData(boolean needForce);

    public abstract T getData();

    public void cancelRequest() {
        if (getSubscriber() != null && getSubscriber().getDisposable() != null) {
            getSubscriber().getDisposable().dispose();
        }
    }
}
