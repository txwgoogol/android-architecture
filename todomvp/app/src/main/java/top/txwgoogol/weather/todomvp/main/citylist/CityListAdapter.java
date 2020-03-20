package top.txwgoogol.weather.todomvp.main.citylist;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;

import top.txwgoogol.weather.todomvp.R;
import top.txwgoogol.weather.todomvp.data.bean.city.City;
import top.txwgoogol.weather.todomvp.util.TimeConvert;

/**
 * 城市列表适配器
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class CityListAdapter extends BaseQuickAdapter<City, BaseViewHolder> {

    CityListAdapter() {
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