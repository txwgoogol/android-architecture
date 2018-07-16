package com.example.android.architecture.blueprints.todoapp.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.android.architecture.blueprints.todoapp.R;

/**
 * 代码对照表
 * 根据代码设置对应的图标/文字
 * Code Control Table
 */
public class CCTable {

    /**
     * 天气现象代码对照表
     *
     * @param code 天气现象代码
     * @return 根据天气现象代码设置对应的天气图标
     */
    public static int WpCode(String code) {

        int code_img = R.mipmap.ic_launcher;

        switch (code) {
            case "0":
                code_img = R.mipmap.ic_launcher;
                break;
            case "1":
                code_img = R.mipmap.ic_launcher;
                break;
            case "2":
                code_img = R.mipmap.ic_launcher;
                break;
            case "3":
                code_img = R.mipmap.ic_launcher;
                break;
            case "4":
                code_img = R.mipmap.ic_launcher;
                break;
            case "5":
                code_img = R.mipmap.ic_launcher;
                break;
            case "6":
                code_img = R.mipmap.ic_launcher;
                break;
            case "7":
                code_img = R.mipmap.ic_launcher;
                break;
            case "8":
                code_img = R.mipmap.ic_launcher;
                break;
            case "9":
                code_img = R.mipmap.ic_launcher;
                break;
            case "10":
                code_img = R.mipmap.ic_launcher;
                break;
            case "11":
                code_img = R.mipmap.ic_launcher;
                break;
            case "12":
                code_img = R.mipmap.ic_launcher;
                break;
            case "13":
                code_img = R.mipmap.ic_launcher;
                break;
            case "14":
                code_img = R.mipmap.ic_launcher;
                break;
            case "15":
                code_img = R.mipmap.ic_launcher;
                break;
            case "16":
                code_img = R.mipmap.ic_launcher;
                break;
            case "17":
                code_img = R.mipmap.ic_launcher;
                break;
            case "18":
                code_img = R.mipmap.ic_launcher;
                break;
            case "19":
                code_img = R.mipmap.ic_launcher;
                break;
            case "20":
                code_img = R.mipmap.ic_launcher;
                break;
            case "21":
                code_img = R.mipmap.ic_launcher;
                break;
            case "22":
                code_img = R.mipmap.ic_launcher;
                break;
            case "23":
                code_img = R.mipmap.ic_launcher;
                break;
            case "24":
                code_img = R.mipmap.ic_launcher;
                break;
            case "25":
                code_img = R.mipmap.ic_launcher;
                break;
            case "26":
                code_img = R.mipmap.ic_launcher;
                break;
            case "27":
                code_img = R.mipmap.ic_launcher;
                break;
            case "28":
                code_img = R.mipmap.ic_launcher;
                break;
            case "29":
                code_img = R.mipmap.ic_launcher;
                break;
            case "30":
                code_img = R.mipmap.ic_launcher;
                break;
            case "31":
                code_img = R.mipmap.ic_launcher;
                break;
            case "32":
                code_img = R.mipmap.ic_launcher;
                break;
            case "33":
                code_img = R.mipmap.ic_launcher;
                break;
            case "34":
                code_img = R.mipmap.ic_launcher;
                break;
            case "35":
                code_img = R.mipmap.ic_launcher;
                break;
            case "36":
                code_img = R.mipmap.ic_launcher;
                break;
            case "37":
                code_img = R.mipmap.ic_launcher;
                break;
            case "38":
                code_img = R.mipmap.ic_launcher;
                break;
            case "99":
                code_img = R.mipmap.ic_launcher;
                break;
            default:
                code_img = R.mipmap.ic_launcher;
                break;
        }
        return code_img;
    }

    /**
     * 生活指数
     *
     * @param context
     * @param indexName
     * @return
     */
    public static Drawable getIndexDrawable(Context context, String indexName) {
        int colorResourceId = R.drawable.ic_index_sunscreen;
        if (indexName.contains("洗车")) {
            colorResourceId = R.drawable.ic_index_car_wash;
        } else if (indexName.contains("穿衣")) {
            colorResourceId = R.drawable.ic_index_dress;
        } else if (indexName.contains("感冒")) {
            colorResourceId = R.drawable.ic_index_clod;
        } else if (indexName.contains("运动")) {
            colorResourceId = R.drawable.ic_index_sport;
        } else if (indexName.contains("旅游")) {
            colorResourceId = R.drawable.ic_wallet_travel;
        } else if (indexName.contains("紫外线")) {
            colorResourceId = R.drawable.ic_index_sunscreen;
        }
        return context.getResources().getDrawable(colorResourceId);
    }

}