package top.txwgoogol.weather.todomvp.main.citylist;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.txwgoogol.weather.todomvp.R;
import top.txwgoogol.weather.todomvp.base.BaseRecyclerViewAdapter;
import top.txwgoogol.weather.todomvp.data.bean.city.City;
import top.txwgoogol.weather.todomvp.util.TimeConvert;

/**
 * 城市列表适配器
 *
 * @author txw
 * @// TODO: 04/12/18
 */
@Deprecated
public class OldCityListAdapter extends BaseRecyclerViewAdapter<OldCityListAdapter.ViewHolder> {

    private List<City> mCityList;

    public OldCityListAdapter(List<City> cityList) {
        this.mCityList = cityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(OldCityListAdapter.ViewHolder holder, int position) {
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
        @BindView(R.id.city_time)
        TextView cityTime;
        @BindView(R.id.city_name)
        TextView cityName;
        @BindView(R.id.city_template)
        TextView cityTemplate;
        @BindView(R.id.delete)
        TextView delete;

        ViewHolder(View itemView, OldCityListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            /**
             * 点击事件
             */
            itemView.setOnClickListener(v -> adapter.onItemHolderClick(OldCityListAdapter.ViewHolder.this));

            /**
             * 长按事件
             */
            itemView.setOnLongClickListener(v -> {
                adapter.onItemHolderLongClick(OldCityListAdapter.ViewHolder.this);
                return true;
            });
        }
    }

}