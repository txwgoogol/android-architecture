package com.example.android.architecture.blueprints.todoapp.data.db.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.architecture.blueprints.todoapp.common.Constant;
import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * 数据库工具类
 */
public class DBUtils {

    //数据库操作事件
    private static final int INSERT = 1;
    private static final int DELETE = 2;
    private static final int UPDATE = 3;
    private static final int QUERY = 4;

    //SQLite数据库辅助类
    private static SQLiteDatabase db;

    /**
     * 有参构造函数
     *
     * @param context 上下文参数
     */
    public DBUtils(Context context) {
        db = DBManger.getInstance(context).getWritableDatabase();//初始化数据库
    }

    /**
     * 实例化DBUtils对象
     *
     * @param context 上下文参数
     * @return 返回DBUtils实例对象
     */
    public static DBUtils getInstance(Context context) {
        return new DBUtils(context);
    }

    //================ 城市列表数据库的添删改查 start ================

    /**
     * 添加数据
     *
     * @param city 城市对象
     * @return 返回添加数据结果
     */
    public boolean insert(City city) {
        long insertResult = 0;//记录插入数据的返回结果 如果插入数据成功则返回值大于0 否则插入失败
        //插入数据之前先从数据库查询是否存在该城市数据 如果存在则找到该城市信息ID然后更新数据 否则添加数据到数据库
        if (query(Constant.TABLE_CITY, city.getId())) {
            update(city);
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constant.CITY_ID, city.getId());
            contentValues.put(Constant.CITY_TIME, city.getTime());
            contentValues.put(Constant.CITY_NAME, city.getName());
            contentValues.put(Constant.CITY_TEMPERATURE, city.getTemperature());
            contentValues.put(Constant.CITY_CODE, city.getCode());
            insertResult = db.insert(Constant.TABLE_CITY, null, contentValues);
        }
        return result(insertResult, INSERT);
    }

    /**
     * 删除数据
     *
     * @param city
     * @return
     */
    public boolean delete(City city) {
        long deleteResult = 0; //同理 insert()
        //如果存在城市信息则进行删除操作      ??? 应该一定存在该城市信息吧
        if (query(Constant.TABLE_CITY, city.getId())) {
            deleteResult = db.delete(Constant.TABLE_CITY, Constant.CITY_ID + "=?", new String[]{city.getId()});
        }
        return result(deleteResult, DELETE);
    }

    /**
     * 更新加数据
     *
     * @param city
     * @return
     */
    public boolean update(City city) {
        long updateResult = 0; //同理 insert()
        //查询是否存在该城市信息 如果存在则更新数据 这里只更新CITY_TEMPERATURE,CITY_CODE
        if (query(Constant.TABLE_CITY, city.getId())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constant.CITY_TEMPERATURE, city.getTemperature());
            contentValues.put(Constant.CITY_CODE, city.getCode());
            updateResult = db.update(Constant.TABLE_CITY, contentValues, Constant.CITY_ID + "=?", new String[]{city.getId()});
        }
        return result(updateResult, UPDATE);
    }

    /**
     * 根据条件查询
     * 这里根据城市id查询
     *
     * @param table 表名
     * @param _id   城市id
     * @return 返回城市数据列表
     */
    public boolean query(String table, String _id) {
        Cursor cursor = db.query(table, null, Constant.CITY_ID + "=?", new String[]{_id}, null, null, null);
        List<City> cities = DBManger.cursorToList(cursor);
        return result(cities.size(), QUERY);
    }

    /**
     * 查询数据
     * 根据表名查询
     *
     * @param table 表名
     * @return 返回城市列表数据
     */
    public List<City> query(String table) {
        Cursor cursor = db.query(table, null, null, null, null, null, null);
        List<City> cities = DBManger.cursorToList(cursor);
        closeDB();
        return cities;
    }

    //================ 城市列表数据库的添删改查 end ================

    /**
     * 关闭数据库
     */
    private void closeDB() {
        if (db.isOpen()) {
            db.close();
        }
    }

    /**
     * 根据结果判断真假
     *
     * @param result  结果值
     * @param DBEvent 操作事件(添删改查)
     * @return 当值大于0返回true 否则返回false
     */
    private boolean result(long result, int DBEvent) {
        boolean isSuccess = false;
        switch (DBEvent) {
            case INSERT:
                /*
                if (result > 0) {
                    closeDB();
                    Logger.d("插入数据成功");
                    isSuccess = true;
                } else {
                    Logger.d("插入数据失败");
                    closeDB();
                    isSuccess = false;
                }
                break;
                */
            case DELETE:
                /*
                if (result > 0) {
                    closeDB();
                    Logger.d("删除数据成功");
                    isSuccess = true;
                } else {
                    Logger.d("删除数据失败");
                    closeDB();
                    isSuccess = false;
                }
                break;
                */
            case UPDATE:
                if (result > 0) {
                    closeDB();
                    Logger.d("操作数据成功");
                    isSuccess = true;
                } else {
                    Logger.d("操作数据失败");
                    closeDB();
                    isSuccess = false;
                }
                break;
            case QUERY:
                if (result > 0) {
                    //closeDB();
                    Logger.d("查询数据成功");
                    isSuccess = true;
                } else {
                    Logger.d("查询数据失败");
                    //closeDB();
                    isSuccess = false;
                }
                break;
        }
        return isSuccess;
    }

}