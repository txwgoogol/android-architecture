package com.example.android.architecture.blueprints.todoapp.main.citylist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseRecyclerViewAdapter;
import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.util.TimeConvert;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 城市列表适配器
 */
public class CityListAdapter extends BaseRecyclerViewAdapter<CityListAdapter.ViewHolder> {

    private List<City> mCityList;

    public CityListAdapter(List<City> cityList) {
        this.mCityList = cityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(CityListAdapter.ViewHolder holder, int position) {
        City city = mCityList.get(position);

        //Glide.with(mContext).load(city.getCode()).into(holder.weatherGif); //加载Gif动画
        holder.cityTime.setText(TimeConvert.stampToTime(String.valueOf(System.currentTimeMillis()))); //当前时间
        holder.cityName.setText(city.getName()); //城市名称
        holder.cityTemplate.setText(city.getTemperature() + "°"); //当前城市的温度

        /* 处理滑动删除
        holder.delete.setOnClickListener(v -> {
            mCityList.remove(position);
            notifyDataSetChanged();
        });
        //holder.slideDeleteLayout.requestLayout();//刷新布局
        */
    }

    @Override
    public int getItemCount() {
        return mCityList == null ? 0 : mCityList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        //@BindView(R.id.swipe_delete_layout)
        //SlideDeleteLayout slideDeleteLayout;
        @BindView(R.id.weather_gif)
        ImageView weatherGif;
        @BindView(R.id.city_time)
        TextView cityTime;
        @BindView(R.id.city_name)
        TextView cityName;
        @BindView(R.id.city_template)
        TextView cityTemplate;
        @BindView(R.id.delete)
        TextView delete;

        ViewHolder(View itemView, CityListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            /**
             * 点击事件
             */
            itemView.setOnClickListener(v -> adapter.onItemHolderClick(CityListAdapter.ViewHolder.this));

            /**
             * 长按事件
             */
            itemView.setOnLongClickListener(v -> {
                adapter.onItemHolderLongClick(CityListAdapter.ViewHolder.this);
                return true;
            });
        }
    }

}
