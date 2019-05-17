package top.txwgoogol.weather.todoapp.main.citylist;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;

import top.txwgoogol.weather.todoapp.R;
import top.txwgoogol.weather.todoapp.data.bean.city.City;
import top.txwgoogol.weather.todoapp.util.TimeConvert;

/**
 * 城市列表适配器
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class CityListAdapter extends BaseQuickAdapter<City, BaseViewHolder> {

    public CityListAdapter() {
        super(R.layout.item_city, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, City item) {
        Logger.d(item.getName());
        helper.setText(R.id.city_name, item.getName());
        helper.setText(R.id.city_time, TimeConvert.stampToTime(String.valueOf(System.currentTimeMillis())));
        helper.setText(R.id.city_template, item.getTemperature() + "°");
    }

}