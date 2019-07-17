package com.example.todomvvm.data.entity

import android.view.autofill.AutofillId
import androidx.room.Entity
import androidx.room.PrimaryKey

//更新时间
@Entity(tableName = "update")
data class Update(
    @PrimaryKey
    var id: AutofillId,
    val loc: String,
    val utc: String
)