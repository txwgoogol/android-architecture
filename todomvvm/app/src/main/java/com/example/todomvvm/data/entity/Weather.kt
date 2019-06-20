package com.example.todomvvm.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Weather(
    val weatherinfo: Weatherinfoo
)

@Entity(tableName = "weather")
data class Weatherinfoo(
    val Radar: String,
    val SD: String,
    val WD: String,
    val WS: String,
    val WSE: String,
    val city: String,
    @PrimaryKey
    @ColumnInfo(name = "city_id")
    val cityid: String,
    val isRadar: String,
    val njd: String,
    val qy: String,
    val temp: String,
    val time: String
)