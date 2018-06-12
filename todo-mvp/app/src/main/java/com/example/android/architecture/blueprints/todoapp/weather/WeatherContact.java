package com.example.android.architecture.blueprints.todoapp.weather;

import com.example.android.architecture.blueprints.todoapp.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.BaseView;
import com.example.android.architecture.blueprints.todoapp.data.Now;

public interface WeatherContact {

    interface View extends BaseView<Presenter>{
        void loadProgress();
        void hideProgress();
        void onSuccess(Now weather);
        void onFailure();
    }

    interface Presenter extends BasePresenter{

    }

}
