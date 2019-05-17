package top.txwgoogol.weather.todoapp.main.weather;

import java.util.List;

import top.txwgoogol.weather.todoapp.data.bean.life.LifeIndex;
import top.txwgoogol.weather.todoapp.data.bean.weather.Daily;
import top.txwgoogol.weather.todoapp.data.bean.weather.Now;
import top.txwgoogol.weather.todoapp.data.bean.weather.Weather;

/**
 * 首页天气适配器
 *
 * @author txw
 * @// TODO: 04/12/18
 */
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