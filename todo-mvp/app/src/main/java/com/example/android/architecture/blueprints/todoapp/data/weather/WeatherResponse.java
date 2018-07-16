package com.example.android.architecture.blueprints.todoapp.data.weather;

import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiStores;
import com.example.android.architecture.blueprints.todoapp.main.weather.CloudWeatherAdapter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class WeatherResponse {

    /**
     * 查询的地址写死的
     * @return
     */
    public static Observable<Weather> getWeather() {
        ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

        Map nowMap = new HashMap();
        nowMap.put("location","suzhou");
        nowMap.put("language","zh-Hans");
        nowMap.put("unit","c");
        Observable<Now> nowObservable = apiStores.getNow(nowMap);

        Map dailyMap = new HashMap();
        dailyMap.put("location","suzhou");
        dailyMap.put("language","zh-Hans");
        dailyMap.put("unit","c");
        dailyMap.put("start","0");
        dailyMap.put("days","5");
        Observable<Daily> dailyObservable = apiStores.getDaily(dailyMap);

        Map suggestionMap = new HashMap();
        suggestionMap.put("location","suzhou");
        suggestionMap.put("language","zh-Hans");
        Observable<Suggestion> suggestionObservable = apiStores.getLifeSuggestion(suggestionMap);

        return Observable.combineLatest(nowObservable, dailyObservable, suggestionObservable, (now, daily, suggestion) -> new CloudWeatherAdapter(now, daily, suggestion).getWeather());
    }

    /**
     * 根据地址的ID查询天气
     * @param key 地址ID
     * @return 组合得到的新数据类
     */
    public static Observable<Weather> getWeather(String key) {
        ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

        Map nowMap = new HashMap();
        nowMap.put("location",key);
        nowMap.put("language","zh-Hans");
        nowMap.put("unit","c");
        Observable<Now> nowObservable = apiStores.getNow(nowMap);

        Map dailyMap = new HashMap();
        dailyMap.put("location",key);
        dailyMap.put("language","zh-Hans");
        dailyMap.put("unit","c");
        dailyMap.put("start","0");
        dailyMap.put("days","5");
        Observable<Daily> dailyObservable = apiStores.getDaily(dailyMap);

        Map suggestionMap = new HashMap();
        suggestionMap.put("location",key);
        suggestionMap.put("language","zh-Hans");
        Observable<Suggestion> suggestionObservable = apiStores.getLifeSuggestion(suggestionMap);

        return Observable.combineLatest(nowObservable, dailyObservable, suggestionObservable, (now, daily, suggestion) -> new CloudWeatherAdapter(now, daily, suggestion).getWeather());
    }

}