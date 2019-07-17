package com.example.todomvvm.data.source.local

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//
class ViewModelFactory(private val weatherDao: WeatherDao) : ViewModelProvider.Factory {

    @Suppress(names = ["UNCHECKED_CAST"])
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(weatherDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}