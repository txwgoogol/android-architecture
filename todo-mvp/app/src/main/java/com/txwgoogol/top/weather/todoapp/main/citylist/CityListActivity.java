package com.txwgoogol.top.weather.todoapp.main.citylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.txwgoogol.top.weather.todoapp.R;
import com.txwgoogol.top.weather.todoapp.data.bean.city.City;
import com.txwgoogol.top.weather.todoapp.util.ActivityUtils;
import com.orhanobut.logger.Logger;
import com.umeng.analytics.MobclickAgent;

public class CityListActivity extends AppCompatActivity {

    public static final int REQUEST_CITY_LIST = 1;
    private City mCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        Logger.d(getIntent().getParcelableExtra("city").toString());

        CityListFragment cityListFragment = (CityListFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if (cityListFragment == null) {
            cityListFragment = CityListFragment.newInstance(getIntent().getParcelableExtra("city"));
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), cityListFragment, R.id.frame_layout);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}