package com.example.todomvvm.data.entity

import androidx.room.Entity

//基础类
@Entity(tableName = "basic")
class Basic(
    val admin_area: String,
    val cid: String,
    val cnty: String,
    val lat: String,
    val location: String,
    val lon: String,
    val parent_city: String,
    val tz: String
)