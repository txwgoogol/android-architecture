package com.example.android.architecture.blueprints.todoapp.data.db.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.architecture.blueprints.todoapp.common.Constant;

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

        //首页头部天气信息表
        String weatherSQL = "create table " + Constant.TABLE_WEATHER + "("
                + Constant.WEATHER_ID + " text primary key,"
                + Constant.WEATHER_TIME + " text,"
                + Constant.WEATHER_NAME + " text,"
                + Constant.WEATHER_TEXT + " text,"
                + Constant.WEATHER_CODE + " text,"
                + Constant.WEATHER_TEMPERATURE + " text,"
                + Constant.WEATHER_LAST_UPDATE + " text)";
        db.execSQL(weatherSQL);

        //未来三天天气情况表
        String forecastSQL = "create table " + Constant.TABLE_FORECAST + "("
                + Constant.FORECAST_ID + " text,"
                + Constant.FORECAST_LOCATION_ID + " text,"
                + Constant.FORECAST_TEXT + " text,"
                + Constant.FORECAST_HEIGHT + " text,"
                + Constant.FORECAST_LOW + " text,"
                + Constant.FORECAST_CODE + " text)";
        db.execSQL(forecastSQL);

        //创建生活指数表
        String lifeIndexSQL = "create table " + Constant.TABLE_LIFE_INDEX + "("
                + Constant.LIFE_INDEX_ID + " text,"
                + Constant.LIFE_INDEX_LOCATION_ID + " text,"
                + Constant.LIFE_INDEX_NAME + " text,"
                + Constant.LIFE_INDEX_LIFE_INDEX + " text,"
                + Constant.LIFE_INDEX_DETAILS + " text)";
        db.execSQL(lifeIndexSQL);

        //创建城市表
        String citySQL = "create table " + Constant.TABLE_CITY + "("
                + Constant.CITY_ID + " text primary key,"
                + Constant.CITY_TIME + " text,"
                + Constant.CITY_NAME + " text,"
                + Constant.CITY_TEMPERATURE + " text,"
                + Constant.CITY_CODE + " text)";
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