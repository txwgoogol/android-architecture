package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseFragment;
import com.example.android.architecture.blueprints.todoapp.data.Weather;
import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.view.ProgressDialogEx;
import com.example.android.architecture.blueprints.widget.TitleView;

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

    private List<Daily.ResultsBean.DailyBean> weatherForecasts;
    private List<Suggestion> lifeIndices;

    private ForecastAdapter forecastAdapter;
    private LifeSuggestionAdapter lifeIndexAdapter;

    //回调接口 用于更新首页的数据
    private InteractionListener interactionListener;

    private WeatherContact.Presenter mPresenter;
    private WeatherPresenter mWeatherPresenter;

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
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
                throw new RuntimeException(activity.toString()
                        + " must implement ABC_Listener");
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

        //天气预报
        forecastRecyclerView.setNestedScrollingEnabled(false);
        forecastRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        weatherForecasts = new ArrayList<>();
        forecastAdapter = new ForecastAdapter(weatherForecasts);
        forecastAdapter.setOnItemClickListener((adapterView, v, i, l) -> {
            Toast.makeText(getActivity(), "" + weatherForecasts.get(i).getDate() + "    " + weatherForecasts.get(i).getText_day(), Toast.LENGTH_SHORT).show();
        });
        forecastRecyclerView.setItemAnimator(new DefaultItemAnimator());
        forecastRecyclerView.setAdapter(forecastAdapter);

        //生活指数
        //lifeIndexRecyclerView.setNestedScrollingEnabled(false);
        //lifeIndexRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        //lifeIndices = new ArrayList<>();
        //lifeIndexAdapter = new LifeSuggestionAdapter(getActivity(), lifeIndices);
        //lifeIndexAdapter.setOnItemClickListener((adapterView, v, i, l) -> Toast.makeText(HomePageFragment.this.getContext(), lifeIndices.get(i).getDetails(), Toast.LENGTH_LONG).show());
        //lifeIndexRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //lifeIndexRecyclerView.setAdapter(lifeIndexAdapter);

        return view;
    }

    //设置近期天气数据
    public void setWeatherForecasts(Weather weather) {
        weatherForecasts.clear();
        weatherForecasts.addAll(weather.getDaily());
        forecastAdapter.notifyDataSetChanged();
    }

    public void setLifeSuggestion(Weather weather) {
        //lifeIndices.addAll(weather.getSuggestion());
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interactionListener = null;
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

}