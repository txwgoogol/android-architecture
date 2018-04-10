package com.example.android.architecture.blueprints.todoapp;

import com.example.android.architecture.blueprints.todoapp.data.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.remote.ApiStores;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by txw on 2018/4/3.
 */
public interface BasePresenter {

    void start();

}
