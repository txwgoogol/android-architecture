package com.example.android.architecture.blueprints.todoapp.util;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * RxJava 线程转换类
 */
public final class RxScheduler {

    /**
     * 在RxJava的使用过程中我们会频繁的调用subscribeOn()和observeOn(),
     * 通过Transformer结合Observable.compose()我们可以复用这些代码
     *
     * @return Transformer
     */
    public static <T> ObservableTransformer<T, T> normalSchedulersTransformer() {
        return observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}