package com.example.android.architecture.blueprints.todoapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.app.ApplicationErrorReport.TYPE_NONE;
import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.net.ConnectivityManager.TYPE_MOBILE;
import static android.net.ConnectivityManager.TYPE_VPN;
import static android.net.ConnectivityManager.TYPE_WIFI;

/**
 * 工具类
 */
public class Utils {

    /**
     * 获取网络状态
     *
     * @param context 上下文参数
     * @return 返回当前网络状态 -1(TYPE_NONE):网络不可用 0(TYPE_MOBILE):手机网络 1:Wi-Fi
     */
    public static int getNetWorkState(Context context) {
        int state = -1;
        ConnectivityManager connectionManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
        if (networkInfo.isAvailable() && networkInfo != null) {
            switch (networkInfo.getType()) {
                case TYPE_MOBILE:
                    state = TYPE_MOBILE;
                    break;
                case TYPE_WIFI:
                    state = TYPE_WIFI;
                    break;
                case TYPE_VPN:
                    state = TYPE_VPN;
                    break;
            }
        } else {
            state = TYPE_NONE;
        }
        return state;
    }

    /**
     * 获取网络是否可用
     *
     * @param context 上下文参数
     * @return 网络是否可用
     */
    public static boolean getNetWorkAvailable(Context context) {
        ConnectivityManager connectionManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
        if (networkInfo.isAvailable() && networkInfo != null) {
            return true;
        } else {
            return false;
        }
    }

}
