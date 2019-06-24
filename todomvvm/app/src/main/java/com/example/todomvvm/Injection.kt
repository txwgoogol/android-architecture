package com.example.todomvvm

import android.content.Context
import com.example.todomvvm.data.source.WeatherDataBase
import com.example.todomvvm.data.source.local.WeatherDao
import com.example.todomvvm.data.source.local.ViewModelFactory

object Injection {

    fun provideWeatherDataSource(context: Context): WeatherDao {
        val database = WeatherDataBase.getInstance(context)
        return database.weatherDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideWeatherDataSource(context)
        return ViewModelFactory(dataSource)
    }

}