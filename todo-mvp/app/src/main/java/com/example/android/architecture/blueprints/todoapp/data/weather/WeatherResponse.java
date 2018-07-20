package com.example.android.architecture.blueprints.todoapp.data.weather;

import com.example.android.architecture.blueprints.todoapp.data.city.Address;
import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiStores;
import com.example.android.architecture.blueprints.todoapp.main.weather.WeatherAdapterImpl;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 响应数据
 */
public class WeatherResponse {

    /**
     * 查询的地址写死的
     *
     * @return 组合得到的新数据类

    public static Observable<Weather> getWeather() {
    ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

    Map nowMap = new HashMap();
    nowMap.put("location", "suzhou");
    nowMap.put("language", "zh-Hans");
    nowMap.put("unit", "c");
    Observable<Now> nowObservable = apiStores.getNow(nowMap);

    Map dailyMap = new HashMap();
    dailyMap.put("location", "suzhou");
    dailyMap.put("language", "zh-Hans");
    dailyMap.put("unit", "c");
    dailyMap.put("start", "0");
    dailyMap.put("days", "5");
    Observable<Daily> dailyObservable = apiStores.getDaily(dailyMap);

    Map suggestionMap = new HashMap();
    suggestionMap.put("location", "suzhou");
    suggestionMap.put("language", "zh-Hans");
    Observable<Suggestion> suggestionObservable = apiStores.getLifeSuggestion(suggestionMap);

    return Observable.combineLatest(nowObservable, dailyObservable, suggestionObservable, (now, daily, suggestion) -> new WeatherAdapterImpl(now, daily, suggestion).getWeather());
    }*/

    /**
     * 根据地址的ID查询天气
     *
     * @param key 地址ID
     * @return 组合得到的新数据类
     */
    public static Observable<Weather> getWeather(String key) {
        ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

        Map nowMap = new HashMap();
        nowMap.put("location", key);
        nowMap.put("language", "zh-Hans");
        nowMap.put("unit", "c");
        Observable<Now> nowObservable = apiStores.getNow(nowMap);

        Map dailyMap = new HashMap();
        dailyMap.put("location", key);
        dailyMap.put("language", "zh-Hans");
        dailyMap.put("unit", "c");
        dailyMap.put("start", "0");
        dailyMap.put("days", "5");
        Observable<Daily> dailyObservable = apiStores.getDaily(dailyMap);

        Map suggestionMap = new HashMap();
        suggestionMap.put("location", key);
        suggestionMap.put("language", "zh-Hans");
        Observable<Suggestion> suggestionObservable = apiStores.getLifeSuggestion(suggestionMap);

        return Observable.combineLatest(nowObservable, dailyObservable, suggestionObservable, (now, daily, suggestion) -> new WeatherAdapterImpl(now, daily, suggestion).getWeather());
    }

    /**
     * 根据经纬度获取地理位置信息
     *
     * @param lal 经纬度
     * @return 地理位置信息
     */
    public static Observable<Address> getLatitudeAndLongitude(String lal) {

        //将 ":" 替换成 "," 满足条件
        lal = lal.replace(":",",");

        Map map = new HashMap();
        map.put("l", lal); //格式: 39.90,116.40
        map.put("type", "010");
        Observable<Address> addressObservable = ApiClient.getInstance().create(ApiStores.class).getAddress(map);
        return addressObservable;
    }

}