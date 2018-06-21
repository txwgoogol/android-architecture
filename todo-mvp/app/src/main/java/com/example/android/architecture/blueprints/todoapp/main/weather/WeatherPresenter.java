package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.util.Log;

import com.example.android.architecture.blueprints.todoapp.data.WeatherResponse;
import com.example.android.architecture.blueprints.todoapp.util.RxSchedulerUtils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * view和model的纽带
 * Created by txw on 2018/4/3.
 */
public class WeatherPresenter implements WeatherContact.Presenter {

    private static final String TAG = "WeatherPresenter";

    private WeatherContact.View mWeatherView;

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
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void start() {
        mWeatherView.loadProgress();
        Disposable disposable = WeatherResponse.getWeather()
                .compose(RxSchedulerUtils.normalSchedulersTransformer())
                .subscribe(
                        weather -> {
                            mWeatherView.onSuccess(weather);
                            mWeatherView.hideProgress();
                        },
                        throwable -> {
                            Log.d(TAG, "weather_presenter: " + throwable.getMessage());
                            mWeatherView.onFailure();
                        }
                );
        compositeDisposable.add(disposable);
    }

    @Override
    public void end() {
        compositeDisposable.clear();
    }

}