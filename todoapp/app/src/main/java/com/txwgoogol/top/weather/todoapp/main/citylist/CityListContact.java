package com.txwgoogol.top.weather.todoapp.main.citylist;

import com.txwgoogol.top.weather.todoapp.base.BasePresenter;
import com.txwgoogol.top.weather.todoapp.base.BaseView;
import com.txwgoogol.top.weather.todoapp.data.bean.city.City;
import com.txwgoogol.top.weather.todoapp.data.bean.search.Search;

import java.util.List;

public class CityListContact {

    interface View extends BaseView<CityListContact.Presenter> {

        /**
         * 城市列表 适配器
         *
         * @param cityList 城市数据列表
         */
        void initCityListAdapter(List<City> cityList);

        /**
         * 城市搜索结果 适配器
         *
         * @param searchResultList 搜索结果列表
         */
        void initSearchResultAdapter(List<Search.ResultsBean> searchResultList);

        /**
         * 返回获取的天气信息
         *
         * @param city 天气信息实体类
         */
        void addToCityList(City city);

        //Fragment已经添加到Activity中
        boolean isActive();

        //判断数据库有没有数据
        boolean isDataMissing();

    }

    interface Presenter extends BasePresenter {

        /**
         * 根据输入的城市ID、城市名称、城市名称拼音、英文名称等进行搜索城市
         *
         * @param key 城市ID、城市名称、城市名称拼音、英文名称等
         */
        void searchCity(String key);

        /**
         * 根据城市ID进行该城市的天气情况搜索
         *
         * @param cityId 城市ID
         * @return 返回城市对象
         */
        City searchWeather(String cityId);

    }

}