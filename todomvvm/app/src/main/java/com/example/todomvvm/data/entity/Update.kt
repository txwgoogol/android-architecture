package com.example.todomvvm.data.entity

import androidx.room.*

//更新时间
@Entity(tableName = "update",
    foreignKeys = [ForeignKey(entity = HeWeather6::class, parentColumns = ["id"], childColumns = ["he_id"],onDelete = ForeignKey.CASCADE)],
    indices = [Index(value = ["he_id"],unique = true)]
)
data class Update(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "he_id")
    var he_id: Long,
    val loc: String,
    val utc: String
)