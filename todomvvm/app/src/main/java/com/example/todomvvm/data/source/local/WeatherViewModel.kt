package com.example.todomvvm.data.source.local

import androidx.lifecycle.ViewModel
import com.example.todomvvm.data.entity.Weather
import io.reactivex.Completable
import io.reactivex.Flowable

//
class WeatherViewModel(private val weatherDao: WeatherDao) : ViewModel() {

    //获取天气信息
    fun getWeather(cityId: String): Flowable<Weather> {
        return weatherDao.weather(cityId)
            .map { weather -> weather }
    }

    //像数据库添加数据
    fun updateWeather(now: Weather): Completable {
        return weatherDao.insertWeather(now)
    }

}