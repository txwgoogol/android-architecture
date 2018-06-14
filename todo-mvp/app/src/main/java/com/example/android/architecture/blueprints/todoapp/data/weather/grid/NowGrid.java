package com.example.android.architecture.blueprints.todoapp.data.weather.grid;

/**
 * 格点天气实况（付费接口）
 */
public class NowGrid {
    /**
     * temperature : 22.80
     * dewpoint : 18.79
     * humidity : 78.43
     * wind_speed : 1.80
     * wind_scale : 1
     * wind_direction_degree : 107.40
     * wind_direction : 东南
     * precip : 0.00
     */

    private String temperature;
    private String dewpoint;
    private String humidity;
    private String wind_speed;
    private String wind_scale;
    private String wind_direction_degree;
    private String wind_direction;
    private String precip;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(String dewpoint) {
        this.dewpoint = dewpoint;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_scale() {
        return wind_scale;
    }

    public void setWind_scale(String wind_scale) {
        this.wind_scale = wind_scale;
    }

    public String getWind_direction_degree() {
        return wind_direction_degree;
    }

    public void setWind_direction_degree(String wind_direction_degree) {
        this.wind_direction_degree = wind_direction_degree;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip;
    }
}
