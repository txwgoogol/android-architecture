package com.example.todomvvm.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todomvvm.data.entity.Now
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface WeatherDao {


    /**
     * 从数据库查询
     */
    @Query("SELECT * FROM now WHERE now.HeWeather6.basic.cid = :cid")
    fun weather(cid: String): Flowable<Now>


    /**
     * 想数据添加数据
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(now: Now): Completable

}