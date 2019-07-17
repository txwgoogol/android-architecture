package com.example.todomvvm.data.entity

import androidx.room.*

//生活指数
@Entity(tableName = "life_style",
    foreignKeys = [ForeignKey(entity = HeWeather6::class, parentColumns = ["id"], childColumns = ["he_id"],onDelete = ForeignKey.CASCADE)],
    indices = [Index(value = ["he_id"],unique = true)]
)
data class LifeStyle(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "he_id")
    var he_id: Long,
    val brf: String,
    val txt: String,
    val type: String
)