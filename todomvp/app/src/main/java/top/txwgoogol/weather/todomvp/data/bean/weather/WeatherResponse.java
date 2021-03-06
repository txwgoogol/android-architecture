package top.txwgoogol.weather.todomvp.data.bean.weather;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import top.txwgoogol.weather.todomvp.data.bean.city.Address;
import top.txwgoogol.weather.todomvp.data.bean.life.Suggestion;
import top.txwgoogol.weather.todomvp.data.source.remote.ApiClient;
import top.txwgoogol.weather.todomvp.data.source.remote.ApiStores;
import top.txwgoogol.weather.todomvp.main.weather.WeatherAdapterImpl;

/**
 * 响应数据
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class WeatherResponse {

    /**
     * 查询的地址写死的
     *
     * @return 组合得到的新数据类

    public static Observable<Weather> getWeather() {
    ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

    Map nowMap = new HashMap();
    nowMap.put("location", "suzhou");
    nowMap.put("language", "zh-Hans");
    nowMap.put("unit", "c");
    Observable<Now> nowObservable = apiStores.getNow(nowMap);

    Map dailyMap = new HashMap();
    dailyMap.put("location", "suzhou");
    dailyMap.put("language", "zh-Hans");
    dailyMap.put("unit", "c");
    dailyMap.put("start", "0");
    dailyMap.put("days", "5");
    Observable<Daily> dailyObservable = apiStores.getDaily(dailyMap);

    Map suggestionMap = new HashMap();
    suggestionMap.put("location", "suzhou");
    suggestionMap.put("language", "zh-Hans");
    Observable<Suggestion> suggestionObservable = apiStores.getLifeSuggestion(suggestionMap);

    return Observable.combineLatest(nowObservable, dailyObservable, suggestionObservable, (now, daily, suggestion) -> new WeatherAdapterImpl(now, daily, suggestion).getWeather());
    }*/

    /**
     * 根据地址的ID查询天气
     *
     * @param key 地址ID
     * @return 组合得到的新数据类
     */
    public static Observable<Weather> getWeather(String key) {
        ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

        Map nowMap = new HashMap();
        nowMap.put("location", key);
        nowMap.put("language", "zh-Hans");
        nowMap.put("unit", "c");
        Observable<Now> nowObservable = apiStores.getNow(nowMap);

        Map dailyMap = new HashMap();
        dailyMap.put("location", key);
        dailyMap.put("language", "zh-Hans");
        dailyMap.put("unit", "c");
        dailyMap.put("start", "0");
        dailyMap.put("days", "5");
        Observable<Daily> dailyObservable = apiStores.getDaily(dailyMap);

        Map suggestionMap = new HashMap();
        suggestionMap.put("location", key);
        suggestionMap.put("language", "zh-Hans");
        Observable<Suggestion> suggestionObservable = apiStores.getLifeSuggestion(suggestionMap);

        return Observable.combineLatest(nowObservable, dailyObservable, suggestionObservable, (now, daily, suggestion) -> new WeatherAdapterImpl(now, daily, suggestion).getWeather());
    }

    /**
     * 根据经纬度获取地理位置信息
     *
     * @param lal 经纬度
     * @return 地理位置信息
     */
    public static Observable<Address> getLatitudeAndLongitude(String lal) {

        //将 ":" 替换成 "," 满足条件
        lal = lal.replace(":", ",");

        Map map = new HashMap();
        map.put("l", lal); //格式: 39.90,116.40
        map.put("type", "010");
        Observable<Address> addressObservable = ApiClient.getInstance().create(ApiStores.class).getAddress(map);
        return addressObservable;
    }

}