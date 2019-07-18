package com.example.todomvvm.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//天气 t = now/hourly
@Entity(tableName = "he_weather")
data class HeWeather6(
    @PrimaryKey(autoGenerate = true)
    var id: Long, //主键
    @ColumnInfo(name = "basic_id")
    var basic_id: Long, //外键 - 地址

    @ColumnInfo(name = "weather_id")
    var weather_id: Long, //外键 - 天气
    @ColumnInfo(name = "life_style_id")
    var life_style_id: Long, //外键 - 生活指数
    @ColumnInfo(name = "daily_forecast_id")
    var daily_forecast_id: Long, //外键 - 天气预报

    val status: String, //外键 - 状态
    @ColumnInfo(name = "update_id")
    var update_id: Long //外键 - 更新
)