package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseActivity;
import com.example.android.architecture.blueprints.todoapp.util.ActivityUtils;
import com.example.android.architecture.blueprints.todoapp.util.CCTable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements HomePageFragment.InteractionListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.parallax)
    ImageView parallax;
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
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;

//    private int mOffset = 0;
//    private int mScrollY = 0;

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

        setSupportActionBar(toolbar);

        HomePageFragment tasksFragment = (HomePageFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (tasksFragment == null) {
            tasksFragment = HomePageFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), tasksFragment, R.id.fragment_container);
        }

        refreshLayout.setEnableLoadMore(false);//禁用上拉刷新
        refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000);
            }

            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                /*
                mOffset = offset / 2;
                parallax.setTranslationY(mOffset - mScrollY);
                toolbar.setAlpha(1 - Math.min(percent, 1));
                 */
            }
        });

        /*

        NestedScrollView nestedScrollView = tasksFragment.getView().findViewById(R.id.nested_scroll_view);

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

            private int lastScrollY = 0;
            private int h = DensityUtil.dp2px(170);
            private int color = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary) & 0x00ffffff;

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {


                Log.d(TAG, "onScrollChange: "+lastScrollY);

                if (lastScrollY < h) {
                    scrollY = Math.min(h, scrollY);
                    mScrollY = scrollY > h ? h : scrollY;
                    buttonBarLayoutTop.setAlpha(1f * mScrollY / h);
                    toolbarTop.setBackgroundColor(((255 * mScrollY / h) << 24) | color);
                    parallax.setTranslationY(mOffset - mScrollY);
                }
                lastScrollY = scrollY;
            }
        });

        buttonBarLayoutTop.setAlpha(0);
        toolbarTop.setBackgroundColor(0);

         */

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void updatePageTitle(String location, String text, String code, String temperature, String last_update) {
        toolbar.setTitle(location);//位置
        collapsingToolbar.setTitle(location);//位置
        weatherIconImageView.setImageResource(CCTable.WpCode(code));//天气情况图片
        weatherTextView.setText(text); //天气情况文字
        tempTextView.setText(temperature); //温度
        publishTimeTextView.setText(last_update); //最近更新时间
    }

}