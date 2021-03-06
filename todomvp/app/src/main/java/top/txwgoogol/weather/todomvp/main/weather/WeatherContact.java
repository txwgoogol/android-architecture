package top.txwgoogol.weather.todomvp.main.weather;

import android.content.Intent;

import top.txwgoogol.weather.todomvp.base.BasePresenter;
import top.txwgoogol.weather.todomvp.base.BaseView;
import top.txwgoogol.weather.todomvp.data.bean.weather.Weather;

/**
 * 纽带
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public interface WeatherContact {

    interface View extends BaseView<Presenter> {

        //数据加载成功
        void showWeather(Weather weather);

        //根据经纬度获取地址信息
        String getLocation();

        //根据地址信息获取地址ID
        String getLocationId();

        //是否添加到容器中
        boolean isActive();

        //获取网络状态
        boolean getNetWorkAvailable();
    }

    interface Presenter extends BasePresenter {

        //回调获取数据
        void result(int requestCode, int resultCode, Intent data);

        /**
         * 执行天气查询
         *
         * @param key 查询关键字
         */
        void searchWeather(String key);

        /**
         * 根据经纬度获取地址信息
         *
         * @return 返回地址名
         */
        String getLatitudeAndLongitude(String lal);

        /**
         * 执行刷新操作
         *
         * @param refresh 是否执行刷新操作
         */
        void forceUpdate(boolean refresh);
    }

}