package com.example.todomvvm.data.entity

//天气
data class HeWeather6<T>(
    val basic: Basic,
    val t: T,
    val status: String,
    val update: Update
)