package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.util.Log;

import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;

import java.util.ArrayList;
import java.util.List;

/**
 * 将获取的天气信息进行组合
 */
public class CloudWeatherAdapter extends WeatherAdapter {

    private static final String TAG = "CloudWeatherAdapter";

    private Now.ResultsBean.LocationBean mLocation;
    private Now.ResultsBean.NowBean mNow;
    private List<Daily.ResultsBean.DailyBean> mDailyBeanList;
    private Suggestion.ResultsBean.SuggestionBean mSuggestion;
    private String last_update;

    public CloudWeatherAdapter(Now now, Daily daily, Suggestion suggestion) {
        this.mLocation = now.getResults().get(0).getLocation();
        this.mNow = now.getResults().get(0).getNow();
        this.mDailyBeanList = daily.getResults().get(0).getDaily();
        this.mSuggestion = suggestion.getResults().get(0).getSuggestion();
        this.last_update = now.getResults().get(0).getLast_update();
    }

    @Override
    public Now.ResultsBean.LocationBean getLocation() {
        Log.d(TAG, "getLocation: ");
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
        Log.d(TAG, "getNow: " + mNow.getText() + "    " + mNow.getCode() + "    " + mNow.getTemperature());
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
        Log.d(TAG, "getDaily: ");
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
    public Suggestion.ResultsBean.SuggestionBean getLifeSuggestion() {
        Log.d(TAG, "getLifeSuggestion: ");
        Suggestion.ResultsBean.SuggestionBean suggestionBean = new Suggestion.ResultsBean.SuggestionBean();

        Suggestion.ResultsBean.SuggestionBean.CarWashingBean carWashingBean = new Suggestion.ResultsBean.SuggestionBean.CarWashingBean();
        carWashingBean.setBrief(mSuggestion.getCar_washing().getBrief());
        carWashingBean.setDetails(mSuggestion.getCar_washing().getDetails());
        suggestionBean.setCar_washing(carWashingBean); //空调开启

        Suggestion.ResultsBean.SuggestionBean.DressingBean dressingBean = new Suggestion.ResultsBean.SuggestionBean.DressingBean();
        dressingBean.setBrief(mSuggestion.getDressing().getBrief());
        dressingBean.setDetails(mSuggestion.getDressing().getDetails());
        suggestionBean.setDressing(dressingBean); //穿衣

        Suggestion.ResultsBean.SuggestionBean.FluBean fluBean = new Suggestion.ResultsBean.SuggestionBean.FluBean();
        fluBean.setBrief(mSuggestion.getFlu().getBrief());
        fluBean.setDetails(mSuggestion.getFlu().getDetails());
        suggestionBean.setFlu(fluBean); //感冒

        Suggestion.ResultsBean.SuggestionBean.SportBean sportBean = new Suggestion.ResultsBean.SuggestionBean.SportBean();
        sportBean.setBrief(mSuggestion.getSport().getBrief());
        sportBean.setDetails(mSuggestion.getSport().getDetails());
        suggestionBean.setSport(sportBean); //晨练

        Suggestion.ResultsBean.SuggestionBean.TravelBean travelBean = new Suggestion.ResultsBean.SuggestionBean.TravelBean();
        travelBean.setBrief(mSuggestion.getTravel().getBrief());
        travelBean.setDetails(mSuggestion.getTravel().getDetails());
        suggestionBean.setTravel(travelBean); //旅游

        Suggestion.ResultsBean.SuggestionBean.UvBean uvBean = new Suggestion.ResultsBean.SuggestionBean.UvBean();
        uvBean.setBrief(mSuggestion.getUv().getBrief());
        uvBean.setDetails(mSuggestion.getUv().getDetails());
        suggestionBean.setUv(uvBean); //紫外线

        return suggestionBean;
    }

    @Override
    public String getLastUpdate() {
        Log.d(TAG, "getLastUpdate: " + last_update);
        return last_update;
    }

}