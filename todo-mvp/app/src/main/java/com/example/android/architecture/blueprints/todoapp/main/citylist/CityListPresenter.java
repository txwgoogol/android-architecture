package com.example.android.architecture.blueprints.todoapp.main.citylist;

import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.data.search.Search;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiStores;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.util.RxScheduler;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class CityListPresenter implements CityListContact.Presenter {

    private static final String TAG = "CityPresenter";

    private CityListContact.View mCityView;
    private CompositeDisposable compositeDisposable;
    private Disposable disposable;
    ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

    public CityListPresenter(CityListContact.View view) {
        this.mCityView = view;
        mCityView.setPresenter(this);
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onAttach() {

//        Map nowMap = new HashMap();
//        nowMap.put("key", "52zpuzgswyulc0w6");
//        nowMap.put("ic_location", "suzhou");
//        nowMap.put("language", "zh-Hans");
//        nowMap.put("unit", "c");
//        Disposable disposable = apiStores.getNow(nowMap)
//                .compose(RxScheduler.normalSchedulersTransformer())
//                .subscribe(new Consumer<Now>() {
//                    @Override
//                    public void accept(Now now) throws Exception {
//                        Logger.d(TAG, "accept: " + now.getResults().get(0).getNow().getText());
//                    }
//                });

//        Map locationMap = new HashMap();
//        locationMap.put("key", "52zpuzgswyulc0w6");
//        locationMap.put("q", "suzhou");
//        Disposable disposable = apiStores.getSearch(locationMap)
//                .compose(RxScheduler.normalSchedulersTransformer())
//                .subscribe(new Consumer<Search>() {
//                    @Override
//                    public void accept(Search ic_location) throws Exception {
//
//                        for (Search.ResultsBean resultsBean : ic_location.getResults())
//                            Logger.d(TAG, "accept: " + resultsBean.getName());
//
//                        //mCityView.onSuccess(ic_location.getResults());
//                        mCityView.hideProgress();
//                    }
//                }, throwable -> mCityView.onFailure());
//
//        compositeDisposable.add(disposable); //订阅

    }

    @Override
    public void setSearchKey(String key) {
        //mCityView.loadProgress();
        Map locationMap = new HashMap();
        //locationMap.put("key", "52zpuzgswyulc0w6");
        locationMap.put("q", key);
        disposable = apiStores.getSearch(locationMap)
                .compose(RxScheduler.normalSchedulersTransformer())
                .subscribe(new Consumer<Search>() {
                    @Override
                    public void accept(Search location) throws Exception {
                        for (Search.ResultsBean resultsBean : location.getResults()) {
                            Logger.d(TAG, "location name = " + resultsBean.getName());
                            Logger.d(TAG, "location id = " + resultsBean.getId());
                        }
                        mCityView.onSearchResult(location.getResults());
                        //mCityView.hideProgress();
                    }
                }, throwable -> mCityView.onFailure());
        compositeDisposable.add(disposable); //订阅
    }

    @Override
    public void setSearchWeather(String id) {
        Logger.d(TAG, "setSearchWeather: " + id);

        Map nowMap = new HashMap();
        //nowMap.put("key","52zpuzgswyulc0w6");
        nowMap.put("location", id);
        nowMap.put("language", "zh-Hans");
        nowMap.put("unit", "c");
        disposable = apiStores.getNow(nowMap)
                .compose(RxScheduler.normalSchedulersTransformer()).subscribe(new Consumer<Now>() {
                    @Override
                    public void accept(Now now) throws Exception {
                        Logger.d(TAG, "now=location=====" + now.getResults().get(0).getLocation().getName());
                        Logger.d(TAG, "now=temperature=====" + now.getResults().get(0).getNow().getTemperature());

                        Now.ResultsBean.NowBean nowBean = now.getResults().get(0).getNow();
                        Now.ResultsBean.LocationBean locationBean = now.getResults().get(0).getLocation();

                        City city = new City();
                        city.setId(locationBean.getId());
                        city.setTime(String.valueOf(System.currentTimeMillis()));
                        city.setName(locationBean.getName());
                        city.setTemperature(nowBean.getTemperature());
                        city.setCode(nowBean.getCode());

                        mCityView.onWeatherResult(city);
                    }
                });
        compositeDisposable.add(disposable); //订阅

    }

    @Override
    public void removeCityById(String cityId) {
        mCityView.removeCityById(cityId);
    }

    @Override
    public void onDetach() {
        compositeDisposable.clear();
    }

}