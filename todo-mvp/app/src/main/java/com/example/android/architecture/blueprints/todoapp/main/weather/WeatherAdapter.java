package com.example.android.architecture.blueprints.todoapp.main.weather;

import com.example.android.architecture.blueprints.todoapp.data.life.LifeIndex;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.data.weather.Weather;

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