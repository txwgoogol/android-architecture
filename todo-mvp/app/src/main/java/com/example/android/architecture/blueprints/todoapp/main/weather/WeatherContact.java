package com.example.android.architecture.blueprints.todoapp.main.weather;

import com.example.android.architecture.blueprints.todoapp.base.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.base.BaseView;
import com.example.android.architecture.blueprints.todoapp.data.Results;
import com.example.android.architecture.blueprints.todoapp.data.Weather;
import com.example.android.architecture.blueprints.todoapp.data.location.Location;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;

import java.util.List;

public interface WeatherContact {

    interface View extends BaseView<Presenter>{
        void loadProgress();
        void hideProgress();
        void onSuccess(Weather weather);
        void onFailure();
    }

    interface Presenter extends BasePresenter{

    }

}