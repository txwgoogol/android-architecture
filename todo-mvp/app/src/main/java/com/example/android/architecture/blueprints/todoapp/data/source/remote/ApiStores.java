package com.example.android.architecture.blueprints.todoapp.data.source.remote;

import com.example.android.architecture.blueprints.todoapp.data.Results;
import com.example.android.architecture.blueprints.todoapp.data.air.AirDaily;
import com.example.android.architecture.blueprints.todoapp.data.air.AirHourly;
import com.example.android.architecture.blueprints.todoapp.data.air.AirNow;
import com.example.android.architecture.blueprints.todoapp.data.air.AirRanking;
import com.example.android.architecture.blueprints.todoapp.data.geo.Moon;
import com.example.android.architecture.blueprints.todoapp.data.geo.Sun;
import com.example.android.architecture.blueprints.todoapp.data.life.ChineseCalendar;
import com.example.android.architecture.blueprints.todoapp.data.life.DrivingRestriction;
import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.location.Location;
import com.example.android.architecture.blueprints.todoapp.data.tide.TideDaily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Alarm;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Hourly;
import com.example.android.architecture.blueprints.todoapp.data.weather.Hourly3h;
import com.example.android.architecture.blueprints.todoapp.data.weather.HourlyHistory;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.data.weather.grid.NowGrid;
import com.example.android.architecture.blueprints.todoapp.data.weather.grid.Minutely;
import com.example.android.architecture.blueprints.todoapp.data.weather.robot.Talk;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 接口
 * Created by txw on 2018/4/3.
 */
public interface ApiStores {

    String BASE_URL = "https://api.seniverse.com/v3/";

    /**
     * 天气实况
     * 获取指定城市的天气实况。付费用户可获取全部数据，免费用户只返回天气现象文字、代码和气温3项数据。注：中国城市暂不支持云量和露点温度。
     *
     * @return weather/now.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&unit=c
     */
    @GET("weather/now.json")
    Call<Now> getNow(@Query("key") String key, @Query("location") String location, @Query("language") String language, @Query("unit") String unit);

    /**
     * 格点天气实况（付费接口）
     * 获取指定经纬度的实况天气数据。数据精度是3x3公里，区域范围覆盖中国。
     *
     * @return weather/grid/now.json?key=52zpuzgswyulc0w6&location=39.865927:116.359805
     */
    @GET("weather/grid/now.json")
    Call<NowGrid> getGridNow(@Query("key") String key, @Query("location") String location);

    /**
     * 分钟级降水预报（付费接口）
     * 获取指定经纬度的分钟级降水预报。数据精度是1x1公里，区域范围覆盖中国。
     *
     * @return weather/grid/minutely.json?key=52zpuzgswyulc0w6&location=39.865927:116.359805
     */
    @GET("weather/grid/minutely.json")
    Call<Minutely> getMinutely(@Query("key") String key, @Query("location") String location);

    /**
     * 逐日天气预报和昨日天气
     * 获取指定城市未来最多15天每天的白天和夜间预报，以及昨日的历史天气。付费用户可获取全部数据，免费用户只返回3天天气预报。
     *
     * @return weather/daily.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&unit=c&start=0&days=5
     */
    @GET("weather/daily.json")
    Call<Daily> getWeather(@Query("key") String key, @Query("location") String location, @Query("language") String language, @Query("unit") String unit, @Query("start") String start, @Query("days") String days);

    /**
     * 24小时逐小时天气预报 付费接口
     * 获取指定城市未来最多24小时的逐小时天气预报，支持全球城市。
     *
     * @return weather/hourly.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&unit=c&start=0&hours=24
     */
    @GET("weather/hourly.json")
    Call<Hourly> getHourly(@Query("key") String key, @Query("location") String location, @Query("language") String language, @Query("unit") String unit, @Query("start") String start, @Query("hours") String hours);

    /**
     * 过去24小时历史天气（付费接口）
     * 获取指定城市过去24小时逐小时的历史天气。
     *
     * @return weather/hourly_history.json?key=52zpuzgswyulc0w6&location=seattle&language=zh-Hans&unit=c
     */
    @GET("weather/hourly_history.json")
    Call<HourlyHistory> getHourlyHistory(@Query("key") String key, @Query("location") String location, @Query("language") String language, @Query("unit") String unit);

    /**
     * 15天逐3小时精细化天气预报（付费接口）
     * 获取指定城市未来15天的精细化天气预报。未来3天逐3小时；未来4-6天逐6小时；未来7-15天逐12小时
     *
     * @return weather/hourly3h.json?key=52zpuzgswyulc0w6&location=beijing
     */
    @GET("weather/hourly3h.json")
    Call<Hourly3h> getHourly3h(@Query("key") String key, @Query("location") String location);

    /**
     * 气象灾害预警（付费接口）
     * 获取当前所有城市或指定城市的气象灾害预警信息。当前城市无预警信息时返回值为空，请做好空值处理。
     *
     * @return weather/alarm.json?key=52zpuzgswyulc0w6&location=beijing
     */
    @GET("weather/alarm.json")
    Call<Alarm> getAlarm(@Query("key") String key, @Query("location") String location);

    /**
     * 自然语言天气查询（付费接口）
     * 理解自然语言请求，返回自然语言的回答及结构化的天气数据，方便智能硬件等实现基于语音请求的天气查询。
     *
     * @return robot/talk.json?key=52zpuzgswyulc0w6&q=北京明天天气怎么样？
     */
    @GET("robot/talk.json")
    Call<Talk> getTalk(@Query("key") String key, @Query("q") String q);

    /**
     * 空气质量实况（付费接口）
     * 获取指定城市的AQI、PM2.5、PM10、一氧化碳、二氧化氮、臭氧等空气质量信息。
     *
     * @return 北京市的空气质量 air/now.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&scope=city
     * 北京市及下属监测站的空气质量 air/now.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&scope=all
     */
    @GET("air/now.json")
    Call<AirNow> getAirNow(@Query("key") String key, @Query("location") String location, @Query("language") String language, @Query("scope") String scope);

    /**
     * 空气质量实况城市排行（付费接口）
     * 获取全国城市空气质量AQI排行榜。
     *
     * @return air/ranking.json?key=52zpuzgswyulc0w6&language=zh-Hans
     */
    @GET("air/ranking.json")
    Call<AirRanking> getAirRanking(@Query("key") String key, @Query("language") String language);

    /**
     * 逐日空气质量预报（付费接口)
     * 获取指定城市未来最多7天的逐日AQI预报。
     *
     * @return air/daily.json?key=52zpuzgswyulc0w6&language=zh-Hans&location=Beijing
     */
    @GET("air/daily.json")
    Call<AirDaily> getAirDaily(@Query("key") String key, @Query("language") String language, @Query("location") String location);

    /**
     * 逐小时空气质量预报（付费接口）
     * 获取指定城市未来最多7天的逐小时AQI预报。
     *
     * @return air/hourly.json?key=52zpuzgswyulc0w6&language=zh-Hans&location=Beijing
     */
    @GET("air/hourly.json")
    Call<AirHourly> getAirHourly(@Query("key") String key, @Query("language") String language, @Query("location") String location);

    /**
     * 过去24小时历史空气质量（付费接口）
     * 获取指定城市过去24小时逐小时的AQI、PM2.5、PM10、一氧化碳、二氧化氮、臭氧等空气质量信息。
     *
     * @return 北京市过去24小时的逐小时空气质量 air/hourly_history.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&scope=city
     * 北京市及下属监测站过去24小时的逐小时空气质量 air/hourly_history.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&scope=all
     */
    @GET("air/hourly_history.json")
    Call<HourlyHistory> get(@Query("key") String key, @Query("language") String language, @Query("location") String location, @Query("scope") String scope);

    /**
     * 生活指数
     * 获取指定城市的基本、交通、生活、运动、健康5大类共27项生活指数，仅支持中国城市。付费用户可获取全部数据;
     * 免费用户只返回6项基本类生活指数，且只有brief，没有details。
     * 基本类：穿衣、紫外线强度、洗车、旅游、感冒、运动
     * 交通类：交通、路况
     * 生活类：晾晒、雨伞、空调开启、啤酒、逛街、夜生活、约会
     * 运动类：晨练、钓鱼、划船、放风筝
     * 健康类：过敏、美发、化妆、风寒、防晒、空气污染扩散条件、舒适度、心情
     *
     * @return life/suggestion.json?key=52zpuzgswyulc0w6&location=shanghai&language=zh-Hans
     */
    @GET("life/suggestion.json")
    Call<Suggestion> getLifeSuggestion(@Query("key") String key, @Query("location") String location, @Query("language") String language);

    /**
     * 农历、节气、生肖（付费接口）
     * 查询任何一个公历日期对应的农历日期、农历传统节假日、二十四节气、天干地支纪年纪月纪日、及生肖属相。
     *
     * @return 从今天开始7天的农历和节气等 life/chinese_calendar.json?key=52zpuzgswyulc0w6&start=0&days=7
     * 从指定日期开始7天的农历和节气等 life/chinese_calendar.json?key=52zpuzgswyulc0w6&start=2014/1/31&days=7
     */
    @GET("life/chinese_calendar.json")
    Call<ChineseCalendar> getLifeChineseCalendar(@Query("key") String key, @Query("start") String start, @Query("days") String days);

    /**
     * 机动车尾号限行（付费接口）
     * 查询北京、天津、哈尔滨、成都、杭州、贵阳、长春、兰州8个城市的今天、明天和后天的机动车尾号限行数据。
     *
     * @return 北京https://api.seniverse.com/v3/life/driving_restriction.json?key=52zpuzgswyulc0w6&location=WX4FBXXFKE4F
     * 天津https://api.seniverse.com/v3/life/driving_restriction.json?key=52zpuzgswyulc0w6&location=WWGQDCW6TBW1
     * 哈尔滨https://api.seniverse.com/v3/life/driving_restriction.json?key=52zpuzgswyulc0w6&location=YB1UX38K6DY1
     * 成都https://api.seniverse.com/v3/life/driving_restriction.json?key=52zpuzgswyulc0w6&location=WM6N2PM3WY2K
     * 杭州https://api.seniverse.com/v3/life/driving_restriction.json?key=52zpuzgswyulc0w6&location=WTMKQ069CCJ7
     * 贵阳https://api.seniverse.com/v3/life/driving_restriction.json?key=52zpuzgswyulc0w6&location=WKEZD7MXE04F
     * 长春https://api.seniverse.com/v3/life/driving_restriction.json?key=52zpuzgswyulc0w6&location=WZC1EXZ0P9HU
     * 兰州https://api.seniverse.com/v3/life/driving_restriction.json?key=52zpuzgswyulc0w6&location=WZC1EXZ0P9HU
     */
    @GET("life/driving_restriction.json")
    Call<DrivingRestriction> getLifeDrivingRestriction(@Query("key") String key, @Query("location") String location);

    /**
     * 逐小时潮汐（付费接口）
     * 获取指定港口或者某个城市下的全部港口未来最多18天的潮汐数据，包括每天24小时的逐小时潮汐高度，以及每天的高低潮时间及高度。
     *
     * @return https://api.seniverse.com/v3/tide/daily.json?key=52zpuzgswyulc0w6&location=dandong
     */
    @GET("tide/daily.json")
    Call<TideDaily> getTideDaily(@Query("key") String key, @Query("location") String location);

    /**
     * 日出日落（付费接口）
     * 查询全球各地最多15天的日出日落时间。
     *
     * @return 北京从今天开始7天的日出日落时间 geo/sun.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&start=0&days=7
     * 北京从指定日期开始7天的日出日落时间 geo/sun.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&start=2016/10/1&days=7
     */
    @GET("geo/sun.json")
    Call<Sun> getSun(@Query("key") String key, @Query("location") String location, @Query("language") String language, @Query("start") String start, @Query("days") String days);

    /**
     * 月出月落和月相（付费接口）
     * 查询全球各地最多15天的月出月落时间和月相。
     *
     * @return 北京从今天开始7天的月出月落时间和月相 geo/moon.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&start=0&days=7
     * 北京从指定日期开始7天的月出月落时间和月相 geo/moon.json?key=52zpuzgswyulc0w6&location=beijing&language=zh-Hans&start=2015/9/20&days=7
     */
    @GET("geo/moon.json")
    Call<Moon> getMoon(@Query("key") String key, @Query("location") String location, @Query("language") String language, @Query("start") String start, @Query("days") String days);

    /**
     * 城市搜索
     * 根据城市ID、中文、英文、拼音、IP、经纬度搜索匹配的城市。
     *
     * @return 用城市ID搜索https://api.seniverse.com/v3/location/search.json?key=52zpuzgswyulc0w6&q=WX4FBXXFKE4F
     * 用城市中文搜索https://api.seniverse.com/v3/location/search.json?key=52zpuzgswyulc0w6&q=北京
     * 用城市英文搜索https://api.seniverse.com/v3/location/search.json?key=52zpuzgswyulc0w6&q=beijing
     * 用城市拼音缩写搜索https://api.seniverse.com/v3/location/search.json?key=52zpuzgswyulc0w6&q=bj
     * 用IP地址搜索https://api.seniverse.com/v3/location/search.json?key=52zpuzgswyulc0w6&q=220.181.111.86
     * 用经纬度搜索https://api.seniverse.com/v3/location/search.json?key=52zpuzgswyulc0w6&q=39.93:116.40
     * 用省市名称限定搜索https://api.seniverse.com/v3/location/search.json?key=52zpuzgswyulc0w6&q=辽宁朝阳
     * 搜索所有中英文名称中包含“san”的城市，返回第2页的10个结果https://api.seniverse.com/v3/location/search.json?key=52zpuzgswyulc0w6&q=san&limit=10&offset=10
     */
    @GET("/location/search.json")
    Call<Location> getSearch(@Query("key") String key, @Query("q") String q);

}