package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.example.android.architecture.blueprints.todoapp.data.weather.WeatherResponse;
import com.example.android.architecture.blueprints.todoapp.main.citylist.CityListActivity;
import com.example.android.architecture.blueprints.todoapp.util.RxScheduler;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * view和model的纽带
 * Created by txw on 2018/4/3.
 */
public class WeatherPresenter implements WeatherContact.Presenter {

    private static final String TAG = "WeatherPresenter";

    private WeatherContact.View mWeatherView;
    private Disposable disposable;
    //判断是否首次加载数据
    private boolean isFirst = true;
    //经纬度 231.29:120.58 (纬度:经度)Latitude:Longitude 哥所在的位置
    //private String mLL = "31.29:120.58";

    /**
     * Rx2.x 和 rx1.x 改变
     * https://www.jianshu.com/p/2badfbb3a33b
     * https://blog.csdn.net/u011200604/article/details/72934661
     * https://blog.csdn.net/qq_35064774/article/details/53045298
     */
    private CompositeDisposable compositeDisposable;

    public WeatherPresenter(WeatherContact.View weatherView) {
        this.mWeatherView = weatherView;
        mWeatherView.setPresenter(this);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void result(int requestCode, int resultCode, Intent data) {
        if (CityListActivity.REQUEST_CITY_LIST == requestCode && Activity.RESULT_OK == resultCode) {
            //执行查询操作
            mWeatherView.onWeather(data.getStringExtra("id"));
            HomePageFragment.mIdOrLL = data.getStringExtra("id");
        } else {
            mWeatherView.onWeather(HomePageFragment.mIdOrLL);
        }
    }

    @Override
    public void onAttach() {
        if (isFirst) {
            //使用定位获取的经纬度信息
            mWeatherView.onWeather(HomePageFragment.mIdOrLL);
            isFirst = false;
        }
    }

    @Override
    public void weather(String q) {

        mWeatherView.loadProgress();
        disposable = WeatherResponse.getWeather(q)
                .compose(RxScheduler.normalSchedulersTransformer())
                .subscribe(
                        weather -> {
                            mWeatherView.onSuccess(weather);
                            mWeatherView.hideProgress();
                        },
                        throwable -> {
                            mWeatherView.onFailure();
                        }
                );
        compositeDisposable.add(disposable);

    }

    @Override
    public void onDetach() {
        compositeDisposable.clear();
    }

}