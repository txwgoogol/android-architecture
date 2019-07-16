package com.example.todomvvm.data.entity

import androidx.room.Entity

//生活指数
@Entity(tableName = "life_style")
data class LifeStyle(
    val brf: String,
    val txt: String,
    val type: String
)