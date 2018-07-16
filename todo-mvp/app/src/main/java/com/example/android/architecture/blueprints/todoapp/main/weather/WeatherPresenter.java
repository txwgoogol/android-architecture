package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.app.Activity;
import android.content.Intent;

import com.example.android.architecture.blueprints.todoapp.data.weather.WeatherResponse;
import com.example.android.architecture.blueprints.todoapp.main.citylist.CityListActivity;
import com.example.android.architecture.blueprints.todoapp.util.RxScheduler;
import com.orhanobut.logger.Logger;

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
    private String mLLS = "31.29,120.58"; // 苏州
    private String mLLB = "39.90,116.40"; // 北京
    private String mLAL = "";

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
            mLAL = data.getStringExtra("id");
            onAttach();
        }
    }

    @Override
    public void onAttach() {
        if (isFirst) {

            //根据经纬度获取地理位置 然后在根据位置获取城市ID 然后在获取数据库数据 ... 放弃 :)
            /*
            Map map = new HashMap();
            map.put("l", mLLB);
            map.put("type", "010");
            ApiClient.getInstance().create(ApiStores.class).getAddress(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Address>() {
                        @Override
                        public void accept(Address address) throws Exception {
                            String addr = address.getAddrList().get(0).getAdmName();
                            String[] addrs = addr.split(",");
                            for (int i = 0; i < addrs.length; i++) {
                                Logger.d(addrs[1]);
                                //locationName = mWeatherView.searchFromSQLite(addrs[1]);
                            }
                        }
                    });
            */
            //首先判断数据库中有没有该地理位置的数据 如果有就直接获取 如果没有就从网络获取

            //WeatherDB weatherDB = mWeatherView.searchFromSQLiteById(mWeatherView.searchFromSQLite(locationName));

            //如果没有网络或距离上次打开进入的时间不超过1分钟 直接从数据库中查询数据 节省网络流量
            //if (weatherDB != null) {
            //    mWeatherView.searchFromSQLiteById(weatherDB);
            //} else {
            //使用定位获取的经纬度信息
            weather(mWeatherView.getLatitudeAndLongitude());
            mLAL = mWeatherView.getLatitudeAndLongitude();
            isFirst = false;
            //}
        } else {
            weather(mLAL);
        }
    }

    @Override
    public void weather(String q) {

        //mWeatherView.loadProgress();
        disposable = WeatherResponse.getWeather(q)
                .compose(RxScheduler.normalSchedulersTransformer())
                .subscribe(
                        weather -> {
                            mWeatherView.onSuccess(weather);
                            //mWeatherView.hideProgress();
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