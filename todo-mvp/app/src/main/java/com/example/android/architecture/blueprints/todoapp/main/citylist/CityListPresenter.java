package com.example.android.architecture.blueprints.todoapp.main.citylist;

import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.data.search.Search;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiClient;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.ApiStores;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.util.RxScheduler;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class CityListPresenter implements CityListContact.Presenter {

    //视图 view
    private CityListContact.View mCityView;
    //订阅管理器
    private CompositeDisposable compositeDisposable;
    //订阅
    private Disposable disposable;

    ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

    public CityListPresenter(CityListContact.View view) {
        this.mCityView = view;
        mCityView.setPresenter(this);
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onAttach() {
        if (mCityView.isActive()) {
            //如果数据库存在数据
            mCityView.isDataMissing();
        }
    }

    @Override
    public void searchCity(String key) {
        Map locationMap = new HashMap();
        locationMap.put("q", key);
        disposable = apiStores.getSearch(locationMap)
                .compose(RxScheduler.normalSchedulersTransformer())
                .subscribe(new Consumer<Search>() {
                    @Override
                    public void accept(Search location) throws Exception {
                        mCityView.initSearchResultAdapter(location.getResults());
                    }
                }, throwable -> {
                    //mCityView.onFailure();
                });
        compositeDisposable.add(disposable); //订阅
    }

    @Override
    public City searchWeather(String id) {
        City city = new City();
        Map nowMap = new HashMap();
        nowMap.put("location", id);
        nowMap.put("language", "zh-Hans");
        nowMap.put("unit", "c");
        disposable = apiStores.getNow(nowMap)
                .compose(RxScheduler.normalSchedulersTransformer()).subscribe(new Consumer<Now>() {
                    @Override
                    public void accept(Now now) throws Exception {

                        Now.ResultsBean.NowBean nowBean = now.getResults().get(0).getNow();
                        Now.ResultsBean.LocationBean locationBean = now.getResults().get(0).getLocation();

                        city.setId(locationBean.getId());
                        city.setTime(String.valueOf(System.currentTimeMillis()));
                        city.setName(locationBean.getName());
                        city.setTemperature(nowBean.getTemperature());
                        city.setCode(nowBean.getCode());

                        mCityView.addToCityList(city);
                    }
                });
        compositeDisposable.add(disposable);
        return city;
    }

    @Override
    public void onDetach() {
        compositeDisposable.clear();
    }

}