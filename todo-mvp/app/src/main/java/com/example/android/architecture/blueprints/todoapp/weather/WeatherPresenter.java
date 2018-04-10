package com.example.android.architecture.blueprints.todoapp.weather;

import com.example.android.architecture.blueprints.todoapp.data.Weather;
import com.example.android.architecture.blueprints.todoapp.data.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.remote.ApiStores;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by txw on 2018/4/3.
 */
public class WeatherPresenter implements WeatherContact.Presenter {

    private WeatherContact.View mWeatherView;

    public WeatherPresenter(WeatherContact.View weatherView) {
        this.mWeatherView = weatherView;
        mWeatherView.setPresenter(this);
    }

    @Override
    public void start() {
        mWeatherView.loadProgress();
        ApiClient.getInstance().create(ApiStores.class).loadDataByRetrofit("101190201").enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                mWeatherView.onSuccess(response.body());
                mWeatherView.hideProgress();
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                mWeatherView.onFailure();
            }
        });
    }

}