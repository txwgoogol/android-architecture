package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.content.Intent;

import com.example.android.architecture.blueprints.todoapp.base.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.base.BaseView;
import com.example.android.architecture.blueprints.todoapp.data.weather.Weather;

public interface WeatherContact {

    interface View extends BaseView<Presenter> {

        //显示加载进度
        void loadProgress();

        //隐藏加载进度
        void hideProgress();

        //数据加载成功
        void onSuccess(Weather weather);

        //数据加载失败
        void onFailure();

        //执行获取天气信息
        void onWeather(String q);
    }

    interface Presenter extends BasePresenter {

        //回调获取数据
        void result(int requestCode, int resultCode, Intent data);

        //执行查询
        void weather(String q);
    }

}