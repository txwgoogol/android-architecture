package com.example.android.architecture.blueprints.todoapp.data;

import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;

public class Weather {

    private Now now;
    private Daily daily;
    private Suggestion suggestion;

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }
}