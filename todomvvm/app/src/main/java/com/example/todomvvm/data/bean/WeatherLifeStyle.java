package com.example.todomvvm.data.bean;

//生活指数
public class WeatherLifeStyle {

    /**
     * type : comf
     * brf : 较不舒适
     * txt : 白天天气多云，并且空气湿度偏大，在这种天气条件下，您会感到有些闷热，不很舒适。
     */

    private String type;
    private String brf;
    private String txt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrf() {
        return brf;
    }

    public void setBrf(String brf) {
        this.brf = brf;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

}