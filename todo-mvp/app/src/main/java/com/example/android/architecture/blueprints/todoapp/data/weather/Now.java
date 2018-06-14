package com.example.android.architecture.blueprints.todoapp.data.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Model层 数据模型
 * Created by txw on 2018/4/3.
 */
public class Now implements Parcelable {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Parcelable {

        private LocationBean location;
        private NowBean now;
        private String last_update;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }

        public static class LocationBean implements Parcelable {

            private String id;
            private String name;
            private String country;
            private String path;
            private String timezone;
            private String timezone_offset;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public String getTimezone_offset() {
                return timezone_offset;
            }

            public void setTimezone_offset(String timezone_offset) {
                this.timezone_offset = timezone_offset;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.name);
                dest.writeString(this.country);
                dest.writeString(this.path);
                dest.writeString(this.timezone);
                dest.writeString(this.timezone_offset);
            }

            public LocationBean() {
            }

            protected LocationBean(Parcel in) {
                this.id = in.readString();
                this.name = in.readString();
                this.country = in.readString();
                this.path = in.readString();
                this.timezone = in.readString();
                this.timezone_offset = in.readString();
            }

            public static final Parcelable.Creator<LocationBean> CREATOR = new Parcelable.Creator<LocationBean>() {
                @Override
                public LocationBean createFromParcel(Parcel source) {
                    return new LocationBean(source);
                }

                @Override
                public LocationBean[] newArray(int size) {
                    return new LocationBean[size];
                }
            };
        }

        public static class NowBean implements Parcelable {

            private String text;
            private String code;
            private String temperature;
            private String feels_like;
            private String pressure;
            private String humidity;
            private String visibility;
            private String wind_direction;
            private String wind_direction_degree;
            private String wind_speed;
            private String wind_scale;
            private String clouds;
            private String dew_point;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
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

            public String getFeels_like() {
                return feels_like;
            }

            public void setFeels_like(String feels_like) {
                this.feels_like = feels_like;
            }

            public String getPressure() {
                return pressure;
            }

            public void setPressure(String pressure) {
                this.pressure = pressure;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getVisibility() {
                return visibility;
            }

            public void setVisibility(String visibility) {
                this.visibility = visibility;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_direction_degree() {
                return wind_direction_degree;
            }

            public void setWind_direction_degree(String wind_direction_degree) {
                this.wind_direction_degree = wind_direction_degree;
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

            public String getClouds() {
                return clouds;
            }

            public void setClouds(String clouds) {
                this.clouds = clouds;
            }

            public String getDew_point() {
                return dew_point;
            }

            public void setDew_point(String dew_point) {
                this.dew_point = dew_point;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.text);
                dest.writeString(this.code);
                dest.writeString(this.temperature);
                dest.writeString(this.feels_like);
                dest.writeString(this.pressure);
                dest.writeString(this.humidity);
                dest.writeString(this.visibility);
                dest.writeString(this.wind_direction);
                dest.writeString(this.wind_direction_degree);
                dest.writeString(this.wind_speed);
                dest.writeString(this.wind_scale);
                dest.writeString(this.clouds);
                dest.writeString(this.dew_point);
            }

            public NowBean() {
            }

            protected NowBean(Parcel in) {
                this.text = in.readString();
                this.code = in.readString();
                this.temperature = in.readString();
                this.feels_like = in.readString();
                this.pressure = in.readString();
                this.humidity = in.readString();
                this.visibility = in.readString();
                this.wind_direction = in.readString();
                this.wind_direction_degree = in.readString();
                this.wind_speed = in.readString();
                this.wind_scale = in.readString();
                this.clouds = in.readString();
                this.dew_point = in.readString();
            }

            public static final Parcelable.Creator<NowBean> CREATOR = new Parcelable.Creator<NowBean>() {
                @Override
                public NowBean createFromParcel(Parcel source) {
                    return new NowBean(source);
                }

                @Override
                public NowBean[] newArray(int size) {
                    return new NowBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.location, flags);
            dest.writeParcelable(this.now, flags);
            dest.writeString(this.last_update);
        }

        public ResultsBean() {
        }

        protected ResultsBean(Parcel in) {
            this.location = in.readParcelable(LocationBean.class.getClassLoader());
            this.now = in.readParcelable(NowBean.class.getClassLoader());
            this.last_update = in.readString();
        }

        public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
            @Override
            public ResultsBean createFromParcel(Parcel source) {
                return new ResultsBean(source);
            }

            @Override
            public ResultsBean[] newArray(int size) {
                return new ResultsBean[size];
            }
        };
    }

    public Now() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.results);
    }

    protected Now(Parcel in) {
        this.results = in.createTypedArrayList(ResultsBean.CREATOR);
    }

    public static final Creator<Now> CREATOR = new Creator<Now>() {
        @Override
        public Now createFromParcel(Parcel source) {
            return new Now(source);
        }

        @Override
        public Now[] newArray(int size) {
            return new Now[size];
        }
    };
}
