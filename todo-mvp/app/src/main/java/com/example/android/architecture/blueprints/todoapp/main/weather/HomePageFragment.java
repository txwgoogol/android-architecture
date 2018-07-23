package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseFragment;
import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.data.db.sqlite.DBUtils;
import com.example.android.architecture.blueprints.todoapp.data.life.LifeIndex;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Weather;
import com.example.android.architecture.blueprints.todoapp.main.citylist.CityListActivity;
import com.example.android.architecture.blueprints.todoapp.util.TimeConvert;
import com.example.android.architecture.blueprints.todoapp.util.Utils;
import com.example.android.architecture.blueprints.widget.TitleView;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

public class HomePageFragment extends BaseFragment implements WeatherContact.View {

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

    private FrameLayout frameLayout;
    private SmartRefreshLayout smartRefreshLayout;
    private ImageView parallax;
    private LinearLayout linearLayout;
    //回调得到的城市ID Or 初始定位得到的经纬度

    private City city;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        unbinder = ButterKnife.bind(this, view);

        mWeatherPresenter = new WeatherPresenter(this);

        //覆写activity的菜单
        setHasOptionsMenu(true);

        //天气预报
        forecastRecyclerView.setNestedScrollingEnabled(false);
        forecastRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        weatherForecasts = new ArrayList<>();
        forecastAdapter = new ForecastAdapter(weatherForecasts);
        forecastRecyclerView.setItemAnimator(new DefaultItemAnimator());
        forecastRecyclerView.setAdapter(forecastAdapter);

        //生活指数
        lifeIndexRecyclerView.setNestedScrollingEnabled(false);
        lifeIndexRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        lifeIndexList = new ArrayList<>();
        lifeIndexAdapter = new LifeIndexAdapter(getActivity(), lifeIndexList);
        lifeIndexRecyclerView.setItemAnimator(new DefaultItemAnimator());
        lifeIndexRecyclerView.setAdapter(lifeIndexAdapter);

        frameLayout = getActivity().findViewById(R.id.frame_layout);
        smartRefreshLayout = getActivity().findViewById(R.id.refresh_layout);
        parallax = getActivity().findViewById(R.id.parallax);
        linearLayout = getActivity().findViewById(R.id.loading_progress_ll);

        smartRefreshLayout.setEnableLoadMore(false);//禁用上拉刷新
        smartRefreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                mPresenter.forceUpdate(true);
            }
        });

        return view;
    }

    @Override
    public String getLocation() {
        return getArguments().getString("str");
    }

    @Override
    public String getLocationId() {
        //DBUtils.getInstance(getActivity()).query(Constant.TABLE_WEATHER,mPresenter.getLatitudeAndLongitude(getLocation()));
        return null;
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
    public void showWeather(Weather weather) {

        linearLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        linearLayout.setVisibility(View.GONE);
        frameLayout.setVisibility(View.VISIBLE);

        Logger.d(" "
                + weather.getLocation()
                + weather.getNow()
                + weather.getDaily()
                + weather.getLifeIndexList()
                + weather.getLast_update());


        //获取的是UTC时间 需要将其分割获取有效的时间显示
        String[] s = weather.getLast_update().split("\\+");

        interactionListener.updatePageTitle(
                weather.getLocation().getName(),
                weather.getNow().getText(),
                weather.getNow().getCode(),
                weather.getNow().getTemperature(),
                TimeConvert.formatUTC(s[0]));

        setWeatherForecasts(weather);
        setLifeIndex(weather);

        smartRefreshLayout.finishRefresh();

        city = new City();
        city.setId(weather.getLocation().getId());
        city.setName(weather.getLocation().getName());
        city.setCode(weather.getNow().getCode());
        city.setTemperature(weather.getNow().getTemperature());
        Logger.d(city.toString());

        //添加到城市列表
        Logger.d(DBUtils.getInstance(getActivity()).insert(new City(weather.getLocation().getId(),weather.getLast_update(),weather.getLocation().getName(),weather.getNow().getCode(),weather.getNow().getTemperature())));
        //添加到天气列表
        Logger.d(DBUtils.getInstance(getActivity()).insert(weather));

        //添加到城市列表
        //Logger.d(DBUtils.getInstance(getActivity()).insert(city));

        //写入或更新数据
        //DBUtils.getInstance(getActivity()).insert(weather);
        /*
        if (DBUtils.getInstance(getActivity()).insert(weather)) {
            Logger.d("写入或更新数据成功");

            City city = new City();
            city.setId(weather.getLocation().getId());
            city.setName(weather.getLocation().getName());
            city.setTime(TimeConvert.stampToTime(String.valueOf(System.currentTimeMillis())));
            city.setTemperature(weather.getNow().getTemperature());
            city.setCode(weather.getNow().getCode());
            //加入到城市列表
            DBUtils.getInstance(getActivity()).insert(city);
            //Logger.d(DBUtils.getInstance(getActivity()).insert(city));
        } else {
            Logger.d("写入或更新数据失败");
        }
        */
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hamburger_menu:
                /**/
                Intent intent = new Intent(getContext(), CityListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("city", city);
                intent.putExtras(bundle);
                startActivityForResult(intent, CityListActivity.REQUEST_CITY_LIST);

                //startActivityForResult(new Intent(getActivity(),CityListActivity.class), CityListActivity.REQUEST_CITY_LIST);
                break;
        }
        return true;
    }

    @Override
    public boolean getNetWorkAvailable() {
        return Utils.getNetWorkAvailable(getActivity());
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

}