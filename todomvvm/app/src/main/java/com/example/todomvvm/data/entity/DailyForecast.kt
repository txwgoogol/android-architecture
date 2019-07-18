package com.example.todomvvm.data.entity

import androidx.room.*

//3-10天预报
@Entity(tableName = "daily_forecast",
    foreignKeys = [ForeignKey(entity = HeWeather6::class, parentColumns = ["id"], childColumns = ["he_id"],onDelete = ForeignKey.CASCADE)],
    indices = [Index(value = ["he_id"],unique = true)]
)
data class DailyForecast(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "he_id")
    var he_id: Long,
    val cond_code_d: String, //白天天气状况代码 - 100
    val cond_code_n: String, //夜间天气状况代码 - 100
    val cond_txt_d: String, //白天天气状况描述 - 晴
    val cond_txt_n: String, //晚间天气状况描述 - 晴
    val date: String, //预报日期 - 2013-12-30
    val hum: String, //相对湿度 - 37
    val mr: String, //月升时间 - 04:47
    val ms: String, //月落时间 - 14:59
    val pcpn: String, //降水量 - 0
    val pop: String, //降水概率 - 0
    val pres: String, //大气压强 - 1018
    val sr: String, //日出时间 - 07:36
    val ss: String, //日落时间 - 16:58
    val tmp_max: String, //最高温度 - 4
    val tmp_min: String, //最低温度 - -5
    val uv_index: String, //紫外线强度指数 - 3
    val vis: String, //能见度，单位：公里 - 10
    val wind_deg: String, //风向360角度 - 310
    val wind_dir: String, //风向 - 西北风
    val wind_sc: String, //风力 - 1-2
    val wind_spd: String //风速，公里/小时 - 14
)