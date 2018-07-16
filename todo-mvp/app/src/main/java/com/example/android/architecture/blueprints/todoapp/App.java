package com.example.android.architecture.blueprints.todoapp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * 自定义Application类
 */
public class App extends Application {

    //记录Activity数量
    private int count = 0;

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
                count++;
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
                if (count > 0) {
                    count--;
                }
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });

        // Logger的使用
        // https://blog.csdn.net/AsiaLYF/article/details/79067374
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return true;
                //return BuildConfig.DEBUG; //默认返回true:打印日志 false:隐藏日志
            }
        });

    }

    /**
     * 判断app是否在后台
     *
     * @return true | false
     */
    public boolean isBackground() {
        if (count <= 0) {
            return true;
        } else {
            return false;
        }
    }

}
