package com.example.android.architecture.blueprints.todoapp.data.db.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.architecture.blueprints.todoapp.common.Constant;
import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.life.LifeIndex;
import com.example.android.architecture.blueprints.todoapp.data.weather.Weather;
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

        long weatherResult = 0;//记录插入数据的返回结果 如果插入数据成功则返回值大于0 否则插入失败
        boolean forecastResult = false;
        boolean lifeIndexResult = false;

        //插入数据之前先从数据库查询是否存在该城市数据 如果存在则找到该城市信息ID然后更新数据 否则添加数据到数据库
        if (query(Constant.TABLE_WEATHER, weather.getLocation().getId())) {
            update(weather);
        } else {
            weatherResult = db.insert(Constant.TABLE_WEATHER, null, weatherValues(weather));
            forecastResult = insertOrUpdateForecast(weather, Constant.INSERT);// 添加数据
            lifeIndexResult = insertOrUpdateLifeIndex(weather, Constant.INSERT);//添加数据
        }
        if (weatherResult > 0 && forecastResult && lifeIndexResult) {
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
    public boolean update(Weather weather) {
        long weatherResult = 0; //同理 insert()
        boolean forecastResult = false; //同理 insert()
        boolean lifeIndexResult = false; //同理 insert()
        //查询是否存在该城市信息 如果存在则更新数据
        if (query(weather)) {
            weatherResult = db.update(Constant.TABLE_WEATHER, weatherValues(weather), Constant.CITY_ID + "=?", new String[]{weather.getLocation().getId()});
            forecastResult = insertOrUpdateForecast(weather, Constant.UPDATE); //更新数据
            lifeIndexResult = insertOrUpdateLifeIndex(weather, Constant.UPDATE);//更新数据
        }
        if (weatherResult > 0 && forecastResult && lifeIndexResult) {
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
    public boolean query(Weather weather) {
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
     * 根据地址名称对应城市ID
     *
     * @param locationName 查询的名字
     * @return 返回查询ID
     */
    @Deprecated
    public String queryCity(String locationName) {
        String locationId = null;
        cursor = db.query(Constant.TABLE_WEATHER, null, Constant.WEATHER_NAME + "=?", new String[]{locationName}, null, null, null);
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

    /**
     * 根据城市ID查询天气信息
     *
     * @param locationId 城市ID
     * @return 天气数据
     */
    @Deprecated
    public Weather queryWeatherById(String locationId) {

        //weather
        String id;
        String time;
        String name;
        String text;
        String code;
        String temperature;
        String last_update;
        List<Daily.ResultsBean.DailyBean> forecastList = new ArrayList<>();
        List<LifeIndex> lifeIndexList = new ArrayList<>();

        //forecast
        String forecast_id;
        String forecast_location_id;
        String forecast_text;
        String forecast_height;
        String forecast_low;
        String forecast_code;

        //lifeindex
        int life_index_id;
        String life_index_location_id;
        String life_index_name;
        String life_index_life_index;
        String life_index_details;

        Weather weather = new Weather();
        Daily.ResultsBean.DailyBean dailyBean = new Daily.ResultsBean.DailyBean();
        LifeIndex lifeIndex = new LifeIndex();

        /*
        WeatherDB weatherDB = new WeatherDB();
        WeatherDB.Forecast forecast = new WeatherDB.Forecast();
        WeatherDB.LifeIndex lifeIndex = new WeatherDB.LifeIndex();
        */
        cursor = db.query(Constant.TABLE_WEATHER, null, Constant.WEATHER_ID + "=?", new String[]{locationId}, null, null, null);
        if (cursor.moveToNext()) {
            /*
            id = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_ID));
            time = String.valueOf(System.currentTimeMillis());
            name = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_NAME));
            text = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_TEXT));
            code = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_CODE));
            temperature = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_TEMPERATURE));
            last_update = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_LAST_UPDATE));

            forecast_id = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_ID));
            forecast_location_id = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_LOCATION_ID));
            forecast_text = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_TEXT));
            forecast_height = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_HEIGHT));
            forecast_low = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_LOW));
            forecast_code = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_CODE));

            life_index_id = cursor.getString(cursor.getColumnIndex(Constant.LIFE_INDEX_ID));
            life_index_location_id = cursor.getString(cursor.getColumnIndex(Constant.LIFE_INDEX_LOCATION_ID));
            life_index_name = cursor.getString(cursor.getColumnIndex(Constant.LIFE_INDEX_NAME));
            life_index_life_index = cursor.getString(cursor.getColumnIndex(Constant.LIFE_INDEX_LIFE_INDEX));
            life_index_details = cursor.getString(cursor.getColumnIndex(Constant.LIFE_INDEX_DETAILS));

            forecast.set_id(forecast_id);
            forecast.setLocation_id(forecast_location_id);
            forecast.setText(forecast_text);
            forecast.setHeight(forecast_height);
            forecast.setLow(forecast_low);
            forecast.setCode(forecast_code);
            forecastList.add(forecast);

            lifeIndex.set_id(life_index_id);
            lifeIndex.setLocation_id(life_index_location_id);
            lifeIndex.setName(life_index_name);
            lifeIndex.setLife_index(life_index_life_index);
            lifeIndex.setDetails(life_index_details);
            lifeIndexList.add(lifeIndex);

            weatherDB.setId(id);
            weatherDB.setTime(time);
            weatherDB.setName(name);
            weatherDB.setText(text);
            weatherDB.setCode(code);
            weatherDB.setTemperature(temperature);
            weatherDB.setLast_update(last_update);
            weatherDB.setForecastList(forecastList);
            weatherDB.setLifeIndexList(lifeIndexList);
            */

            id = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_ID));
            time = String.valueOf(System.currentTimeMillis());
            name = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_NAME));
            text = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_TEXT));
            code = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_CODE));
            temperature = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_TEMPERATURE));
            last_update = cursor.getString(cursor.getColumnIndex(Constant.WEATHER_LAST_UPDATE));

            forecast_id = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_ID));
            forecast_location_id = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_LOCATION_ID));
            forecast_text = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_TEXT));
            forecast_height = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_HEIGHT));
            forecast_low = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_LOW));
            forecast_code = cursor.getString(cursor.getColumnIndex(Constant.FORECAST_CODE));

            life_index_id = cursor.getInt(cursor.getColumnIndex(Constant.LIFE_INDEX_ID));
            life_index_location_id = cursor.getString(cursor.getColumnIndex(Constant.LIFE_INDEX_LOCATION_ID));
            life_index_name = cursor.getString(cursor.getColumnIndex(Constant.LIFE_INDEX_NAME));
            life_index_life_index = cursor.getString(cursor.getColumnIndex(Constant.LIFE_INDEX_LIFE_INDEX));
            life_index_details = cursor.getString(cursor.getColumnIndex(Constant.LIFE_INDEX_DETAILS));

            dailyBean.setText_day(forecast_text);
            //dailyBean.setHeight(forecast_height);
            dailyBean.setLow(forecast_low);
            //dailyBean.setCode(forecast_code);
            forecastList.add(dailyBean);

            lifeIndex.setId(life_index_id);
            lifeIndex.setName(life_index_name);
            lifeIndex.setIndex(life_index_life_index);
            lifeIndex.setDetails(life_index_details);
            lifeIndexList.add(lifeIndex);

            //weather.setId(id);
            //weather.setTime(time);
            //weather.setName(name);
            //weather.setText(text);
            //weather.setCode(code);
            //weather.setTemperature(temperature);

            weather.setLast_update(last_update);
            weather.setDaily(forecastList);
            weather.setLifeIndexList(lifeIndexList);

            closeDB();
            return weather;
        } else {
            closeDB();
            return weather;
        }
    }

    /**
     * 添加或更新天气数据
     *
     * @param weather
     * @return
     */
    private ContentValues weatherValues(Weather weather) {
        ContentValues weatherContentValues = new ContentValues();
        weatherContentValues.put(Constant.WEATHER_ID, weather.getLocation().getId());
        weatherContentValues.put(Constant.WEATHER_TIME, String.valueOf(System.currentTimeMillis()));//时间戳
        weatherContentValues.put(Constant.WEATHER_NAME, weather.getLocation().getName());
        weatherContentValues.put(Constant.WEATHER_TEXT, weather.getNow().getText());
        weatherContentValues.put(Constant.WEATHER_CODE, weather.getNow().getCode());
        weatherContentValues.put(Constant.WEATHER_TEMPERATURE, weather.getNow().getTemperature());
        weatherContentValues.put(Constant.WEATHER_LAST_UPDATE, weather.getLast_update());
        return weatherContentValues;
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

            Daily.ResultsBean.DailyBean dailyBean = weather.getDaily().get(i);
            ContentValues fccv = new ContentValues();

            fccv.put(Constant.FORECAST_ID, i);//作为主键
            fccv.put(Constant.FORECAST_LOCATION_ID, weather.getLocation().getId());

            //这里使用StringBuffer代替String进行字符串拼接 因为String进行字符串拼接的时候会产生很多临时变量 影响性能 :)
            StringBuffer stringBuffer = new StringBuffer();
            //如果白天和晚上天气一样就直接显示任意一个天气描述即可 否则就是格式为: 白天(晴)到晚上(多云) -> 晴到多云
            if (dailyBean.getText_day().equals(dailyBean.getText_night())) {
                stringBuffer.append(dailyBean.getText_day());
            } else {
                stringBuffer.append(dailyBean.getText_day());
                stringBuffer.append("到");
                stringBuffer.append(dailyBean.getText_night());
            }

            fccv.put(Constant.FORECAST_TEXT, stringBuffer.toString());
            fccv.put(Constant.FORECAST_HEIGHT, dailyBean.getHigh());
            fccv.put(Constant.FORECAST_LOW, dailyBean.getLow());
            fccv.put(Constant.FORECAST_CODE, dailyBean.getCode_day());

            switch (DBEvent) {
                case Constant.INSERT:
                    result = db.insert(Constant.TABLE_FORECAST, null, fccv);
                    Logger.d(result+"添加未来天气数据成功");
                    break;
                case Constant.UPDATE:
                    result = db.update(Constant.TABLE_FORECAST, fccv, Constant.FORECAST_LOCATION_ID + "=?", new String[]{weather.getLocation().getId()});
                    Logger.d(result+"更新未来天气数据成功");
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
            licv.put(Constant.LIFE_INDEX_ID, i);
            licv.put(Constant.LIFE_INDEX_LOCATION_ID, weather.getLocation().getId());
            licv.put(Constant.LIFE_INDEX_NAME, lifeIndex.getName());
            licv.put(Constant.LIFE_INDEX_LIFE_INDEX, lifeIndex.getIndex());
            licv.put(Constant.LIFE_INDEX_DETAILS, lifeIndex.getDetails());

            Logger.d(licv.toString());

            switch (DBEvent) {
                case Constant.INSERT:
                    result = db.insert(Constant.TABLE_LIFE_INDEX, null, licv);
                    Logger.d(result);
                    Logger.d("添加生活指数数据成功");
                    break;
                case Constant.UPDATE:
                    result = db.update(Constant.TABLE_LIFE_INDEX, weatherValues(weather), Constant.LIFE_INDEX_LOCATION_ID + "=?", new String[]{weather.getLocation().getId()});
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
        long deleteResult = 0; //同理 insert()
        //如果存在城市信息则进行删除操作      ??? 应该一定存在该城市信息吧
        if (query(Constant.TABLE_CITY, cityId)) {
            deleteResult = db.delete(Constant.TABLE_CITY, Constant.CITY_ID + "=?", new String[]{cityId});
            Logger.d(deleteResult);
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
        List<City> cities = DBManger.cursorToList(cursor);
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
        List<City> cities = DBManger.cursorToList(cursor);
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