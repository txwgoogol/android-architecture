package com.example.android.architecture.blueprints.todoapp.main.citylist;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.util.TimeConvert;
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