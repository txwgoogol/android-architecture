package top.txwgoogol.weather.todomvp.main.citylist;

import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.umeng.analytics.MobclickAgent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import top.txwgoogol.weather.todomvp.R;
import top.txwgoogol.weather.todomvp.data.bean.city.City;
import top.txwgoogol.weather.todomvp.util.ActivityUtils;

/**
 * 城市列表
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class CityListActivity extends AppCompatActivity {

    public static final int REQUEST_CITY_LIST = 1;
    private City mCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        Logger.d(Objects.requireNonNull(getIntent().getParcelableExtra("city")).toString());

        CityListFragment cityListFragment = (CityListFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if (cityListFragment == null) {
            cityListFragment = CityListFragment.newInstance(Objects.requireNonNull(getIntent().getParcelableExtra("city")));
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), cityListFragment, R.id.frame_layout);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}