package com.example.android.architecture.blueprints.todoapp;

/**
 * Created by txw on 2018/4/3.
 */
public interface BaseView<T> {

    void setPresenter(T presenter);
}
