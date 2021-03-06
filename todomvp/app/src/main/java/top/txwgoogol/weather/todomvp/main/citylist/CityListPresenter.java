package top.txwgoogol.weather.todomvp.main.citylist;


import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import top.txwgoogol.weather.todomvp.data.bean.city.City;
import top.txwgoogol.weather.todomvp.data.bean.search.Search;
import top.txwgoogol.weather.todomvp.data.bean.weather.Now;
import top.txwgoogol.weather.todomvp.data.source.remote.ApiClient;
import top.txwgoogol.weather.todomvp.data.source.remote.ApiStores;
import top.txwgoogol.weather.todomvp.util.RxScheduler;

/**
 * 逻辑处理类
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class CityListPresenter implements CityListContact.Presenter {

    //视图 view
    private CityListContact.View mCityView;
    //订阅管理器
    private CompositeDisposable compositeDisposable;
    //订阅
    private Disposable disposable;

    private ApiStores apiStores = ApiClient.getInstance().create(ApiStores.class);

    CityListPresenter(CityListContact.View view) {
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
    public void searchWeather(String id) {
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
    }

    @Override
    public void onDetach() {
        compositeDisposable.clear();
    }

}