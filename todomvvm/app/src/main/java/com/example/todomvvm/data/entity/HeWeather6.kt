package com.example.todomvvm.data.entity

import android.view.autofill.AutofillId
import androidx.room.Entity
import androidx.room.PrimaryKey

//天气
@Entity(tableName = "weather")
data class HeWeather6<T>(
    @PrimaryKey
    var id: AutofillId,
    val basic: Basic,
    val t: T,
    val status: String,
    val update: Update
)