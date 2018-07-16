package com.example.qqweq.mvpdemo.connection;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by qqweq on 2018/5/3.
 */

public abstract class SCObserver<T> implements Observer<T> {
    private Disposable disposable;

    public Disposable getDisposable() {
        return disposable;
    }

    public void onStart() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
        onStart();
    }

    @Override
    public void onError(Throwable e) {

    }
}
