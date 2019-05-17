package top.txwgoogol.weather.todoapp.main;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.txwgoogol.weather.todoapp.R;
import top.txwgoogol.weather.todoapp.base.BaseActivity;
import top.txwgoogol.weather.todoapp.main.weather.HomePageFragment;
import top.txwgoogol.weather.todoapp.util.ActivityUtils;

/**
 * 主页
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class MainActivity extends BaseActivity implements HomePageFragment.InteractionListener {

    @BindView(R.id.publish_time_text_view)
    TextView publishTimeTextView;
    @BindView(R.id.temp_text_view)
    TextView tempTextView;
    @BindView(R.id.weather_text_view)
    TextView weatherTextView;
    @BindView(R.id.weather_icon_image_view)
    ImageView weatherIconImageView;
    @BindView(R.id.backdrop)
    RelativeLayout backdrop;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 如果设备的API(SDK)是5.0(21)以上的则整个页面覆盖全屏
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //设置Toolbar
        setSupportActionBar(toolbar);

        HomePageFragment tasksFragment = (HomePageFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (tasksFragment == null) {
            tasksFragment = HomePageFragment.newInstance(getIntent().getStringExtra("ll"));
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), tasksFragment, R.id.fragment_container);
        }

    }

    @Override
    public void updatePageTitle(String location, String text, String code, String temperature, String last_update) {
        toolbar.setTitle(location);//位置
        collapsingToolbar.setTitle(location);//位置
        //weatherIconImageView.setImageResource(CCTable.WpCode(code));//天气情况图片
        weatherTextView.setText(text); //天气情况文字
        tempTextView.setText(temperature); //温度
        publishTimeTextView.setText(last_update); //最近更新时间
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