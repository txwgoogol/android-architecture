package com.txwgoogol.top.weather.todoapp.main.weather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.txwgoogol.top.weather.todoapp.R;
import com.txwgoogol.top.weather.todoapp.base.BaseRecyclerViewAdapter;
import com.txwgoogol.top.weather.todoapp.data.bean.weather.Daily;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 未来天气预报适配器
 */
public class ForecastAdapter extends BaseRecyclerViewAdapter<ForecastAdapter.ViewHolder> {

    private List<Daily.ResultsBean.DailyBean> weatherForecasts;

    public ForecastAdapter(List<Daily.ResultsBean.DailyBean> dailyBeans) {
        this.weatherForecasts = dailyBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ForecastAdapter.ViewHolder holder, int position) {
        Daily.ResultsBean.DailyBean dailyBean = weatherForecasts.get(position);
        holder.weekTextView.setText(dailyBean.getDate()); //日期
        holder.weatherTextView.setText(dailyBean.getText_day()); //天气情况
        holder.tempMaxTextView.setText(dailyBean.getHigh()); //最高温度
        holder.tempMinTextView.setText(dailyBean.getLow()); //最低温度
    }

    @Override
    public int getItemCount() {
        return weatherForecasts == null ? 0 : weatherForecasts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.week_text_view)
        TextView weekTextView;
        @BindView(R.id.weather_text_view)
        TextView weatherTextView;
        @BindView(R.id.temp_max_text_view)
        TextView tempMaxTextView;
        @BindView(R.id.temp_min_text_view)
        TextView tempMinTextView;

        ViewHolder(View itemView, ForecastAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}