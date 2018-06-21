package com.example.android.architecture.blueprints.todoapp.data;

import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;

import java.util.List;

public class Weather {

    private Now.ResultsBean.LocationBean location;
    private Now.ResultsBean.NowBean now;
    private List<Daily.ResultsBean.DailyBean> daily;
    private Suggestion.ResultsBean.SuggestionBean suggestion;
    private String last_update;

    public Now.ResultsBean.LocationBean getLocation() {
        return location;
    }

    public void setLocation(Now.ResultsBean.LocationBean location) {
        this.location = location;
    }

    public Now.ResultsBean.NowBean getNow() {
        return now;
    }

    public void setNow(Now.ResultsBean.NowBean now) {
        this.now = now;
    }

    public List<Daily.ResultsBean.DailyBean> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily.ResultsBean.DailyBean> daily) {
        this.daily = daily;
    }

    public Suggestion.ResultsBean.SuggestionBean getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion.ResultsBean.SuggestionBean suggestion) {
        this.suggestion = suggestion;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}