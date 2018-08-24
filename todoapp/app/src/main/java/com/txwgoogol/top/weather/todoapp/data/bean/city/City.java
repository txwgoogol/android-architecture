package com.txwgoogol.top.weather.todoapp.data.bean.city;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 城市列表实体类
 */
public class City implements Parcelable {

    private String id; //城市ID
    private String time; //当前时间
    private String name; //城市名称
    private String code;//天气情况代码
    private String temperature; //温度

    public City() {
    }

    public City(String id, String time, String name, String code, String temperature) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.code = code;
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.time);
        dest.writeString(this.name);
        dest.writeString(this.code);
        dest.writeString(this.temperature);
    }

    protected City(Parcel in) {
        this.id = in.readString();
        this.time = in.readString();
        this.name = in.readString();
        this.code = in.readString();
        this.temperature = in.readString();
    }

    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}