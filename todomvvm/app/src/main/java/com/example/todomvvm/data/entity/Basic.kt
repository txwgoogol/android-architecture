package com.example.todomvvm.data.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

//基础类
@Entity(tableName = "basic",
    foreignKeys = [ForeignKey(entity = HeWeather6::class, parentColumns = ["id"], childColumns = ["he_id"],onDelete = CASCADE)],
    indices = [Index(value = ["he_id"],unique = true)]
)
data class Basic(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "he_id")
    var he_id: Long,
    val admin_area: String,
    val cid: String,
    val cnty: String,
    val lat: String,
    val location: String,
    val lon: String,
    val parent_city: String,
    val tz: String
)