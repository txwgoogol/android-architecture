package com.example.todomvvm.data.entity

data class HeWeather6<T>(
    val basic: Basic,
    val t: T,
    val status: String,
    val update: Update
)