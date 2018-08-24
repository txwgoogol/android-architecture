package com.txwgoogol.top.weather.todoapp.main.weather;

import com.txwgoogol.top.weather.todoapp.data.bean.life.LifeIndex;
import com.txwgoogol.top.weather.todoapp.data.bean.weather.Daily;
import com.txwgoogol.top.weather.todoapp.data.bean.weather.Now;
import com.txwgoogol.top.weather.todoapp.data.bean.weather.Weather;

import java.util.List;

public abstract class WeatherAdapter {

    public abstract Now.ResultsBean.LocationBean getLocation();

    public abstract Now.ResultsBean.NowBean getNow();

    public abstract List<Daily.ResultsBean.DailyBean> getDaily();

    public abstract List<LifeIndex> getLifeIndex();

    public abstract String getLastUpdate();

    public Weather getWeather() {
        Weather weather = new Weather();
        weather.setLocation(getLocation());
        weather.setNow(getNow());
        weather.setDaily(getDaily());
        weather.setLifeIndexList(getLifeIndex());
        weather.setLast_update(getLastUpdate());
        return weather;
    }

}