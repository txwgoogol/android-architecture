package com.example.android.architecture.blueprints.todoapp.data.remote;

import com.example.android.architecture.blueprints.todoapp.data.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 接口
 * Created by txw on 2018/4/3.
 */
public interface ApiStores {

    String BASE_URL = "http://www.weather.com.cn/";

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Call<Weather> loadDataByRetrofit(@Path("cityId") String cityId);

}