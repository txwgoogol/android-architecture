package com.example.android.architecture.blueprints.todoapp.data.weather;

import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiStores;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.data.weather.Weather;
import com.example.android.architecture.blueprints.todoapp.main.weather.CloudWeatherAdapter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class WeatherResponse {

    public static Observable<Weather> getWeather() {
        ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

        Map nowMap = new HashMap();
        //nowMap.put("key","52zpuzgswyulc0w6");
        nowMap.put("location","suzhou");
        nowMap.put("language","zh-Hans");
        nowMap.put("unit","c");
        Observable<Now> nowObservable = apiStores.getNow(nowMap);

        Map dailyMap = new HashMap();
        //dailyMap.put("key","52zpuzgswyulc0w6");
        dailyMap.put("location","suzhou");
        dailyMap.put("language","zh-Hans");
        dailyMap.put("unit","c");
        dailyMap.put("start","0");
        dailyMap.put("days","5");
        Observable<Daily> dailyObservable = apiStores.getDaily(dailyMap);

        Map suggestionMap = new HashMap();
        //suggestionMap.put("key","52zpuzgswyulc0w6");
        suggestionMap.put("location","suzhou");
        suggestionMap.put("language","zh-Hans");
        Observable<Suggestion> suggestionObservable = apiStores.getLifeSuggestion(suggestionMap);

        return Observable.combineLatest(nowObservable, dailyObservable, suggestionObservable, (now, daily, suggestion) -> new CloudWeatherAdapter(now, daily, suggestion).getWeather());
    }

}