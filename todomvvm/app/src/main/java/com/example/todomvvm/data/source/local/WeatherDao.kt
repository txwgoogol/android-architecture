package com.example.todomvvm.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todomvvm.data.entity.HeWeather6
import com.example.todomvvm.data.entity.Weather
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
//数据库操作
interface WeatherDao {

    //从数据库查询数据
    @Query("SELECT * FROM he_weather WHERE id = :cid")
    fun weather(cid: String): Flowable<HeWeather6>

    //向数据库插入数据
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(heWeather6: HeWeather6): Completable

}