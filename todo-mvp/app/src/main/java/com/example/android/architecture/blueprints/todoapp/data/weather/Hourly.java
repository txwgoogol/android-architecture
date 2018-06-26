package com.example.android.architecture.blueprints.todoapp.data.weather;

import java.util.List;

/**
 * 24小时逐小时天气预报（付费接口）
 */
public class Hourly {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * ic_location : {"id":"WX4FBXXFKE4F","name":"北京","country":"CN","path":"北京,北京,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"}
         * hourly : [{"time":"2018-06-13T09:00:00+08:00","text":"雷阵雨","code":"11","temperature":"24","humidity":"74","wind_direction":"东北","wind_speed":"14.04"},{"time":"2018-06-13T10:00:00+08:00","text":"雷阵雨","code":"11","temperature":"26","humidity":"72","wind_direction":"东北","wind_speed":"15.12"},{"time":"2018-06-13T11:00:00+08:00","text":"雷阵雨","code":"11","temperature":"28","humidity":"69","wind_direction":"东北","wind_speed":"16.20"},{"time":"2018-06-13T12:00:00+08:00","text":"雷阵雨","code":"11","temperature":"28","humidity":"67","wind_direction":"东北","wind_speed":"15.12"},{"time":"2018-06-13T13:00:00+08:00","text":"雷阵雨","code":"11","temperature":"28","humidity":"65","wind_direction":"东北","wind_speed":"14.40"},{"time":"2018-06-13T14:00:00+08:00","text":"雷阵雨","code":"11","temperature":"28","humidity":"63","wind_direction":"东北","wind_speed":"13.32"},{"time":"2018-06-13T15:00:00+08:00","text":"雷阵雨","code":"11","temperature":"27","humidity":"63","wind_direction":"东北","wind_speed":"12.96"},{"time":"2018-06-13T16:00:00+08:00","text":"雷阵雨","code":"11","temperature":"26","humidity":"63","wind_direction":"东北","wind_speed":"12.24"},{"time":"2018-06-13T17:00:00+08:00","text":"雷阵雨","code":"11","temperature":"26","humidity":"63","wind_direction":"东北","wind_speed":"11.88"},{"time":"2018-06-13T18:00:00+08:00","text":"雷阵雨","code":"11","temperature":"25","humidity":"66","wind_direction":"东北","wind_speed":"11.52"},{"time":"2018-06-13T19:00:00+08:00","text":"雷阵雨","code":"11","temperature":"24","humidity":"70","wind_direction":"东北","wind_speed":"11.52"},{"time":"2018-06-13T20:00:00+08:00","text":"雷阵雨","code":"11","temperature":"23","humidity":"74","wind_direction":"东北","wind_speed":"11.16"},{"time":"2018-06-13T21:00:00+08:00","text":"晴","code":"1","temperature":"22","humidity":"77","wind_direction":"东南","wind_speed":"12.96"},{"time":"2018-06-13T22:00:00+08:00","text":"晴","code":"1","temperature":"22","humidity":"80","wind_direction":"西南","wind_speed":"14.40"},{"time":"2018-06-13T23:00:00+08:00","text":"晴","code":"1","temperature":"21","humidity":"82","wind_direction":"西北","wind_speed":"16.20"},{"time":"2018-06-14T00:00:00+08:00","text":"晴","code":"1","temperature":"20","humidity":"84","wind_direction":"西北","wind_speed":"16.20"},{"time":"2018-06-14T01:00:00+08:00","text":"晴","code":"1","temperature":"20","humidity":"86","wind_direction":"西北","wind_speed":"16.20"},{"time":"2018-06-14T02:00:00+08:00","text":"晴","code":"1","temperature":"20","humidity":"88","wind_direction":"西北","wind_speed":"16.20"},{"time":"2018-06-14T03:00:00+08:00","text":"晴","code":"1","temperature":"19","humidity":"88","wind_direction":"西北","wind_speed":"16.20"},{"time":"2018-06-14T04:00:00+08:00","text":"晴","code":"1","temperature":"19","humidity":"89","wind_direction":"西北","wind_speed":"16.20"},{"time":"2018-06-14T05:00:00+08:00","text":"晴","code":"0","temperature":"18","humidity":"90","wind_direction":"西北","wind_speed":"16.20"},{"time":"2018-06-14T06:00:00+08:00","text":"晴","code":"0","temperature":"20","humidity":"83","wind_direction":"西北","wind_speed":"14.40"},{"time":"2018-06-14T07:00:00+08:00","text":"晴","code":"0","temperature":"23","humidity":"76","wind_direction":"西北","wind_speed":"12.96"},{"time":"2018-06-14T08:00:00+08:00","text":"晴","code":"0","temperature":"25","humidity":"69","wind_direction":"西北","wind_speed":"11.16"}]
         */

        private LocationBean location;
        private List<HourlyBean> hourly;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
        }

        public static class LocationBean {
            /**
             * id : WX4FBXXFKE4F
             * name : 北京
             * country : CN
             * path : 北京,北京,中国
             * timezone : Asia/Shanghai
             * timezone_offset : +08:00
             */

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
        }

        public static class HourlyBean {
            /**
             * time : 2018-06-13T09:00:00+08:00
             * text : 雷阵雨
             * code : 11
             * temperature : 24
             * humidity : 74
             * wind_direction : 东北
             * wind_speed : 14.04
             */

            private String time;
            private String text;
            private String code;
            private String temperature;
            private String humidity;
            private String wind_direction;
            private String wind_speed;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

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

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_speed() {
                return wind_speed;
            }

            public void setWind_speed(String wind_speed) {
                this.wind_speed = wind_speed;
            }
        }
    }
}
