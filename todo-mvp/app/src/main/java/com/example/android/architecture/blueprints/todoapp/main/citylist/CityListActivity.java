package com.example.android.architecture.blueprints.todoapp.main.citylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.util.ActivityUtils;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

}