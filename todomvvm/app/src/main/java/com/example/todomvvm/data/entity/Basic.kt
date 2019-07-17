package com.example.todomvvm.data.entity

import android.view.autofill.AutofillId
import androidx.room.Entity
import androidx.room.PrimaryKey

//基础类
@Entity(tableName = "basic")
data class Basic(
    @PrimaryKey
    var id: AutofillId,
    val admin_area: String,
    val cid: String,
    val cnty: String,
    val lat: String,
    val location: String,
    val lon: String,
    val parent_city: String,
    val tz: String
)