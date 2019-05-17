package top.txwgoogol.weather.todoapp.data.bean.weather;


import java.util.List;

import top.txwgoogol.weather.todoapp.data.bean.life.LifeIndex;

/**
 * 首页天气
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class Weather {

    private Now.ResultsBean.LocationBean location;
    private Now.ResultsBean.NowBean now;
    private List<Daily.ResultsBean.DailyBean> daily;
    private List<LifeIndex> lifeIndexList;
    private String last_update;

    public Now.ResultsBean.LocationBean getLocation() {
        return location;
    }

    public void setLocation(Now.ResultsBean.LocationBean location) {
        this.location = location;
    }

    public Now.ResultsBean.NowBean getNow() {
        return now;
    }

    public void setNow(Now.ResultsBean.NowBean now) {
        this.now = now;
    }

    public List<Daily.ResultsBean.DailyBean> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily.ResultsBean.DailyBean> daily) {
        this.daily = daily;
    }

    public List<LifeIndex> getLifeIndexList() {
        return lifeIndexList;
    }

    public void setLifeIndexList(List<LifeIndex> lifeIndexList) {
        this.lifeIndexList = lifeIndexList;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}