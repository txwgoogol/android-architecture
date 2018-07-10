package com.example.android.architecture.blueprints.todoapp.data.db.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.architecture.blueprints.todoapp.common.Constant;
import com.example.android.architecture.blueprints.todoapp.data.city.City;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库管理类
 */
public class DBManger {

    private static DBHelper dbHelper;

    /**
     * 采用单例的形式初始化DBHelper实例
     *
     * @param context 上下文参数
     * @return DBHelper对象
     */
    public static DBHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }
        return dbHelper;
    }

    /**
     * 根据sql语句在数据库中执行语句
     *
     * @param db  数据库对象
     * @param sql sql语句
     */
    public static void execSQL(SQLiteDatabase db, String sql) {
        if (db != null) {
            if (sql != null && !"".equals(sql)) {
                db.execSQL(sql);
            }
        }
    }

    /**
     * 将cursor数据转换为list数组
     * @param cursor cursor 对象
     * @return list数组
     */
    public static List<City> cursorToList(Cursor cursor){
        List<City> list = new ArrayList<>();

        while (cursor.moveToNext()){

            String _id = cursor.getString(cursor.getColumnIndex(Constant.CITY_ID));
            String time = cursor.getString(cursor.getColumnIndex(Constant.CITY_TIME));
            String name = cursor.getString(cursor.getColumnIndex(Constant.CITY_NAME));
            String temperature = cursor.getString(cursor.getColumnIndex(Constant.CITY_TEMPERATURE));
            String code = cursor.getString(cursor.getColumnIndex(Constant.CITY_CODE));

            City city = new City();
            city.setId(_id);
            city.setTime(time);
            city.setName(name);
            city.setTemperature(temperature);
            city.setCode(code);

            list.add(city);
        }
        return list;
    }

}