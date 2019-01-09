package top.txwgoogol.weather.todoapp.main.weather;

import android.app.Activity;
import android.content.Intent;

import com.orhanobut.logger.Logger;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import top.txwgoogol.weather.todoapp.data.bean.city.Address;
import top.txwgoogol.weather.todoapp.data.bean.weather.WeatherResponse;
import top.txwgoogol.weather.todoapp.main.citylist.CityListActivity;
import top.txwgoogol.weather.todoapp.util.RxScheduler;

/**
 * view和model的纽带 逻辑处理
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class WeatherPresenter implements WeatherContact.Presenter {

    private WeatherContact.View mWeatherView;
    /**
     * Rx2.x 和 rx1.x 改变
     * https://www.jianshu.com/p/2badfbb3a33b
     * https://blog.csdn.net/u011200604/article/details/72934661
     * https://blog.csdn.net/qq_35064774/article/details/53045298
     */
    private CompositeDisposable compositeDisposable;
    private Disposable disposable;
    private boolean isFirst = true; //是否为首次加载
    private boolean isCallBack = false; //是否为回调数据

    //经纬度 231.29:120.58 (纬度:经度)Latitude:Longitude
    //private String mLLS = "31.29,120.58"; // 苏州
    //private String mLLB = "39.90,116.40"; // 北京

    //根据城市名称得到的城市ID
    private String mLAL = "";

    //根据经纬度得到的城市名称
    private String locationName = "";

    public WeatherPresenter(WeatherContact.View weatherView) {
        this.mWeatherView = weatherView;
        mWeatherView.setPresenter(this);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void result(int requestCode, int resultCode, Intent data) {
        isFirst = true;
        if (CityListActivity.REQUEST_CITY_LIST == requestCode && Activity.RESULT_OK == resultCode) {
            isCallBack = true;
            mLAL = data.getStringExtra("id");
            onAttach();
        }
    }

    @Override
    public void forceUpdate(boolean refresh) {
        isFirst = refresh;
        onAttach();
    }

    @Override
    public void onAttach() {
        if (mWeatherView.isActive() && isFirst) {
            if (!mWeatherView.getNetWorkAvailable()) { //数据库获取数据
                //显示网络不可用 或者从数据库/缓存中去读数据
                Logger.d("网络不可用");
            } else {//网络获取数据
                if (!isCallBack) {
                    mLAL = mWeatherView.getLocation();
                    Logger.d(mLAL);
                    //mLAL = mWeatherView.getLocationId();
                }
                searchWeather(mLAL);
            }
            isFirst = false;
        }
    }

    /**
     * 根据经纬度获取地址信息
     *
     * @param lal
     * @return
     */
    @Override
    public String getLatitudeAndLongitude(String lal) {

        disposable = WeatherResponse.getLatitudeAndLongitude(lal)
                .compose(RxScheduler.normalSchedulersTransformer())
                .subscribe(new Consumer<Address>() {
                    @Override
                    public void accept(Address address) throws Exception {
                        String addr = address.getAddrList().get(0).getAdmName();
                        String[] addrs = addr.split(",");
                        for (int i = 0; i < addrs.length; i++) {
                            Logger.d(addrs[1]);
                            locationName = addrs[1];
                        }
                    }
                });
        compositeDisposable.add(disposable);
        return locationName;

    }

    @Override
    public void searchWeather(String q) {

        Logger.d(q);

        disposable = WeatherResponse.getWeather(q)
                .compose(RxScheduler.normalSchedulersTransformer())
                .subscribe(
                        weather -> {
                            mWeatherView.showWeather(weather);
                            Logger.d(weather.getNow().getText());
                        },
                        throwable -> {
                        }
                );
        compositeDisposable.add(disposable);

    }

    @Override
    public void onDetach() {
        compositeDisposable.clear();
    }

}