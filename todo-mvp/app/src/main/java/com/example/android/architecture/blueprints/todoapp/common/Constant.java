package com.example.android.architecture.blueprints.todoapp.common;

/**
 * App中使用的常量
 */
public class Constant {

    //**************** 接口常量 START ****************

    //------------ 基础接口 START ------------
    public static String BASE_URL = "https://api.seniverse.com/v3/";
    //------------ 基础接口 END ------------

    //**************** 接口常量 START ****************

    //**************** 通用常量 START ****************

    //------------ 数字相关 START ------------
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    //------------ 数字相关 END ------------

    //------------ 数据库操作事件 START ------------
    public static final int INSERT = 1;
    public static final int DELETE = 2;
    public static final int UPDATE = 3;
    public static final int QUERY = 4;
    //------------ 数据库操作事件 END ------------

    //**************** 通用常量 END ****************


    //**************** 数据库相关常量(所有表的ID均已城市ID做为主键) START ****************
    public static final String DB_NAME = "weather.db"; //数据库名称
    public static final int DB_VERSION = 1; //数据库版本

    //============ 主页面数据表 START ============

    //------------ 头部天气信息 START ------------
    public static final String TABLE_WEATHER = "weather";
    public static final String WEATHER_ID = "_id"; //城市ID
    public static final String WEATHER_TIME = "time"; //时间戳 保存当前数据的时间 用于判断数据库是否应该更新
    public static final String WEATHER_NAME = "name"; //城市名称
    public static final String WEATHER_TEXT = "text"; //天气情况
    public static final String WEATHER_CODE = "code"; //天气代码
    public static final String WEATHER_TEMPERATURE = "temperature"; //温度
    public static final String WEATHER_LAST_UPDATE = "last_update"; //最近更新时间
    //------------ 头部天气信息 END ------------

    //------------ 地理位置 START ------------
    //public static final String TABLE_LOCATION = "location";
    //public static final String LOCATION_ID = "_id";
    //public static final String LOCATION_NAME = "name";
    //public static final String LOCATION_COUNTRY = "country";
    //public static final String LOCATION_PATH = "path";
    //public static final String LOCATION_TIMEZONE = "timezone";
    //public static final String LOCATION_TIMEZONE_OFFSET = "timezone_offset";
    //------------ 地理位置 END ------------

    //------------ 今天天气 START ------------
    //public static final String TABLE_NOW = "now";
    //public static final String NOW_ID = "_id";
    //public static final String NOW_TEXT = "text";
    //public static final String NOW_CODE = "code";
    //public static final String NOW_TEMPERATURE = "temperature";
    //------------ 今天天气 END ------------

    //------------ 未来三天天气 START ------------
    public static final String TABLE_FORECAST = "forecast";
    public static final String FORECAST_ID = "_id"; //ID
    public static final String FORECAST_LOCATION_ID = "location_id"; //城市ID
    public static final String FORECAST_TEXT = "text"; //天气情况  有白天和晚上天气  这里就存储格式为(白天(晴)-晚上(多云)：晴转多云) 如何 :) 
    public static final String FORECAST_HEIGHT = "height"; //最高温度
    public static final String FORECAST_LOW = "low"; //最低温度
    public static final String FORECAST_CODE = "code"; //天气情况码
    //------------ 未来三天天气 START ------------

    //------------ 生活指数 START ------------
    public static final String TABLE_LIFE_INDEX = "life_index";
    public static final String LIFE_INDEX_ID = "_id"; //主键ID
    public static final String LIFE_INDEX_LOCATION_ID = "location_id"; //ID
    public static final String LIFE_INDEX_NAME = "name"; //名称
    public static final String LIFE_INDEX_LIFE_INDEX = "life_index"; //指数
    public static final String LIFE_INDEX_DETAILS = "details"; //详情
    //------------ 生活指数 END ------------

    //============ 主页面数据表 END ============

    //============ 城市数据表 START ============
    public static final String TABLE_CITY = "city";
    public static final String CITY_ID = "_id"; //城市ID
    public static final String CITY_TIME = "time"; //当前时间 就当作时间戳吧 用于判断是否需要更新数据
    public static final String CITY_NAME = "name"; //城市名称
    public static final String CITY_TEMPERATURE = "temperature"; //当前温度
    public static final String CITY_CODE = "code"; //天气情况代码 根据代码做对象的背景展示 

    //============ 城市数据表 END ============
    //**************** 数据库表/字段相关常量 END ****************

}