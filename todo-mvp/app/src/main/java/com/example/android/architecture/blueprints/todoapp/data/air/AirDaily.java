package com.example.android.architecture.blueprints.todoapp.data.air;

/**
 * 逐日空气质量预报（付费接口)
 */
public class AirDaily {
    /**
     * aqi : 118
     * pm25 : 33
     * pm10 : 78
     * so2 : 3
     * no2 : 25
     * co : 0.789
     * o3 : 180
     * date : 2018-06-13
     * quality : 轻度污染
     */

    private String aqi;
    private String pm25;
    private String pm10;
    private String so2;
    private String no2;
    private String co;
    private String o3;
    private String date;
    private String quality;

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
