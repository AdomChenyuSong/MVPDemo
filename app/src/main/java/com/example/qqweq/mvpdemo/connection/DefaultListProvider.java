package com.example.qqweq.mvpdemo.connection;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qqweq on 2018/5/3.
 */

public abstract class DefaultListProvider<T> extends BaseListProvider<T> {
    public ArrayList<T> data = new ArrayList<>();
    private int page = 1;
    private static final int PAGE_SIZE = 10;

    public int getPageSize() {
        return PAGE_SIZE;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void loadNext() {
        if (isEnd()) {
            return;
        }
        page++;
        loadData(false);
    }

    protected Function<List<T>, List<T>> getReplyTransformer() {
        return new Function<List<T>, List<T>>() {

            @Override
            public List<T> apply(@io.reactivex.annotations.NonNull List<T> ts) throws Exception {
                return ts;
            }
        };
    }

    @Override
    public void removePosition(int position) {
        data.remove(position);
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public void addData(int position, T da) {
        data.add(position, da);
    }

    @Override
    public void refresh() {
        page = 1;
        setEnd(false);
        loadData(false);
    }

    @Override
    public void loadData(boolean needForce) {
        if (getSubscriber() == null) {
            throw new NullPointerException("observer must not be none!");
        }
        if (isLoading()) {
            return;
        }
        setLoading(true);
        Observable<List<T>> observable = makeObservable();
        observable.subscribeOn(Schedulers.io()).map(getReplyTransformer()).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                setLoading(false);
            }
        }).doOnNext(new Consumer<List<T>>() {
            @Override
            public void accept(List<T> list) throws Exception {
                if (page == 1) {
                    data.clear();
                }
                if (page==5){
                    list.remove(0);
                    list.remove(1);
                }
                if (list.size() < PAGE_SIZE) {
                    setEnd(true);
                }
                data.addAll(list);
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (page > 1) {
                    page--;
                }
                setLoading(false);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(getSubscriber());
    }

    @Override
    public List<T> getData() {
        return data;
    }

    /**
     * 生成数据源.
     *
     * @return 数据源
     */
    public abstract
    @NonNull
    Observable<List<T>> makeObservable();
}
