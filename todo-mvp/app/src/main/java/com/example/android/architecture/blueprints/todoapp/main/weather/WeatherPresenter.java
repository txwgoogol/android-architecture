package com.example.android.architecture.blueprints.todoapp.main.weather;

import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiStores;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * view和model的纽带
 * Created by txw on 2018/4/3.
 */
public class WeatherPresenter implements WeatherContact.Presenter {

    private static final String TAG = "WeatherPresenter";

    private WeatherContact.View mWeatherView;

    public WeatherPresenter(WeatherContact.View weatherView) {
        this.mWeatherView = weatherView;
        mWeatherView.setPresenter(this);
    }

    @Override
    public void start() {
        mWeatherView.loadProgress();
        ApiClient.getInstance().create(ApiStores.class)
                .getNow("52zpuzgswyulc0w6", "suzhou", "zh-Hans", "c")
                .enqueue(new Callback<Now>() {
                    @Override
                    public void onResponse(Call<Now> call, Response<Now> response) {
                        mWeatherView.onSuccess(response.body());
                        mWeatherView.hideProgress();
                    }

                    @Override
                    public void onFailure(Call<Now> call, Throwable t) {
                        mWeatherView.onFailure();
                    }
                });
    }

}