package top.txwgoogol.weather.todomvp.data.source.remote;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import top.txwgoogol.weather.todomvp.data.bean.city.Address;
import top.txwgoogol.weather.todomvp.data.bean.life.Suggestion;
import top.txwgoogol.weather.todomvp.data.bean.search.Search;
import top.txwgoogol.weather.todomvp.data.bean.weather.Daily;
import top.txwgoogol.weather.todomvp.data.bean.weather.Now;

/**
 * 接口
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public interface ApiStores {

    /**
     * 天气实况
     * 获取指定城市的天气实况。付费用户可获取全部数据，免费用户只返回天气现象文字、代码和气温3项数据。注：中国城市暂不支持云量和露点温度。
     *
     * @return weather/now.json?key=52zpuzgswyulc0w6&ic_location=beijing&language=zh-Hans&unit=c
     */
    @GET("weather/now.json")
    Observable<Now> getNow(@QueryMap Map<String, Object> map);

    /**
     * 逐日天气预报和昨日天气
     * 获取指定城市未来最多15天每天的白天和夜间预报，以及昨日的历史天气。付费用户可获取全部数据，免费用户只返回3天天气预报。
     *
     * @return weather/daily.json?key=52zpuzgswyulc0w6&ic_location=beijing&language=zh-Hans&unit=c&start=0&days=5
     */
    //@GET("weather/daily.json")
    //Observable<Daily> getDaily(@Query("key") String key, @Query("ic_location") String ic_location, @Query("language") String language, @Query("unit") String unit, @Query("start") String start, @Query("days") String days);
    @GET("weather/daily.json")
    Observable<Daily> getDaily(@QueryMap Map<String, Object> map);

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
     * @return life/suggestion.json?key=52zpuzgswyulc0w6&ic_location=shanghai&language=zh-Hans
     */
    @GET("life/suggestion.json")
    Observable<Suggestion> getLifeSuggestion(@QueryMap Map<String, Object> map);

    /**
     * 城市搜索
     * 根据城市ID、中文、英文、拼音、IP、经纬度搜索匹配的城市。
     *
     * @return 用城市ID搜索https://api.seniverse.com/v3/ic_location/search.json?key=52zpuzgswyulc0w6&q=WX4FBXXFKE4F
     * 用城市中文搜索https://api.seniverse.com/v3/ic_location/search.json?key=52zpuzgswyulc0w6&q=北京
     * 用城市英文搜索https://api.seniverse.com/v3/ic_location/search.json?key=52zpuzgswyulc0w6&q=beijing
     * 用城市拼音缩写搜索https://api.seniverse.com/v3/ic_location/search.json?key=52zpuzgswyulc0w6&q=bj
     * 用IP地址搜索https://api.seniverse.com/v3/ic_location/search.json?key=52zpuzgswyulc0w6&q=220.181.111.86
     * 用经纬度搜索https://api.seniverse.com/v3/ic_location/search.json?key=52zpuzgswyulc0w6&q=39.93:116.40
     * 用省市名称限定搜索https://api.seniverse.com/v3/ic_location/search.json?key=52zpuzgswyulc0w6&q=辽宁朝阳
     * 搜索所有中英文名称中包含“san”的城市，返回第2页的10个结果https://api.seniverse.com/v3/ic_location/search.json?key=52zpuzgswyulc0w6&q=san&limit=10&offset=10
     */
    //@GET("ic_location/search.json")
    //Observable<Location> getSearch(@Query("key") String key, @Query("q") String q);
    @GET("location/search.json")
    Observable<Search> getSearch(@QueryMap Map<String, Object> map);

    /**
     * 根据经纬度获取地理位置
     * <p>
     * 例如 http://gc.ditu.aliyun.com/regeocoding?l=31.29,120.58&type=010
     *
     * @param map map.put("l","32.29,120.58") map.put("type","010")
     * @return Address对象
     */
    @GET("http://gc.ditu.aliyun.com/regeocoding")
    Observable<Address> getAddress(@QueryMap Map<String, Object> map);

}