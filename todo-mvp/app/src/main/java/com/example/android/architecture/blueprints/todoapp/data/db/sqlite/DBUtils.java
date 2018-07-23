package com.example.android.architecture.blueprints.todoapp.data.db.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.architecture.blueprints.todoapp.common.Constant;
import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.life.LifeIndex;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.data.weather.Weather;
import com.example.android.architecture.blueprints.todoapp.util.TimeConvert;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库工具类
 */
public class DBUtils {

    //SQLite数据库辅助类
    private static SQLiteDatabase db;
    //游标 从数据库读取数据的
    private Cursor cursor;

    boolean weatherResult = false;
    boolean nowResult = false;
    boolean locationResult = false;
    boolean forecastResult = false;
    boolean lifeIndexResult = false;

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


    //================ 首页天气信息数据库表的添改查 START ================

    /**
     * 添加数据
     *
     * @param weather 天气对象
     * @return 返回添加数据结果
     */
    public boolean insert(Weather weather) {
        //插入数据之前先从数据库查询是否存在该城市数据 如果存在则找到该城市信息ID然后更新数据 否则添加数据到数据库
        if (query(Constant.TABLE_WEATHER, weather.getLocation().getId())) {
            updateWeather(weather);
        } else {
            weatherResult = insertOrUpdateWeather(weather, Constant.INSERT);
            locationResult = insertOrUpdateLocation(weather, Constant.INSERT);
            nowResult = insertOrUpdateNow(weather, Constant.INSERT);
            forecastResult = insertOrUpdateForecast(weather, Constant.INSERT);// 添加数据
            lifeIndexResult = insertOrUpdateLifeIndex(weather, Constant.INSERT);//添加数据
        }
        if (weatherResult && forecastResult && lifeIndexResult) {
            Logger.d("成功");
            return true;
        } else {
            Logger.d("失败");
            return false;
        }
    }

    /**
     * 更新数据
     *
     * @param weather
     * @return
     */
    public boolean updateWeather(Weather weather) {
        //查询是否存在该城市信息 如果存在则更新数据
        if (queryWeatherId(weather)) {
            weatherResult = insertOrUpdateWeather(weather, Constant.UPDATE);
            locationResult = insertOrUpdateLocation(weather, Constant.UPDATE);
            nowResult = insertOrUpdateNow(weather, Constant.UPDATE);
            forecastResult = insertOrUpdateForecast(weather, Constant.UPDATE); //更新数据
            lifeIndexResult = insertOrUpdateLifeIndex(weather, Constant.UPDATE);//更新数据
        }
        if (weatherResult && forecastResult && lifeIndexResult) {
            closeDB();
            return true;
        } else {
            closeDB();
            return false;
        }
    }

    /**
     * 查询数据
     * 根据表名查询
     *
     * @param weather 类名
     * @return 返回查询结果
     */
    public boolean queryWeatherId(Weather weather) {
        cursor = db.query(Constant.TABLE_WEATHER, null, Constant.WEATHER_ID + "=?", new String[]{weather.getLocation().getId()}, null, null, null);
        //根据cursor.moveToNext()的值判断真假    当cursor哦有数据的时候 返回true 否则 返回false
        if (cursor.moveToNext()) {
            closeDB();
            return true;
        } else {
            closeDB();
            return false;
        }
    }

    /**
     * 根据查询的地址名称返回对应城市ID
     *
     * @param locationName 查询的名字
     * @return 返回查询地址ID
     */
    @Deprecated
    public String queryWeatherCityName(String locationName) {
        String locationId = null;
        cursor = db.query(Constant.TABLE_WEATHER, null, Constant.WEATHER_ID + "=?", new String[]{locationName}, null, null, null);
        //根据cursor.moveToNext()的值判断真假    当cursor哦有数据的时候 返回true 否则 返回false
        if (cursor.moveToNext()) {
            locationId = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_ID));
            closeDB();
            return locationId;
        } else {
            closeDB();
            return locationId;
        }
    }

    //==================================================

    /**
     * 添加或更新天气数据
     *
     * @param weather
     * @return
     */
    public boolean insertOrUpdateWeather(Weather weather, int DBEvent) {

        //获取的是UTC时间 需要将其分割获取有效的时间显示
        String[] s = weather.getLast_update().split("\\+");

        long weatherResult = 0;
        ContentValues weatherContentValues = new ContentValues();
        weatherContentValues.put(Constant.WEATHER_ID, weather.getLocation().getId());
        weatherContentValues.put(Constant.WEATHER_LAST_UPDATE, TimeConvert.formatUTC(s[0]).toString());
        switch (DBEvent) {
            case Constant.INSERT:
                weatherResult = db.insert(Constant.TABLE_WEATHER, null, weatherContentValues);
                break;
            case Constant.UPDATE:
                weatherResult = db.update(Constant.TABLE_WEATHER, weatherContentValues, Constant.WEATHER_ID + "=?", new String[]{weather.getLocation().getId()});
                break;
        }
        return result(weatherResult, Constant.QUERY);
    }

    /**
     * 添加或更新位置信息数据
     *
     * @param weather
     * @return
     */
    public boolean insertOrUpdateLocation(Weather weather, int DBEvent) {
        long locationResult = 0;
        ContentValues locationContentValues = new ContentValues();
        locationContentValues.put(Constant.LOCATION_ID, weather.getLocation().getId());
        locationContentValues.put(Constant.LOCATION_NAME, weather.getLocation().getName());
        locationContentValues.put(Constant.LOCATION_COUNTRY, weather.getLocation().getCountry());
        locationContentValues.put(Constant.LOCATION_PATH, weather.getLocation().getPath());
        locationContentValues.put(Constant.LOCATION_TIMEZONE, weather.getLocation().getTimezone());
        locationContentValues.put(Constant.LOCATION_TIMEZONE_OFFSET, weather.getLocation().getTimezone_offset());
        locationContentValues.put(Constant.LOCATION_WEATHER_ID, weather.getLocation().getId());
        switch (DBEvent) {
            case Constant.INSERT:
                locationResult = db.insert(Constant.TABLE_LOCATION, null, locationContentValues);
                break;
            case Constant.UPDATE:
                locationResult = db.update(Constant.TABLE_LOCATION, locationContentValues, Constant.LOCATION_WEATHER_ID + "=?", new String[]{weather.getLocation().getId()});
                break;
        }
        return result(locationResult, Constant.QUERY);
    }

    /**
     * 添加或更新实时天气数据
     *
     * @param weather
     * @return
     */
    private boolean insertOrUpdateNow(Weather weather, int DBEvent) {
        long nowResult = 0;
        ContentValues nowContentValues = new ContentValues();
        nowContentValues.put(Constant.NOW_ID, weather.getLocation().getId());
        nowContentValues.put(Constant.NOW_TEXT, weather.getNow().getText());
        nowContentValues.put(Constant.NOW_CODE, weather.getNow().getCode());
        nowContentValues.put(Constant.NOW_TEMPERATURE, weather.getNow().getTemperature());
        nowContentValues.put(Constant.NOW_WEATHER_ID, weather.getLocation().getId());
        switch (DBEvent) {
            case Constant.INSERT:
                nowResult = db.insert(Constant.TABLE_NOW, null, nowContentValues);
                break;
            case Constant.UPDATE:
                nowResult = db.update(Constant.TABLE_NOW, nowContentValues, Constant.NOW_WEATHER_ID + "=?", new String[]{weather.getLocation().getId()});
                break;
        }
        return result(nowResult, Constant.QUERY);
    }

    /**
     * 未来三天天气数据添加或更新
     *
     * @param weather
     * @param DBEvent 数据库操作事件 数据的添删改查
     * @return
     */
    private boolean insertOrUpdateForecast(Weather weather, int DBEvent) {
        long result = 0;
        for (int i = 0; i < weather.getDaily().size(); i++) {

            Logger.d(weather.getDaily().get(i).getDate());

            //String[] s = weather.getDaily().get(i).getDate().split("\\+");

            Daily.ResultsBean.DailyBean dailyBean = weather.getDaily().get(i);
            ContentValues fccv = new ContentValues();
            fccv.put(Constant.FORECAST_ID, weather.getLocation().getId());
            fccv.put(Constant.FORECAST_WEATHER_ID, weather.getLocation().getId());
            fccv.put(Constant.FORECAST_DATE, weather.getDaily().get(i).getDate());
            fccv.put(Constant.FORECAST_TEXT_DAY, dailyBean.getText_day());
            fccv.put(Constant.FORECAST_CODE_DAY, dailyBean.getCode_day());
            fccv.put(Constant.FORECAST_TEXT_NIGHT, dailyBean.getText_night());
            fccv.put(Constant.FORECAST_CODE_NIGHT, dailyBean.getCode_night());
            fccv.put(Constant.FORECAST_HIGH, dailyBean.getHigh());
            fccv.put(Constant.FORECAST_LOW, dailyBean.getLow());
            fccv.put(Constant.FORECAST_PRECIP, dailyBean.getPrecip());
            fccv.put(Constant.FORECAST_WIND_DIRECTION, dailyBean.getWind_direction());
            fccv.put(Constant.FORECAST_WIND_DIRECTION_DEGREE, dailyBean.getWind_direction_degree());
            fccv.put(Constant.FORECAST_WIND_SPEED, dailyBean.getWind_speed());
            fccv.put(Constant.FORECAST_WIND_SCALE, dailyBean.getWind_scale());

            switch (DBEvent) {
                case Constant.INSERT:
                    result = db.insert(Constant.TABLE_FORECAST, null, fccv);
                    Logger.d(result + "添加未来天气数据成功");
                    break;
                case Constant.UPDATE:
                    result = db.update(Constant.TABLE_FORECAST, fccv, Constant.FORECAST_WEATHER_ID + "=?", new String[]{weather.getLocation().getId()});
                    Logger.d(result + "更新未来天气数据成功");
                    break;
            }
        }
        Logger.d(result);
        return result(result, Constant.QUERY);
    }

    /**
     * 生活指数
     *
     * @param weather
     * @param DBEvent
     * @return
     */
    private boolean insertOrUpdateLifeIndex(Weather weather, int DBEvent) {
        long result = 0;
        for (int i = 0; i < weather.getLifeIndexList().size(); i++) {
            LifeIndex lifeIndex = weather.getLifeIndexList().get(i);

            ContentValues licv = new ContentValues();
            licv.put(Constant.LIFE_INDEX_ID, lifeIndex.getId() + "");
            licv.put(Constant.LIFE_INDEX_NAME, lifeIndex.getName());
            licv.put(Constant.LIFE_INDEX_LIFE_INDEX, lifeIndex.getIndex());
            licv.put(Constant.LIFE_INDEX_DETAILS, lifeIndex.getDetails());
            licv.put(Constant.LIFE_INDEX_WEATHER_ID, weather.getLocation().getId());

            Logger.d(licv.toString());

            switch (DBEvent) {
                case Constant.INSERT:
                    result = db.insert(Constant.TABLE_LIFE_INDEX, null, licv);
                    Logger.d(result);
                    Logger.d("添加生活指数数据成功");
                    break;
                case Constant.UPDATE:
                    result = db.update(Constant.TABLE_LIFE_INDEX, licv, Constant.LIFE_INDEX_WEATHER_ID + "=?", new String[]{weather.getLocation().getId()});
                    Logger.d("更新生活指数数据成功");
                    break;
            }
        }
        Logger.d(result);
        return result(result, Constant.INSERT);
    }

    //================ 首页天气信息数据库表的添改查 END ================


    //================ 城市列表数据库表的添删改查 STAR ================

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
        return result(insertResult, Constant.INSERT);
    }

    /**
     * 删除数据
     *
     * @param cityId
     * @return
     */
    public boolean delete(String cityId) {
        long deleteResult = 0;
        //如果存在城市信息则进行删除操作      ??? 应该一定存在该城市信息吧
        if (query(Constant.TABLE_CITY, cityId)) {
            deleteResult = db.delete(Constant.TABLE_CITY, Constant.CITY_ID + "=?", new String[]{cityId});
        }
        return result(deleteResult, Constant.DELETE);
    }

    /**
     * 删除数据
     *
     * @param cityId
     * @return
     */
    public boolean deleteCityAndWeather(String cityId) {
        long deleteResult = 0;

        boolean city = false;
        boolean location = false;
        boolean now = false;
        boolean forecast = false;
        boolean life_index = false;
        boolean weather = false;
        //如果存在城市信息则进行删除操作      ??? 应该一定存在该城市信息吧
        if (query(Constant.TABLE_CITY, cityId)) {
            city = db.delete(Constant.TABLE_CITY, Constant.CITY_ID + "=?", new String[]{cityId}) > 0 ? true : false;
            location = db.delete(Constant.TABLE_LOCATION, Constant.LOCATION_WEATHER_ID + "=?", new String[]{cityId}) > 0 ? true : false;
            now = db.delete(Constant.TABLE_NOW, Constant.NOW_WEATHER_ID + "=?", new String[]{cityId}) > 0 ? true : false;
            forecast = db.delete(Constant.TABLE_FORECAST, Constant.FORECAST_WEATHER_ID + "=?", new String[]{cityId}) > 0 ? true : false;
            weather = db.delete(Constant.TABLE_LIFE_INDEX, Constant.LIFE_INDEX_WEATHER_ID + "=?", new String[]{cityId}) > 0 ? true : false;
            db.delete(Constant.TABLE_WEATHER, Constant.WEATHER_ID + "=?", new String[]{cityId});
        }

        if (city && location && now && forecast && life_index && weather) {
            deleteResult = 1;
        } else {
            deleteResult = -1;
        }

        return result(deleteResult, Constant.DELETE);
    }

    /**
     * 更新数据
     *
     * @param city
     * @return
     */
    public boolean update(City city) {
        long updateResult = 0; //同理 insert()
        //查询是否存在该城市信息 如果存在则更新数据 这里只更新CITY_TEMPERATURE,CITY_CODE
        if (query(Constant.TABLE_CITY, city.getId())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constant.CITY_TEMPERATURE, city.getTemperature()); // 2018-7-13  temp=33 code=4  看看数据有木有更新
            contentValues.put(Constant.CITY_CODE, city.getCode());
            updateResult = db.update(Constant.TABLE_CITY, contentValues, Constant.CITY_ID + "=?", new String[]{city.getId()});
        }
        return result(updateResult, Constant.UPDATE);
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
        cursor = db.query(table, null, Constant.CITY_ID + "=?", new String[]{_id}, null, null, null);
        List<City> cities = DBManger.cursorToList(cursor, Constant.TABLE_ID_CITY);
        return result(cities.size(), Constant.QUERY);
    }

    /**
     * 查询数据
     * 根据表名查询
     *
     * @param table 表名
     * @return 返回城市列表数据
     */
    public List<City> query(String table) {
        cursor = db.query(table, null, null, null, null, null, null);
        List<City> cities = DBManger.cursorToList(cursor, Constant.TABLE_ID_CITY);
        for (City c : cities) {
            Logger.d(c.toString());
        }
        closeDB();
        return cities;
    }

    /**
     * 关闭数据库
     */
    private void closeDB() {
        if (db.isOpen()) {
            db.close();
        }
        if (!cursor.isClosed()) {
            cursor.close();
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
            case Constant.INSERT:
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
            case Constant.DELETE:
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
            case Constant.UPDATE:
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
            case Constant.QUERY:
                if (result > 0) {
                    Logger.d("查询数据成功");
                    isSuccess = true;
                } else {
                    Logger.d("查询数据失败");
                    isSuccess = false;
                }
                break;
        }
        return isSuccess;
    }

    //================ 城市列表数据库表的添删改查 END ================

}