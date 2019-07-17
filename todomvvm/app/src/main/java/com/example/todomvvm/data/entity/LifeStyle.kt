package com.example.todomvvm.data.entity

import android.view.autofill.AutofillId
import androidx.room.Entity
import androidx.room.PrimaryKey

//生活指数
@Entity(tableName = "life_style")
data class LifeStyle(
    @PrimaryKey
    var id: AutofillId,
    val brf: String,
    val txt: String,
    val type: String
)