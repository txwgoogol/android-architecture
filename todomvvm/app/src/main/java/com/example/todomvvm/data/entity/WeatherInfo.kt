package com.example.todomvvm.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherInfo(
    @PrimaryKey
    @ColumnInfo(name = "city_id")
    val cityid: String,
    @ColumnInfo(name = "radar")
    val Radar: String,
    @ColumnInfo(name = "SD")
    val SD: String,
    @ColumnInfo(name = "WD")
    val WD: String,
    @ColumnInfo(name = "WS")
    val WS: String,
    @ColumnInfo(name = "WSE")
    val WSE: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "is_radar")
    val isRadar: String,
    @ColumnInfo(name = "njd")
    val njd: String,
    @ColumnInfo(name = "qy")
    val qy: String,
    @ColumnInfo(name = "26")
    val temp: String,
    @ColumnInfo(name = "time")
    val time: String
)