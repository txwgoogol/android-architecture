package com.example.todomvvm.data.entity

import androidx.room.*

//更新时间
@Entity(tableName = "update",
    foreignKeys = [ForeignKey(entity = HeWeather6::class, parentColumns = ["id"], childColumns = ["he_id"],onDelete = ForeignKey.CASCADE)],
    indices = [Index(value = ["he_id"],unique = true)]
)
data class Update(
    @PrimaryKey(autoGenerate = true)
    var id: Long, //主键
    @ColumnInfo(name = "he_id")
    var he_id: Long, //外键 关联 he_weather 表
    val loc: String, //当地时间，24小时制，格式yyyy-MM-dd HH:mm - 2017-10-25 12:34
    val utc: String //UTC时间，24小时制，格式yyyy-MM-dd HH:mm - 2017-10-25 04:34
)