package com.txwgoogol.top.weather.todoapp.data.source.local.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.txwgoogol.top.weather.todoapp.common.Constant;

/**
 * 数据库辅助类
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, Constant.DB_NAME, null, Constant.DB_VERSION);
    }

    /**
     * 创建数据库
     *
     * @param db 数据库
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        //首页查询
        String queryWeather = "select * from weather"
                + " inner join location on weather._id = location._id"
                + "inner join now on weather._id = now._id"
                + "inner join daily on weather._id = daily._id"
                + "inner join life_index on weather._id = life_index._id";

        //更新
        String updateWeather = "select * from weather"
                + " inner join location on weather._id = location._id"
                + "inner join now on weather._id = now._id"
                + "inner join daily on weather._id = daily._id"
                + "inner join life_index on weather._id = life_index._id";

        //删除
        String deleteWeather = "select * from weather"
                + " inner join location on weather._id = location._id"
                + "inner join now on weather._id = now._id"
                + "inner join daily on weather._id = daily._id"
                + "inner join life_index on weather._id = life_index._id";

        //String weather = "create table weather(_id Integer primary key,last_update varchar(10))";
        String weatherSQL = "create table " + Constant.TABLE_WEATHER + "("
                + Constant.WEATHER_ID + " varchar(10) primary key,"
                + Constant.WEATHER_LAST_UPDATE + " varchar(10))";
        db.execSQL(weatherSQL);

        //String location = "create table location(_id Integer primary key,name varchar(10),country varchar(10),path varchar(10),timezone varchar(10),timezone_offset varchar(10),weather_id Integer)";
        String locationSQL = "create table " + Constant.TABLE_LOCATION + "("
                + Constant.LOCATION_ID + " varchar(10),"
                + Constant.LOCATION_NAME + " varchar(10),"
                + Constant.LOCATION_COUNTRY + " varchar(10),"
                + Constant.LOCATION_PATH + " varchar(10),"
                + Constant.LOCATION_TIMEZONE + " varchar(10),"
                + Constant.LOCATION_TIMEZONE_OFFSET + " varchar(10),"
                + Constant.LOCATION_WEATHER_ID + " varchar(10))";
        db.execSQL(locationSQL);

        //String now = "create table now(_id Integer primary key,text varchar(10),code varchar(10),temperature varchar(10),weather_id Integer)";
        String nowSQL = "create table " + Constant.TABLE_NOW + "("
                + Constant.NOW_ID + " varchar(10),"
                + Constant.NOW_TEXT + " varchar(10),"
                + Constant.NOW_CODE + " varchar(10),"
                + Constant.NOW_TEMPERATURE + " varchar(10),"
                + Constant.NOW_WEATHER_ID + " varchar(10))";
        db.execSQL(nowSQL);

        //String daily = "create table daily(_id Integer primary key,weather_id Integer,date varchar(10),text_day varchar(10),code_day varchar(10),text_night varchar(10),code_night varchar(10),
        // high varchar(10),low varchar(10),precip varchar(10),wind_direction varchar(10),wind_direction_degree varchar(10),wind_speed varchar(10),wind_scale varchar(10));";
        String forecastSQL = "create table " + Constant.TABLE_FORECAST + "("
                + Constant.FORECAST_ID + " Integer,"
                + Constant.FORECAST_WEATHER_ID + " varchar(10),"
                + Constant.FORECAST_DATE + " varchar(10),"
                + Constant.FORECAST_TEXT_DAY + " varchar(10),"
                + Constant.FORECAST_CODE_DAY + " varchar(10),"
                + Constant.FORECAST_TEXT_NIGHT + " varchar(10),"
                + Constant.FORECAST_CODE_NIGHT + " varchar(10),"
                + Constant.FORECAST_HIGH + " varchar(10),"
                + Constant.FORECAST_LOW + " varchar(10),"
                + Constant.FORECAST_PRECIP + " varchar(10),"
                + Constant.FORECAST_WIND_DIRECTION + " varchar(10),"
                + Constant.FORECAST_WIND_DIRECTION_DEGREE + " varchar(10),"
                + Constant.FORECAST_WIND_SPEED + " varchar(10),"
                + Constant.FORECAST_WIND_SCALE + " varchar(10))";
        db.execSQL(forecastSQL);

        //创建生活指数表
        //String life_index = "create table life_index(_id Integer primary key,name varchar(10),life_index varchar(10),details varchar(10),weather_id Integer)";
        String lifeIndexSQL = "create table " + Constant.TABLE_LIFE_INDEX + "("
                + Constant.LIFE_INDEX_ID + " Integer,"
                + Constant.LIFE_INDEX_NAME + " varchar(10),"
                + Constant.LIFE_INDEX_LIFE_INDEX + " varchar(10),"
                + Constant.LIFE_INDEX_DETAILS + " varchar(10),"
                + Constant.LIFE_INDEX_WEATHER_ID + " Integer)";
        db.execSQL(lifeIndexSQL);

        //创建城市表
        String citySQL = "create table " + Constant.TABLE_CITY + "("
                + Constant.CITY_ID + " varchar(10) primary key,"
                + Constant.CITY_TIME + " varchar(10),"
                + Constant.CITY_NAME + " varchar(10),"
                + Constant.CITY_TEMPERATURE + " varchar(10),"
                + Constant.CITY_CODE + " varchar(10))";
        db.execSQL(citySQL);

    }

    /**
     * 升级数据库
     *
     * @param db         数据库
     * @param oldVersion 旧的数据库版本号
     * @param newVersion 新的数据库版本号
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}