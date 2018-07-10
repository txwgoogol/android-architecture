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

        //创建首页天气表
        String weatherSQL = "create table weather(_id,name,text,code,temperature,last_time)";
        db.execSQL(weatherSQL);

        //创建首页天气预报表
        String forecastSQL = "create table forecast(_id,location_id,time,text,high,low)";
        db.execSQL(forecastSQL);

        //创建生活指数表
        String lifeIndexSQL = "create table life_index(_id,location_id,name,life_index,detail)";
        db.execSQL(lifeIndexSQL);

        //创建城市表
        String citySQL = "create table "
                + Constant.TABLE_CITY
                + "("
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