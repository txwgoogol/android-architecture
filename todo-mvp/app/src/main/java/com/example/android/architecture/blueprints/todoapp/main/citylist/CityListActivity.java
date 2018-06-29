package com.example.android.architecture.blueprints.todoapp.main.citylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.util.ActivityUtils;

public class CityListActivity extends AppCompatActivity{

    public static final int REQUEST_CITY_LIST = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        CityListFragment cityListFragment = (CityListFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if (cityListFragment == null){
            cityListFragment = CityListFragment.newInstance("cityList");
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),cityListFragment,R.id.frame_layout);
        }

    }

}