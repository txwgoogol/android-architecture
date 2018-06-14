package com.example.android.architecture.blueprints.todoapp.data;

import java.util.List;

/**
 * 实体类基类
 *
 * @param <K> 包含位置信息
 * @param <V>        不定项
 */
public class Results<K, V> {

    private K k;
    private V v;
    private String last_update;

    public K getLocation() {
        return k;
    }

    public void setLocation(K l) {
        this.k = k;
    }

    public V getResults() {
        return v;
    }

    public void setResults(V t) {
        this.v = v;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}