package top.txwgoogol.weather.todomvp.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import top.txwgoogol.weather.todomvp.R;

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

        int code_img = R.drawable.ic_weather_sunny;

        switch (code) {
            case "0":
            case "1":
            case "2":
            case "3":
                code_img = R.drawable.ic_weather_sunny;
                break;
            case "4":
                code_img = R.drawable.ic_weather_cloudy;
                break;
            case "5":
            case "6":
            case "7":
            case "8":
                code_img = R.drawable.ic_weather_partly_cloudy;
                break;
            case "9":
                code_img = R.drawable.ic_weather_cloudy;
                break;
            case "10":
            case "11":
            case "12":
                code_img = R.drawable.ic_weather_hail;
                break;
            case "13":
                code_img = R.drawable.ic_weather_rainy;
                break;
            case "14":
            case "15":
                break;
            case "16":
            case "17":
            case "18":
                code_img = R.drawable.ic_weather_lightning_rainy;
                break;
            case "19":
                code_img = R.drawable.ic_weather_snowy_rainy;
                break;
            case "20":
            case "21":
            case "22":
            case "23":
            case "24":
            case "25":
                code_img = R.drawable.ic_weather_snowy;
                break;
            case "26":
            case "27":
            case "28":
            case "29":
            case "30":
            case "31":
                code_img = R.drawable.ic_weather_fog;
                break;
            case "32":
            case "33":
                code_img = R.drawable.ic_weather_windy;
                break;
            case "34":
                code_img = R.drawable.ic_weather_windy_variant_with_cloud;
                break;
            case "35":
                code_img = R.mipmap.ic_launcher;
                break;
            case "36":
                code_img = R.drawable.ic_weather_windy;
                break;
            case "37":
                code_img = R.drawable.ic_weather_windy;
                break;
            case "38":
                code_img = R.drawable.ic_weather_windy;
                break;
            case "99":
                code_img = R.drawable.ic_weather_sunny;
                break;
            default:
                code_img = R.drawable.ic_weather_sunny;
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