package top.txwgoogol.weather.todomvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import top.txwgoogol.weather.todomvp.util.HandleBack;

/**
 * Activity基类 处理一些公共的操作
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class BaseActivity extends AppCompatActivity {

    /*
     * 解决Vector兼容性问题
     *
     * First up, this functionality was originally released in 23.2.0,
     * but then we found some memory usage and Configuration updating
     * issues so we it removed in 23.3.0. In 23.4.0 (technically a fix
     * release) we’ve re-added the same functionality but behind a flag
     * which you need to manually enable.
     *
     * http://www.jianshu.com/p/e3614e7abc03
     */
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (!HandleBack.handleBackPress(this)) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}