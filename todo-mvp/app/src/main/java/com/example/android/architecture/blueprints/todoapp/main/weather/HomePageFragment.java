package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseFragment;
import com.example.android.architecture.blueprints.todoapp.data.db.sqlite.DBHelper;
import com.example.android.architecture.blueprints.todoapp.data.db.sqlite.DBManger;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.LifeIndex;
import com.example.android.architecture.blueprints.todoapp.data.weather.Weather;
import com.example.android.architecture.blueprints.todoapp.main.citylist.CityListActivity;
import com.example.android.architecture.blueprints.todoapp.view.ProgressDialogEx;
import com.example.android.architecture.blueprints.widget.TitleView;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

public class HomePageFragment extends BaseFragment implements WeatherContact.View {

    private static final String TAG = "HomePageFragment";

    @BindView(R.id.forecast_title)
    TitleView forecastTitle;
    @BindView(R.id.forecast_recycler_view)
    RecyclerView forecastRecyclerView;
    @BindView(R.id.index_title)
    TitleView indexTitle;
    @BindView(R.id.life_index_recycler_view)
    RecyclerView lifeIndexRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView nestedScrollView;

    private List<Daily.ResultsBean.DailyBean> weatherForecasts;
    private List<LifeIndex> lifeIndexList;

    private ForecastAdapter forecastAdapter;
    private LifeIndexAdapter lifeIndexAdapter;

    //回调接口 用于更新首页的数据
    private InteractionListener interactionListener;

    private WeatherContact.Presenter mPresenter;
    private WeatherPresenter mWeatherPresenter;

    private SmartRefreshLayout smartRefreshLayout;
    private ImageView parallax;
    //回调得到的城市ID Or 出事定位得到的经纬度
    public static String mIdOrLL = "31.29:120.58";

    private DBHelper dbHelper;

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    public static HomePageFragment newInstance(String str) {
        HomePageFragment homePageFragment = new HomePageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("str", str);
        homePageFragment.setArguments(bundle);
        return homePageFragment;
    }

    @Override
    public void setPresenter(WeatherContact.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onAttach(Context context) {
        //解决回调异常 https://blog.csdn.net/ys743276112/article/details/51006136
        if (context instanceof InteractionListener) {
            interactionListener = (InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement InteractionListener");
        }
        super.onAttach(context);
    }

    //SDK API<23时，onAttach(Context)不执行，需要使用onAttach(Activity)。Fragment自身的Bug，v4的没有此问题
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (activity instanceof InteractionListener) {
                interactionListener = (InteractionListener) activity;
            } else {
                throw new RuntimeException(activity.toString() + " must implement ABC_Listener");
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeatherPresenter = new WeatherPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        unbinder = ButterKnife.bind(this, view);

        //覆写activity的菜单
        setHasOptionsMenu(true);

        dbHelper = DBManger.getInstance(getActivity()); //实例化

        //天气预报
        forecastRecyclerView.setNestedScrollingEnabled(false);
        forecastRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        weatherForecasts = new ArrayList<>();
        forecastAdapter = new ForecastAdapter(weatherForecasts);
        //forecastAdapter.setOnItemClickListener((adapterView, v, i, l) -> Toast.makeText(getActivity(), "" + weatherForecasts.get(i).getDate() + "    " + weatherForecasts.get(i).getText_day(), Toast.LENGTH_SHORT).show());
        forecastRecyclerView.setItemAnimator(new DefaultItemAnimator());
        forecastRecyclerView.setAdapter(forecastAdapter);

        //生活指数
        lifeIndexRecyclerView.setNestedScrollingEnabled(false);
        lifeIndexRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        lifeIndexList = new ArrayList<>();
        lifeIndexAdapter = new LifeIndexAdapter(getActivity(), lifeIndexList);
        //lifeIndexAdapter.setOnItemClickListener((adapterView, v, i, l) -> Toast.makeText(HomePageFragment.this.getContext(), lifeIndexList.get(i).getDetails(), Toast.LENGTH_LONG).show());
        lifeIndexRecyclerView.setItemAnimator(new DefaultItemAnimator());
        lifeIndexRecyclerView.setAdapter(lifeIndexAdapter);

        smartRefreshLayout = getActivity().findViewById(R.id.refresh_layout);
        parallax = getActivity().findViewById(R.id.parallax);
        smartRefreshLayout.setEnableLoadMore(false);//禁用上拉刷新
        smartRefreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                mWeatherPresenter.weather(mIdOrLL);
            }
        });

        return view;
    }

    //设置近期天气数据
    public void setWeatherForecasts(Weather weather) {
        weatherForecasts.clear();
        weatherForecasts.addAll(weather.getDaily());
        forecastAdapter.notifyDataSetChanged();
    }

    //设置生活指数数据
    public void setLifeIndex(Weather weather) {
        lifeIndexList.clear();
        lifeIndexList.addAll(weather.getLifeIndexList());
        lifeIndexAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onAttach();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onDetach();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (interactionListener != null) {
            interactionListener = null;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void loadProgress() {
        ProgressDialogEx.showProgressDialog(getActivity());
    }

    @Override
    public void hideProgress() {
        ProgressDialogEx.dismissProgressDialog();
    }

    @Override
    public void onSuccess(Weather weather) {
        interactionListener.updatePageTitle(
                weather.getLocation().getName(),
                weather.getNow().getText(),
                weather.getNow().getCode(),
                weather.getNow().getTemperature(),
                weather.getLast_update());
        setWeatherForecasts(weather);
        setLifeIndex(weather);

        //写入数据
        saveInSQLite(weather);
        smartRefreshLayout.finishRefresh();
    }

    /**
     * 存储数据到SQLite数据库
     */
    private void saveInSQLite(Weather weather) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", weather.getLocation().getId());
        contentValues.put("name", weather.getLocation().getName());
        contentValues.put("text", weather.getNow().getText());
        contentValues.put("code", weather.getNow().getCode());
        contentValues.put("temperature", weather.getNow().getTemperature());
        contentValues.put("last_time", weather.getLast_update());

        long weatherResult = db.insert("weather", null, contentValues);
        if (weatherResult > 0) {
            Logger.d(TAG, "天气添加成功");
        } else {
            Logger.d(TAG, "天气添加失败");
        }

        for (int i = 0; i < weather.getDaily().size(); i++) {
            Daily.ResultsBean.DailyBean dailyBean = weather.getDaily().get(i);
            ContentValues fccv = new ContentValues();
            fccv.put("_id", weather.getLocation().getId());
            fccv.put("location_id", weather.getLocation().getId());
            fccv.put("time", dailyBean.getDate());
            fccv.put("text", dailyBean.getText_day());
            fccv.put("high", dailyBean.getHigh());
            fccv.put("low", dailyBean.getLow());
            long forecastResult = db.insert("forecast", null, fccv);
            if (forecastResult > 0) {
                Logger.d(TAG, "天气预报添加成功" + i);
            } else {
                Logger.d(TAG, "天气预报添加失败" + i);
            }
        }

        int lifeIndexSize = weather.getLifeIndexList().size();
        for (int i = 0; i < lifeIndexSize; i++) {
            LifeIndex lifeIndex = weather.getLifeIndexList().get(i);
            ContentValues licv = new ContentValues();
            licv.put("_id", weather.getLocation().getId());
            licv.put("location_id", weather.getLocation().getId());
            licv.put("name", lifeIndex.getName());
            licv.put("life_index", lifeIndex.getIndex());
            licv.put("detail", lifeIndex.getDetails());
            long lifeIndexResult = db.insert("life_index", null, licv);
            if (lifeIndexResult > 0) {
                Logger.d(TAG, "生活指数添加成功" + i);
            } else {
                Logger.d(TAG, "添加失败 " + i);
            }
        }

        db.close();
    }

    @Override
    public void onFailure() {
        ProgressDialogEx.dismissProgressDialog();
    }

    /**
     * Fragment通过接口实现数据的回调 更新activity中的数据
     */
    public interface InteractionListener {

        /**
         * 回调更新首页数据
         *
         * @param text        天气现象文字
         * @param code        天气现象代码
         * @param temperature 温度，单位为c摄氏度或f华氏度
         * @param last_update 数据更新时间（该城市的本地时间）
         */
        void updatePageTitle(String location, String text, String code, String temperature, String last_update);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mWeatherPresenter.result(requestCode, resultCode, data);
    }

    @Override
    public void onWeather(String q) {

        mWeatherPresenter.weather(q);

        //searchFromSQLite(q);//从数据库读取数据
    }

    /**
     * 从数据看查询数据
     *
     * @param q 查询关键字 基本用不到 因为天气都是实时更新的
     */
    private void searchFromSQLite(String q) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hamburger_menu:
                startActivityForResult(new Intent(getContext(), CityListActivity.class), CityListActivity.REQUEST_CITY_LIST);
                break;
        }
        return true;
    }

}