package top.txwgoogol.weather.todomvp.data.bean;

import top.txwgoogol.weather.todomvp.data.bean.search.Search;

/**
 * 实体类基类
 *
 * @param <T> 不定类
 * @author txw
 * @// TODO: 04/12/18
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