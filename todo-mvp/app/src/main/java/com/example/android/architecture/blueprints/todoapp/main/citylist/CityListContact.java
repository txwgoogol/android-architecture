package com.example.android.architecture.blueprints.todoapp.main.citylist;

import com.example.android.architecture.blueprints.todoapp.base.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.base.BaseView;
import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.data.location.Search;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;

import java.util.List;

public class CityListContact {

    interface View extends BaseView<CityListContact.Presenter> {

        //显示加载进度
        void loadProgress();

        //隐藏加载进度
        void hideProgress();

        //获取数据成功
        void onSuccess(Now now);

        //获取数据失败
        void onFailure();

        /**
         * 返回城市搜索结果
         * @param resultsBeanList 结果列表
         */
        void onSearchResult(List<Search.ResultsBean> resultsBeanList);

        /**
         * 返回获取的天气信息
         * @param city 天气信息实体类
         */
        void onWeatherResult(City city);
    }

    interface Presenter extends BasePresenter {

        //根据输入的城市ID、城市名称、城市名称拼音、英文名称等进行搜索城市
        void setSearchKey(String key);

        //根据城市ID进行该城市的天气情况搜索
        void setSearchWeather(String id);

    }
}
