package com.example.todomvvm.data.entity

import androidx.room.Entity

//实况天气
@Entity(tableName = "now")
data class Now(
    val HeWeather6: List<HeWeather6>
)

data class HeWeather6(
    val basic: Basic,
    val now: NowX,
    val status: String,
    val update: Update
)

data class Basic(
    val admin_area: String,
    val cid: String,
    val cnty: String,
    val lat: String,
    val location: String,
    val lon: String,
    val parent_city: String,
    val tz: String
)

data class NowX(
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

data class Update(
    val loc: String,
    val utc: String
)