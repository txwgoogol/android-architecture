package com.example.todomvvm.data.bean;

import java.util.List;

//逐小时天气
public class WeatherHourly {

    /**
     * cloud : 5
     * cond_code : 100
     * cond_txt : 晴
     * dew : 26
     * hum : 89
     * pop : 2
     * pres : 999
     * time : 2019-07-21 22:00
     * tmp : 28
     * wind_deg : 99
     * wind_dir : 东风
     * wind_sc : 1-2
     * wind_spd : 8
     */

    private String cloud;
    private String cond_code;
    private String cond_txt;
    private String dew;
    private String hum;
    private String pop;
    private String pres;
    private String time;
    private String tmp;
    private String wind_deg;
    private String wind_dir;
    private String wind_sc;
    private String wind_spd;

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getCond_code() {
        return cond_code;
    }

    public void setCond_code(String cond_code) {
        this.cond_code = cond_code;
    }

    public String getCond_txt() {
        return cond_txt;
    }

    public void setCond_txt(String cond_txt) {
        this.cond_txt = cond_txt;
    }

    public String getDew() {
        return dew;
    }

    public void setDew(String dew) {
        this.dew = dew;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(String wind_deg) {
        this.wind_deg = wind_deg;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getWind_sc() {
        return wind_sc;
    }

    public void setWind_sc(String wind_sc) {
        this.wind_sc = wind_sc;
    }

    public String getWind_spd() {
        return wind_spd;
    }

    public void setWind_spd(String wind_spd) {
        this.wind_spd = wind_spd;
    }
}
