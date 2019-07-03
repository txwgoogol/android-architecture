package com.example.todomvvm.utils

import android.content.Context
import com.example.todomvvm.data.source.WeatherDataBase
import com.example.todomvvm.data.source.local.WeatherDao
import com.example.todomvvm.data.source.local.ViewModelFactory

object Injection {

    private fun provideWeatherDataSource(context: Context): WeatherDao {
        val database = WeatherDataBase.getInstance(context)
        return database.weatherDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideWeatherDataSource(context)
        return ViewModelFactory(dataSource)
    }

}