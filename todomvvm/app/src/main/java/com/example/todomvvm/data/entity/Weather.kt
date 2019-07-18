package com.example.todomvvm.data.entity

import androidx.room.*

// now/hourly = 实况天气／逐小时预报
@Entity(tableName = "weather",
    foreignKeys = [ForeignKey(entity = HeWeather6::class, parentColumns = ["id"], childColumns = ["he_id"],onDelete = ForeignKey.CASCADE)],
    indices = [Index(value = ["he_id"],unique = true)]
)
data class Weather(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "he_id")
    var he_id: Long,
    val cloud: String, //云量 - 23
    val cond_code: String, //实况天气状况代码 - 100
    val cond_txt: String, //实况天气状况描述 - 晴
    val fl: String, //体感温度，默认单位：摄氏度 - 23
    val hum: String, //相对湿度 - 40
    val pcpn: String, //降水量 - 0
    val pres: String, //大气压强 - 1020
    val tmp: String, //温度，默认单位：摄氏度 - 21
    val vis: String, //能见度，默认单位：公里 - 10
    val wind_deg: String, //风向360角度 - 305
    val wind_dir: String, //风向 - 西北
    val wind_sc: String, //风力 - 3-4
    val wind_spd: String //风速，公里/小时 - 15
)