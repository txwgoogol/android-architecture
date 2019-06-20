package com.example.todomvvm.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todomvvm.data.entity.WeatherInfo
import com.example.todomvvm.data.entity.Weatherinfoo
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather WHERE city_id = :cityId")
    fun weather(cityId: String): Flowable<Weatherinfoo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weather: Weatherinfoo): Completable

}