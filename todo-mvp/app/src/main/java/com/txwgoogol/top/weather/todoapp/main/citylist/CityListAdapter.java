package com.txwgoogol.top.weather.todoapp.main.citylist;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.txwgoogol.top.weather.todoapp.R;
import com.txwgoogol.top.weather.todoapp.data.bean.city.City;
import com.txwgoogol.top.weather.todoapp.util.TimeConvert;
import com.orhanobut.logger.Logger;

import java.util.List;

public class CityListAdapter extends BaseQuickAdapter<City,BaseViewHolder> {

    public CityListAdapter(int layoutResId, @Nullable List<City> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, City item) {
        Logger.d(item.getName());
        helper.setText(R.id.city_name,item.getName());
        helper.setText(R.id.city_time, TimeConvert.stampToTime(String.valueOf(System.currentTimeMillis())));
        helper.setText(R.id.city_template,item.getTemperature()+ "°");
    }

}