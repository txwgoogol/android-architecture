package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseRecyclerViewAdapter;
import com.example.android.architecture.blueprints.todoapp.data.weather.Daily;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 未来三天天气预报
 */
public class ForecastAdapter extends BaseRecyclerViewAdapter<ForecastAdapter.ViewHolder> {

    private List<Daily> weatherForecasts;

    public ForecastAdapter(List<Daily> weatherForecasts) {
        this.weatherForecasts = weatherForecasts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ForecastAdapter.ViewHolder holder, int position) {
//        Daily weatherForecast = weatherForecasts.get(position);
//        holder.weekTextView.setText(weatherForecast.getDate()); //日期
//        holder.weatherIconImageView.setImageResource(R.mipmap.ic_launcher_round); //图标
//        holder.tempMaxTextView.setText(weatherForecast.getHigh()); //最高温度
//        holder.tempMinTextView.setText(weatherForecast.getLow()); //最低温度
    }

    @Override
    public int getItemCount() {
        return weatherForecasts == null ? 0 : weatherForecasts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.week_text_view)
        TextView weekTextView;
        @BindView(R.id.weather_icon_image_view)
        ImageView weatherIconImageView;
        @BindView(R.id.temp_max_text_view)
        TextView tempMaxTextView;
        @BindView(R.id.temp_min_text_view)
        TextView tempMinTextView;

        ViewHolder(View itemView, ForecastAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> adapter.onItemHolderClick(ViewHolder.this));
        }
    }
}
