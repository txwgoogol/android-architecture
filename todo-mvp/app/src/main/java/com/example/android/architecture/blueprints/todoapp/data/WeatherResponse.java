package com.example.android.architecture.blueprints.todoapp.data;

import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiStores;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.main.weather.CloudWeatherAdapter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class WeatherResponse {

    public static Observable<Weather> getWeather() {
        ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);
        Observable<Now> nowObservable = apiStores.getNow1("52zpuzgswyulc0w6", "suzhou", "zh-Hans", "c");

        Map map = new HashMap();
        map.put("key","52zpuzgswyulc0w6");
        map.put("location","suzhou");
        map.put("language","zh-Hans");
        map.put("unit","c");
        Observable<Now> nowObservable1 = apiStores.getNow2(map);


        Observable<Daily> dailyObservable = apiStores.getDaily("52zpuzgswyulc0w6", "suzhou", "zh-Hans", "c", "0", "5");
        Observable<Suggestion> suggestionObservable = apiStores.getLifeSuggestion("52zpuzgswyulc0w6", "suzhou", "zh-Hans");
        return Observable.combineLatest(nowObservable1, dailyObservable, suggestionObservable, (now, daily, suggestion) -> new CloudWeatherAdapter(now, daily, suggestion).getWeather());
    }

}