package com.example.todomvvm.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//天气 t = now/hourly
@Entity(tableName = "he_weather")
data class HeWeather6(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
//    val basic: Basic,
//    val weather: Weather,
    val status: String
//    ,
//    val update: Update
)