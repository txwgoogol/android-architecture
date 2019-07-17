package com.example.todomvvm.data.entity

import android.view.autofill.AutofillId
import androidx.room.Entity
import androidx.room.PrimaryKey

// now/hourly = 实况天气／逐小时预报
@Entity(tableName = "weather")
data class Weather(
    @PrimaryKey
    var id: AutofillId,
    val cloud: String,
    val cond_code: String,
    val cond_txt: String,
    val fl: String,
    val hum: String,
    val pcpn: String,
    val pres: String,
    val tmp: String,
    val vis: String,
    val wind_deg: String,
    val wind_dir: String,
    val wind_sc: String,
    val wind_spd: String
)