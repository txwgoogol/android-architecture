package com.example.todomvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todomvvm.data.source.local.WeatherDao

class ViewModelFactory(private val weatherDao: WeatherDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(weatherDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}