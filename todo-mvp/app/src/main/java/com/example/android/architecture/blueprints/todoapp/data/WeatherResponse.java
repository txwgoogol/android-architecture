package com.example.android.architecture.blueprints.todoapp.data;

import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiStores;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.main.weather.CloudWeatherAdapter;

import io.reactivex.Observable;

public class WeatherResponse {

    public static Observable<Weather> getWeather() {
        ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);
        Observable<Now> nowObservable = apiStores.getNow1("52zpuzgswyulc0w6", "suzhou", "zh-Hans", "c");
        Observable<Daily> dailyObservable = apiStores.getDaily("52zpuzgswyulc0w6", "suzhou", "zh-Hans", "c", "0", "5");
        Observable<Suggestion> suggestionObservable = apiStores.getLifeSuggestion("52zpuzgswyulc0w6", "suzhou", "zh-Hans");
        return Observable.combineLatest(nowObservable, dailyObservable, suggestionObservable, (now, daily, suggestion) -> new CloudWeatherAdapter(now, daily, suggestion).getWeather());
    }

}