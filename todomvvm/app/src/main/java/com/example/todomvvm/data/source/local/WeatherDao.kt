package com.example.todomvvm.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todomvvm.data.entity.Weather
import io.reactivex.Completable
import io.reactivex.Flowable

//
@Dao
interface WeatherDao {

    /**
     * 从数据库查询
     */
    @Query("SELECT * FROM basic WHERE cid = :cid")
    fun weather(cid: String): Flowable<Weather>

    /**
     * 想数据添加数据
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(now: Weather): Completable

}