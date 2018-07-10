package com.example.android.architecture.blueprints.todoapp.common;

public class Constant {

    //**************** 数据库相关常量 start ****************
    public static final String DB_NAME = "weather.db"; //数据库名称
    public static final int DB_VERSION = 1; //数据库版本

    //============ 主页面数据表 start ============
    public static final String TABLE_WEATHER = "weather";
    public static final String WEATHER_ID = "_id";

    //------------ 地理位置 start ------------
    public static final String TABLE_LOCATION = "location";
    public static final String LOCATION_ID = "_id";
    public static final String LOCATION_NAME = "name";
    public static final String LOCATION_COUNTRY = "country";
    public static final String LOCATION_PATH = "path";
    public static final String LOCATION_TIMEZONE = "timezone";
    public static final String LOCATION_TIMEZONE_OFFSET = "timezone_offset";
    //------------ 地理位置 end ------------

    //------------ 今天天气 start ------------
    public static final String TABLE_NOW = "now";
    public static final String NOW_ID = "_id";
    public static final String NOW_TEXT = "text";
    public static final String NOW_CODE = "code";
    public static final String NOW_TEMPERATURE = "temperature";
    //------------ 今天天气 end ------------

    //------------ 未来天气 start ------------
    public static final String TABLE_DAILY = "daily";
    public static final String DAILY_DATE = "date";
    public static final String DAILY_DATE_DAY = "text_day";
    public static final String DAILY_CODE_DAY = "code_day";
    public static final String DAILY_TEXT_NIGHT = "text_night";
    public static final String DAILY_CODE_NIGHT = "code_night";
    public static final String DAILY_HIGH = "high";
    public static final String DAILY_LOW = "low";
    public static final String DAILY_PRECIP = "precip";
    public static final String DAILY_DIRECTION = "wind_direction";
    public static final String DAILY_DIRECTION_DEGREE = "wind_direction_degree";
    public static final String DAILY_WIND_SPEED = "wind_speed";
    public static final String DAILY_WIND_SCALE = "wind_scale";
    //------------ 未来天气 start ------------

    //------------ 生活指数 start ------------
    public static final String TABLE_LIFE_INDEX = "life_index";
    public static final String LIFE_INDEX_ID = "_id";
    public static final String LIFE_INDEX_name = "name";
    public static final String LIFE_INDEX_INDEX = "index";
    public static final String LIFE_INDEX_DETAILS = "details";
    //------------ 生活指数 end ------------

    public static final String WEATHER_LAST_UPDATE = "last_update"; //字段
    //============ 主页面数据表 end ============

    //============ 城市数据表 start ============
    public static final String TABLE_CITY = "city";
    public static final String CITY_ID = "_id";
    public static final String CITY_TIME = "time";
    public static final String CITY_NAME = "name";
    public static final String CITY_TEMPERATURE = "temperature";
    public static final String CITY_CODE = "code";

    //============ 城市数据表 start ============
    //**************** 数据库相关常量 end ****************

}