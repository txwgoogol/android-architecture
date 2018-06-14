package com.example.android.architecture.blueprints.todoapp.data.weather;

import java.util.List;

/**
 * 过去24小时历史天气（付费接口）
 */
public class HourlyHistory {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * location : {"id":"C23NB62W20TF","name":"西雅图","country":"US","path":"西雅图,华盛顿州,美国","timezone":"America/Los_Angeles","timezone_offset":"-07:00"}
         * hourly_history : [{"text":"小雨","code":"13","temperature":"17","feels_like":"","pressure":"1014","humidity":"67","visibility":"","wind_direction":"北","wind_direction_degree":"11.0001","wind_speed":"4.72","wind_scale":"1","clouds":"75","dew_point":"","last_update":"2018-06-13T11:06:15+08:00"},{"text":"阴","code":"9","temperature":"17","feels_like":"","pressure":"1014","humidity":"51","visibility":"","wind_direction":"西北","wind_direction_degree":"300","wind_speed":"11.16","wind_scale":"2","clouds":"90","dew_point":"","last_update":"2018-06-13T10:12:20+08:00"},{"text":"阴","code":"9","temperature":"18","feels_like":"","pressure":"1014","humidity":"48","visibility":"","wind_direction":"西北","wind_direction_degree":"320","wind_speed":"14.76","wind_scale":"3","clouds":"90","dew_point":"","last_update":"2018-06-13T09:10:17+08:00"},{"text":"阴","code":"9","temperature":"19","feels_like":"","pressure":"1015","humidity":"52","visibility":"","wind_direction":"西北","wind_direction_degree":"300","wind_speed":"12.96","wind_scale":"3","clouds":"90","dew_point":"","last_update":"2018-06-13T08:15:48+08:00"},{"text":"阴","code":"9","temperature":"19","feels_like":"","pressure":"1015","humidity":"52","visibility":"","wind_direction":"西北","wind_direction_degree":"310","wind_speed":"20.52","wind_scale":"4","clouds":"90","dew_point":"","last_update":"2018-06-13T07:08:16+08:00"},{"text":"阴","code":"9","temperature":"19","feels_like":"","pressure":"1016","humidity":"48","visibility":"","wind_direction":"西北","wind_direction_degree":"340","wind_speed":"11.16","wind_scale":"2","clouds":"90","dew_point":"","last_update":"2018-06-13T06:12:17+08:00"},{"text":"阴","code":"9","temperature":"19","feels_like":"","pressure":"1017","humidity":"45","visibility":"","wind_direction":"西北","wind_direction_degree":"300","wind_speed":"14.76","wind_scale":"3","clouds":"90","dew_point":"","last_update":"2018-06-13T05:09:58+08:00"},{"text":"阴","code":"9","temperature":"19","feels_like":"","pressure":"1017","humidity":"42","visibility":"","wind_direction":"西北","wind_direction_degree":"310","wind_speed":"12.96","wind_scale":"3","clouds":"90","dew_point":"","last_update":"2018-06-13T04:14:53+08:00"},{"text":"阴","code":"9","temperature":"19","feels_like":"","pressure":"1018","humidity":"45","visibility":"","wind_direction":"西北","wind_direction_degree":"320","wind_speed":"20.52","wind_scale":"4","clouds":"90","dew_point":"","last_update":"2018-06-13T03:12:32+08:00"},{"text":"晴","code":"0","temperature":"18","feels_like":"","pressure":"1018","humidity":"48","visibility":"","wind_direction":"西北","wind_direction_degree":"300","wind_speed":"9.36","wind_scale":"2","clouds":"1","dew_point":"","last_update":"2018-06-13T02:17:29+08:00"},{"text":"晴","code":"0","temperature":"16","feels_like":"","pressure":"1019","humidity":"48","visibility":"","wind_direction":"北","wind_direction_degree":"0","wind_speed":"7.56","wind_scale":"2","clouds":"1","dew_point":"","last_update":"2018-06-13T01:11:58+08:00"},{"text":"晴","code":"0","temperature":"14","feels_like":"","pressure":"1019","humidity":"58","visibility":"","wind_direction":"北","wind_direction_degree":"350","wind_speed":"7.56","wind_scale":"2","clouds":"1","dew_point":"","last_update":"2018-06-13T00:16:02+08:00"},{"text":"小雨","code":"13","temperature":"12","feels_like":"","pressure":"1020","humidity":"62","visibility":"","wind_direction":"东北","wind_direction_degree":"50","wind_speed":"7.56","wind_scale":"2","clouds":"40","dew_point":"","last_update":"2018-06-12T23:09:17+08:00"},{"text":"多云","code":"4","temperature":"11","feels_like":"","pressure":"1020","humidity":"71","visibility":"","wind_direction":"北","wind_direction_degree":"0","wind_speed":"5.4","wind_scale":"1","clouds":"75","dew_point":"","last_update":"2018-06-12T22:18:26+08:00"},{"text":"小雨","code":"13","temperature":"8","feels_like":"","pressure":"1021","humidity":"76","visibility":"","wind_direction":"北","wind_direction_degree":"6.00122","wind_speed":"7.78","wind_scale":"2","clouds":"1","dew_point":"","last_update":"2018-06-12T21:13:05+08:00"},{"text":"小雨","code":"13","temperature":"8","feels_like":"","pressure":"1021","humidity":"71","visibility":"","wind_direction":"北","wind_direction_degree":"6.00122","wind_speed":"7.78","wind_scale":"2","clouds":"1","dew_point":"","last_update":"2018-06-12T20:18:25+08:00"},{"text":"小雨","code":"13","temperature":"8","feels_like":"","pressure":"1022","humidity":"66","visibility":"","wind_direction":"北","wind_direction_degree":"6.00122","wind_speed":"7.78","wind_scale":"2","clouds":"1","dew_point":"","last_update":"2018-06-12T19:12:34+08:00"},{"text":"小雨","code":"13","temperature":"9","feels_like":"","pressure":"1022","humidity":"71","visibility":"","wind_direction":"东北","wind_direction_degree":"22.0046","wind_speed":"4.14","wind_scale":"1","clouds":"1","dew_point":"","last_update":"2018-06-12T18:18:52+08:00"},{"text":"晴","code":"0","temperature":"10","feels_like":"","pressure":"1022","humidity":"66","visibility":"","wind_direction":"西北","wind_direction_degree":"330","wind_speed":"5.4","wind_scale":"1","clouds":"1","dew_point":"","last_update":"2018-06-12T17:12:52+08:00"},{"text":"晴","code":"0","temperature":"11","feels_like":"","pressure":"1022","humidity":"100","visibility":"","wind_direction":"东北","wind_direction_degree":"22.0046","wind_speed":"4.14","wind_scale":"1","clouds":"1","dew_point":"","last_update":"2018-06-12T16:13:42+08:00"},{"text":"晴","code":"0","temperature":"12","feels_like":"","pressure":"1022","humidity":"62","visibility":"","wind_direction":"东北","wind_direction_degree":"67.5009","wind_speed":"6.01","wind_scale":"2","clouds":"1","dew_point":"","last_update":"2018-06-12T15:16:43+08:00"},{"text":"晴","code":"0","temperature":"13","feels_like":"","pressure":"1022","humidity":"58","visibility":"","wind_direction":"东北","wind_direction_degree":"38.0024","wind_speed":"6.3","wind_scale":"2","clouds":"1","dew_point":"","last_update":"2018-06-12T14:15:43+08:00"},{"text":"晴","code":"2","temperature":"16","feels_like":"","pressure":"1022","humidity":"39","visibility":"","wind_direction":"北","wind_direction_degree":"0","wind_speed":"7.56","wind_scale":"2","clouds":"20","dew_point":"","last_update":"2018-06-12T13:06:20+08:00"},{"text":"晴","code":"2","temperature":"18","feels_like":"","pressure":"1022","humidity":"37","visibility":"","wind_direction":"西北","wind_direction_degree":"310","wind_speed":"7.56","wind_scale":"2","clouds":"20","dew_point":"","last_update":"2018-06-12T12:06:00+08:00"}]
         */

        private LocationBean location;
        private List<HourlyHistoryBean> hourly_history;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public List<HourlyHistoryBean> getHourly_history() {
            return hourly_history;
        }

        public void setHourly_history(List<HourlyHistoryBean> hourly_history) {
            this.hourly_history = hourly_history;
        }

        public static class LocationBean {
            /**
             * id : C23NB62W20TF
             * name : 西雅图
             * country : US
             * path : 西雅图,华盛顿州,美国
             * timezone : America/Los_Angeles
             * timezone_offset : -07:00
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

        public static class HourlyHistoryBean {
            /**
             * text : 小雨
             * code : 13
             * temperature : 17
             * feels_like :
             * pressure : 1014
             * humidity : 67
             * visibility :
             * wind_direction : 北
             * wind_direction_degree : 11.0001
             * wind_speed : 4.72
             * wind_scale : 1
             * clouds : 75
             * dew_point :
             * last_update : 2018-06-13T11:06:15+08:00
             */

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
            private String last_update;

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

            public String getLast_update() {
                return last_update;
            }

            public void setLast_update(String last_update) {
                this.last_update = last_update;
            }
        }
    }
}