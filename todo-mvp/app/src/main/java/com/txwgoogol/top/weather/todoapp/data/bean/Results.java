package com.txwgoogol.top.weather.todoapp.data.bean;

import com.txwgoogol.top.weather.todoapp.data.bean.search.Search;

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