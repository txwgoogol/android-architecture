package com.example.android.architecture.blueprints.todoapp.main.citylist;

import com.example.android.architecture.blueprints.todoapp.base.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.base.BaseView;
import com.example.android.architecture.blueprints.todoapp.data.location.Search;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;

import java.util.List;

public class CityListContact {

    interface View extends BaseView<CityListContact.Presenter> {

        void loadProgress();

        void hideProgress();

        void onSuccess(Now now);

        void onFailure();

        void setResult(List<Search.ResultsBean> resultsBeanList);
    }

    interface Presenter extends BasePresenter {

        //输入搜索
        void setSearchKey(String key);
    }
}
