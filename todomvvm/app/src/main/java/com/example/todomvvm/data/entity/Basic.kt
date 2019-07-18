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
    val admin_area: String, //该地区／城市所属行政区域 - 内蒙古
    val cid: String, //地区／城市ID - CN101080402
    val cnty: String, //该地区／城市所属国家名称 - 中国
    val lat: String, //地区／城市纬度 - 40.89576
    val location: String, //地区／城市名称 - 卓资
    val lon: String, //地区／城市经度 - 112.577702
    val parent_city: String, //该地区／城市的上级城市 - 乌兰察布
    val tz: String //该地区／城市所在时区 +8.0
)