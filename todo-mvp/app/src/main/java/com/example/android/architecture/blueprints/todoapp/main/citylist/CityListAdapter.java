package com.example.android.architecture.blueprints.todoapp.main.citylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseRecyclerViewAdapter;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 城市列表适配器
 */
public class CityListAdapter extends BaseRecyclerViewAdapter<CityListAdapter.ViewHolder> {

    private static final String TAG = "CityAdapter";

    private Now mCityList;
    private Context mContext;

    public CityListAdapter(Context context, Now now) {
        this.mContext = context;
        //this.mCityList = cityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(CityListAdapter.ViewHolder holder, int position) {
        //City city = mCityList.get(position);
        //Glide.with(mContext).load(city.getNow_code()).into(holder.weatherGif); //加载Gif动画
        //holder.cityTime.setText(city.getCity_time()); //当前时间
        //holder.cityName.setText(city.getCity_name()); //城市名称
        //holder.cityTemplate.setText(city.getNow_template()); //当前城市的温度
    }

    @Override
    public int getItemCount() {
        //return mCityList == null ? 0 : mCityList.size();
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.weather_gif)
        ImageView weatherGif;
        @BindView(R.id.city_time)
        TextView cityTime;
        @BindView(R.id.city_name)
        TextView cityName;
        @BindView(R.id.city_template)
        TextView cityTemplate;

        ViewHolder(View itemView, CityListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
