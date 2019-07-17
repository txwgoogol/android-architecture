package com.example.todomvvm.data.entity

import androidx.room.Entity

//更新时间
@Entity(tableName = "update")
data class Update(
    val loc: String,
    val utc: String
)