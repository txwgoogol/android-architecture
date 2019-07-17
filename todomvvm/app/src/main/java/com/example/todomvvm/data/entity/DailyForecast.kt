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
    val cond_code_d: String,
    val cond_code_n: String,
    val cond_txt_d: String,
    val cond_txt_n: String,
    val date: String,
    val hum: String,
    val mr: String,
    val ms: String,
    val pcpn: String,
    val pop: String,
    val pres: String,
    val sr: String,
    val ss: String,
    val tmp_max: String,
    val tmp_min: String,
    val uv_index: String,
    val vis: String,
    val wind_deg: String,
    val wind_dir: String,
    val wind_sc: String,
    val wind_spd: String
)