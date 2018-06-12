package com.example.android.architecture.blueprints.todoapp.data.remote;

import com.example.android.architecture.blueprints.todoapp.data.Now;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 接口
 * Created by txw on 2018/4/3.
 */
public interface ApiStores {

    String BASE_URL = "https://api.seniverse.com/v3/";

    //天气实况
    @GET("weather/now.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&unit=c")
    Call<Now> getNow();

}