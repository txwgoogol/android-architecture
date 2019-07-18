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
    val brf: String, //生活指数简介
    val txt: String, //生活指数详细描述
    val type: String //生活指数类型 comf：舒适度指数、cw：洗车指数、drsg：穿衣指数、flu：感冒指数、sport：运动指数、trav：旅游指数、uv：紫外线指数、air：空气污染扩散条件指数、ac：空调开启指数、ag：过敏指数、gl：太阳镜指数、mu：化妆指数、airc：晾晒指数、ptfc：交通指数、fsh：钓鱼指数、spi：防晒指数
)