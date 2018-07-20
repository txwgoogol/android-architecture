package com.example.android.architecture.blueprints.todoapp.main.weather;

import com.example.android.architecture.blueprints.todoapp.data.life.LifeIndex;
import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;

import java.util.ArrayList;
import java.util.List;

/**
 * 将获取的天气信息进行组合
 */
public class WeatherAdapterImpl extends WeatherAdapter {

    private Now.ResultsBean.LocationBean mLocation;
    private Now.ResultsBean.NowBean mNow;
    private List<Daily.ResultsBean.DailyBean> mDailyBeanList;
    private Suggestion.ResultsBean.SuggestionBean mSuggestion;
    private String last_update;

    public WeatherAdapterImpl(Now now, Daily daily, Suggestion suggestion) {
        this.mLocation = now.getResults().get(0).getLocation();
        this.mNow = now.getResults().get(0).getNow();
        this.mDailyBeanList = daily.getResults().get(0).getDaily();
        this.mSuggestion = suggestion.getResults().get(0).getSuggestion();
        this.last_update = now.getResults().get(0).getLast_update();
    }

    @Override
    public Now.ResultsBean.LocationBean getLocation() {
        Now.ResultsBean.LocationBean locationBean = new Now.ResultsBean.LocationBean();
        locationBean.setId(mLocation.getId());
        locationBean.setName(mLocation.getName());
        locationBean.setCountry(mLocation.getCountry());
        locationBean.setPath(mLocation.getPath());
        locationBean.setTimezone(mLocation.getTimezone());
        locationBean.setTimezone_offset(mLocation.getTimezone_offset());
        return locationBean;
    }

    /**
     * 获取实时天气信息
     *
     * @return
     */
    @Override
    public Now.ResultsBean.NowBean getNow() {
        Now.ResultsBean.NowBean nowBean = new Now.ResultsBean.NowBean();
        nowBean.setText(mNow.getText()); //天气现象文字
        nowBean.setCode(mNow.getCode()); //天气现象代码
        nowBean.setTemperature(mNow.getTemperature()); //温度，单位为c摄氏度或f华氏度
        return nowBean;
    }

    /**
     * 获取近期天气信息
     *
     * @return
     */
    @Override
    public List<Daily.ResultsBean.DailyBean> getDaily() {
        List<Daily.ResultsBean.DailyBean> dailyBeans = new ArrayList<>();
        for (Daily.ResultsBean.DailyBean daily : mDailyBeanList) {
            Daily.ResultsBean.DailyBean dailyBean = new Daily.ResultsBean.DailyBean();
            dailyBean.setDate(daily.getDate()); //日期
            dailyBean.setText_day(daily.getText_day()); //白天天气现象文字
            dailyBean.setCode_day(daily.getCode_day()); //白天天气现象代码
            dailyBean.setText_night(daily.getText_night()); //晚间天气现象文字
            dailyBean.setCode_night(daily.getCode_night()); //晚间天气现象代码
            dailyBean.setHigh(daily.getHigh()); //当天最高温度
            dailyBean.setLow(daily.getLow()); //当天最低温度
            dailyBean.setPrecip(daily.getPrecip()); //降水概率，范围0~100，单位百分比
            dailyBean.setWind_direction(daily.getWind_direction()); //风向文字
            dailyBean.setWind_direction_degree(daily.getWind_direction_degree()); //风向角度，范围0~360
            dailyBean.setWind_speed(daily.getWind_speed()); //风速，单位km/h（当unit=c时）、mph（当unit=f时）
            dailyBean.setWind_scale(daily.getWind_scale()); //风力等级
            dailyBeans.add(dailyBean);
        }
        return dailyBeans;
    }

    /**
     * 获取天气指数
     *
     * @return
     */
    @Override
    public List<LifeIndex> getLifeIndex() {

        List<LifeIndex> lifeIndexList = new ArrayList<>();

        LifeIndex lifeIndex1 = new LifeIndex();
        lifeIndex1.setId(1);
        lifeIndex1.setName("洗车");
        lifeIndex1.setIndex(mSuggestion.getCar_washing().getBrief());
        lifeIndex1.setDetails(mSuggestion.getCar_washing().getDetails());
        lifeIndexList.add(lifeIndex1);

        LifeIndex lifeIndex2 = new LifeIndex();
        lifeIndex2.setId(2);
        lifeIndex2.setName("穿衣");
        lifeIndex2.setIndex(mSuggestion.getDressing().getBrief());
        lifeIndex2.setDetails(mSuggestion.getDressing().getDetails());
        lifeIndexList.add(lifeIndex2);

        LifeIndex lifeIndex3 = new LifeIndex();
        lifeIndex3.setId(3);
        lifeIndex3.setName("感冒");
        lifeIndex3.setIndex(mSuggestion.getFlu().getBrief());
        lifeIndex3.setDetails(mSuggestion.getFlu().getDetails());
        lifeIndexList.add(lifeIndex3);

        LifeIndex lifeIndex4 = new LifeIndex();
        lifeIndex4.setId(4);
        lifeIndex4.setName("运动");
        lifeIndex4.setIndex(mSuggestion.getSport().getBrief());
        lifeIndex4.setDetails(mSuggestion.getSport().getDetails());
        lifeIndexList.add(lifeIndex4);

        LifeIndex lifeIndex5 = new LifeIndex();
        lifeIndex5.setId(5);
        lifeIndex5.setName("旅游");
        lifeIndex5.setIndex(mSuggestion.getTravel().getBrief());
        lifeIndex5.setDetails(mSuggestion.getTravel().getDetails());
        lifeIndexList.add(lifeIndex5);

        LifeIndex lifeIndex6 = new LifeIndex();
        lifeIndex6.setId(6);
        lifeIndex6.setName("紫外线");
        lifeIndex6.setIndex(mSuggestion.getUv().getBrief());
        lifeIndex6.setDetails(mSuggestion.getUv().getDetails());
        lifeIndexList.add(lifeIndex6);

        return lifeIndexList;
    }

    @Override
    public String getLastUpdate() {
        return last_update;
    }

}