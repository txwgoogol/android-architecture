package com.example.todomvvm.utils

import android.app.Activity
import android.content.Context
import com.example.todomvvm.data.source.WeatherDataBase
import com.example.todomvvm.data.source.local.WeatherDao
import com.example.todomvvm.data.source.local.ViewModelFactory

//注入
object Injection {

    private fun provideWeatherDataSource(context: Context): WeatherDao {
        val database = WeatherDataBase.getInstance(context)
        return database.weatherDao()
    }

    fun provideViewModelFactory(activity: Activity): ViewModelFactory {
        val dataSource = provideWeatherDataSource(activity)
        return ViewModelFactory(dataSource)
    }

}