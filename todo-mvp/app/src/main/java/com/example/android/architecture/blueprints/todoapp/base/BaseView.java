package com.example.android.architecture.blueprints.todoapp.base;

/**
 * View 基类
 */
public interface BaseView<T> {

    void setPresenter(T presenter);
}