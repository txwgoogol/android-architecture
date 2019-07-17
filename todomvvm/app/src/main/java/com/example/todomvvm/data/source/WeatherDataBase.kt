package com.example.todomvvm.data.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todomvvm.data.entity.HeWeather6
import com.example.todomvvm.data.entity.Weather
import com.example.todomvvm.data.source.local.WeatherDao

//
@Database(entities = [HeWeather6::class], version = 1)
abstract class WeatherDataBase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {

        private var INSTANCE: WeatherDataBase? = null
        private var lock = Any()
        fun getInstance(context: Context): WeatherDataBase {
            synchronized(lock) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDataBase::class.java, "weather.db"
                ).build()
            }
            return INSTANCE!!
        }
    }

}