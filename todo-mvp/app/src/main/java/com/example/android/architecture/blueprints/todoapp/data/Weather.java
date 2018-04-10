package com.example.android.architecture.blueprints.todoapp.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model层 数据模型
 * Created by txw on 2018/4/3.
 */
public class Weather implements Parcelable {

    private WeatherinfoBean weatherinfo;

    public WeatherinfoBean getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(WeatherinfoBean weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public static class WeatherinfoBean implements Parcelable {

        private String city;
        private String cityid;
        private String temp;
        private String WD;
        private String WS;
        private String SD;
        private String WSE;
        private String time;
        private String isRadar;
        private String Radar;
        private String njd;
        private String qy;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public String getWS() {
            return WS;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public String getSD() {
            return SD;
        }

        public void setSD(String SD) {
            this.SD = SD;
        }

        public String getWSE() {
            return WSE;
        }

        public void setWSE(String WSE) {
            this.WSE = WSE;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getIsRadar() {
            return isRadar;
        }

        public void setIsRadar(String isRadar) {
            this.isRadar = isRadar;
        }

        public String getRadar() {
            return Radar;
        }

        public void setRadar(String Radar) {
            this.Radar = Radar;
        }

        public String getNjd() {
            return njd;
        }

        public void setNjd(String njd) {
            this.njd = njd;
        }

        public String getQy() {
            return qy;
        }

        public void setQy(String qy) {
            this.qy = qy;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.city);
            dest.writeString(this.cityid);
            dest.writeString(this.temp);
            dest.writeString(this.WD);
            dest.writeString(this.WS);
            dest.writeString(this.SD);
            dest.writeString(this.WSE);
            dest.writeString(this.time);
            dest.writeString(this.isRadar);
            dest.writeString(this.Radar);
            dest.writeString(this.njd);
            dest.writeString(this.qy);
        }

        public WeatherinfoBean() {
        }

        protected WeatherinfoBean(Parcel in) {
            this.city = in.readString();
            this.cityid = in.readString();
            this.temp = in.readString();
            this.WD = in.readString();
            this.WS = in.readString();
            this.SD = in.readString();
            this.WSE = in.readString();
            this.time = in.readString();
            this.isRadar = in.readString();
            this.Radar = in.readString();
            this.njd = in.readString();
            this.qy = in.readString();
        }

        public static final Parcelable.Creator<WeatherinfoBean> CREATOR = new Parcelable.Creator<WeatherinfoBean>() {
            @Override
            public WeatherinfoBean createFromParcel(Parcel source) {
                return new WeatherinfoBean(source);
            }

            @Override
            public WeatherinfoBean[] newArray(int size) {
                return new WeatherinfoBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.weatherinfo, flags);
    }

    public Weather() {
    }

    protected Weather(Parcel in) {
        this.weatherinfo = in.readParcelable(WeatherinfoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Weather> CREATOR = new Parcelable.Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel source) {
            return new Weather(source);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}
