package com.example.android.architecture.blueprints.todoapp.data;

import com.example.android.architecture.blueprints.todoapp.data.location.Search;

/**
 * 实体类基类
 *
 * @param <T> 不定类
 */
public class Results<T> {

    private Search location;
    private T t;
    private String last_update;

    public Search getLocation() {
        return location;
    }

    public void setLocation(Search location) {
        this.location = location;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}