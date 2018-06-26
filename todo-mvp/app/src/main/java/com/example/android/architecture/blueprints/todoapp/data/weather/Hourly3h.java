package com.example.android.architecture.blueprints.todoapp.data.weather;

import java.util.List;

/**
 * 15天逐3小时精细化天气预报（付费接口）
 */
public class Hourly3h {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * ic_location : {"id":"WX4FBXXFKE4F","name":"北京","country":"CN","path":"北京,北京","timezone":"Asia/Shanghai","timezone_offset":"+08:00"}
         * data : [{"time":"2018-06-13T08:00:00+08:00","code":"13","temperature":"21.4","max":"21.4","min":"19.1","humidity":"77","precip":"0.20","wind_speed":"12.96","wind_scale":"3","wind_direction_degree":"45","wind_direction":"东北","clouds":"88.3","feels_like":"21.61","text":"小雨"},{"time":"2018-06-13T11:00:00+08:00","code":"11","temperature":"27.6","max":"27.6","min":"19.6","humidity":"69","precip":"0.90","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"45","wind_direction":"东北","clouds":"48.1","feels_like":"29.80","text":"雷阵雨"},{"time":"2018-06-13T14:00:00+08:00","code":"11","temperature":"27.8","max":"27.8","min":"20.2","humidity":"63","precip":"0.40","wind_speed":"13.32","wind_scale":"3","wind_direction_degree":"45","wind_direction":"东北","clouds":"36.7","feels_like":"29.48","text":"雷阵雨"},{"time":"2018-06-13T17:00:00+08:00","code":"11","temperature":"25.7","max":"27.4","min":"25.6","humidity":"63","precip":"0.10","wind_speed":"11.88","wind_scale":"2","wind_direction_degree":"45","wind_direction":"东北","clouds":"45.0","feels_like":"25.97","text":"雷阵雨"},{"time":"2018-06-13T20:00:00+08:00","code":"11","temperature":"23.2","max":"28.0","min":"22.2","humidity":"74","precip":"0.10","wind_speed":"11.16","wind_scale":"2","wind_direction_degree":"45","wind_direction":"东北","clouds":"3.6","feels_like":"23.51","text":"雷阵雨"},{"time":"2018-06-13T23:00:00+08:00","code":"4","temperature":"20.7","max":"22.7","min":"20.4","humidity":"82","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"315","wind_direction":"西北","clouds":"10.1","feels_like":"20.97","text":"多云"},{"time":"2018-06-14T02:00:00+08:00","code":"4","temperature":"19.6","max":"21.0","min":"18.8","humidity":"88","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"315","wind_direction":"西北","clouds":"10.1","feels_like":"19.91","text":"多云"},{"time":"2018-06-14T05:00:00+08:00","code":"4","temperature":"18.2","max":"19.1","min":"18.0","humidity":"90","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"315","wind_direction":"西北","clouds":"15.9","feels_like":"18.43","text":"多云"},{"time":"2018-06-14T08:00:00+08:00","code":"4","temperature":"24.6","max":"24.6","min":"18.0","humidity":"69","precip":"0.00","wind_speed":"11.16","wind_scale":"2","wind_direction_degree":"315","wind_direction":"西北","clouds":"10.1","feels_like":"24.92","text":"多云"},{"time":"2018-06-14T11:00:00+08:00","code":"4","temperature":"26.9","max":"27.1","min":"22.1","humidity":"40","precip":"0.00","wind_speed":"6.12","wind_scale":"2","wind_direction_degree":"164","wind_direction":"南","clouds":"12.7","feels_like":"26.79","text":"多云"},{"time":"2018-06-14T14:00:00+08:00","code":"4","temperature":"30.0","max":"30.0","min":"26.6","humidity":"44","precip":"0.00","wind_speed":"15.48","wind_scale":"3","wind_direction_degree":"194","wind_direction":"南","clouds":"31.2","feels_like":"30.18","text":"多云"},{"time":"2018-06-14T17:00:00+08:00","code":"4","temperature":"30.8","max":"30.8","min":"28.4","humidity":"40","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"180","wind_direction":"南","clouds":"44.0","feels_like":"30.66","text":"多云"},{"time":"2018-06-14T20:00:00+08:00","code":"4","temperature":"26.5","max":"31.0","min":"26.2","humidity":"56","precip":"0.00","wind_speed":"10.80","wind_scale":"2","wind_direction_degree":"180","wind_direction":"南","clouds":"25.7","feels_like":"26.67","text":"多云"},{"time":"2018-06-14T23:00:00+08:00","code":"4","temperature":"24.4","max":"26.4","min":"23.8","humidity":"61","precip":"0.00","wind_speed":"12.24","wind_scale":"3","wind_direction_degree":"180","wind_direction":"南","clouds":"10.1","feels_like":"24.49","text":"多云"},{"time":"2018-06-15T02:00:00+08:00","code":"4","temperature":"22.6","max":"24.0","min":"21.8","humidity":"69","precip":"0.00","wind_speed":"10.08","wind_scale":"2","wind_direction_degree":"180","wind_direction":"南","clouds":"10.1","feels_like":"22.72","text":"多云"},{"time":"2018-06-15T05:00:00+08:00","code":"4","temperature":"20.2","max":"22.2","min":"20.0","humidity":"73","precip":"0.00","wind_speed":"12.24","wind_scale":"3","wind_direction_degree":"180","wind_direction":"南","clouds":"10.1","feels_like":"20.18","text":"多云"},{"time":"2018-06-15T08:00:00+08:00","code":"4","temperature":"23.8","max":"24.3","min":"20.0","humidity":"60","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"180","wind_direction":"南","clouds":"10.1","feels_like":"23.80","text":"多云"},{"time":"2018-06-15T11:00:00+08:00","code":"4","temperature":"27.5","max":"28.1","min":"23.7","humidity":"42","precip":"0.00","wind_speed":"10.44","wind_scale":"2","wind_direction_degree":"179","wind_direction":"南","clouds":"10.1","feels_like":"27.37","text":"多云"},{"time":"2018-06-15T14:00:00+08:00","code":"4","temperature":"32.8","max":"32.8","min":"27.5","humidity":"49","precip":"0.00","wind_speed":"15.48","wind_scale":"3","wind_direction_degree":"198","wind_direction":"南","clouds":"42.5","feels_like":"35.62","text":"多云"},{"time":"2018-06-15T17:00:00+08:00","code":"4","temperature":"32.2","max":"32.3","min":"29.9","humidity":"44","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"192","wind_direction":"南","clouds":"53.3","feels_like":"33.36","text":"多云"},{"time":"2018-06-15T20:00:00+08:00","code":"4","temperature":"29.7","max":"33.0","min":"27.9","humidity":"55","precip":"0.00","wind_speed":"13.68","wind_scale":"3","wind_direction_degree":"180","wind_direction":"南","clouds":"79.9","feels_like":"31.39","text":"多云"},{"time":"2018-06-15T23:00:00+08:00","code":"4","temperature":"26.0","max":"29.1","min":"24.6","humidity":"62","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"180","wind_direction":"南","clouds":"79.9","feels_like":"26.27","text":"多云"},{"time":"2018-06-16T02:00:00+08:00","code":"4","temperature":"22.9","max":"29.1","min":"22.9","humidity":"72","precip":"0.00","wind_speed":"13.32","wind_scale":"3","wind_direction_degree":"198","wind_direction":"南","clouds":"79.9","feels_like":"23.13","text":"多云"},{"time":"2018-06-16T05:00:00+08:00","code":"4","temperature":"22.2","max":"24.8","min":"22.0","humidity":"76","precip":"0.00","wind_speed":"7.56","wind_scale":"2","wind_direction_degree":"180","wind_direction":"南","clouds":"79.9","feels_like":"22.46","text":"多云"},{"time":"2018-06-16T08:00:00+08:00","code":"4","temperature":"23.3","max":"23.4","min":"22.0","humidity":"61","precip":"0.00","wind_speed":"8.28","wind_scale":"2","wind_direction_degree":"180","wind_direction":"南","clouds":"79.9","feels_like":"23.28","text":"多云"},{"time":"2018-06-16T14:00:00+08:00","code":"4","temperature":"33.8","max":"33.8","min":"22.3","humidity":"48","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"164","wind_direction":"南","clouds":"79.9","feels_like":"37.32","text":"多云"},{"time":"2018-06-16T20:00:00+08:00","code":"4","temperature":"33.5","max":"34.0","min":"27.9","humidity":"63","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"189","wind_direction":"南","clouds":"79.9","feels_like":"42.02","text":"多云"},{"time":"2018-06-17T02:00:00+08:00","code":"11","temperature":"23.0","max":"29.0","min":"23.0","humidity":"83","precip":"0.30","wind_speed":"10.80","wind_scale":"2","wind_direction_degree":"221","wind_direction":"西南","clouds":"84.1","feels_like":"23.52","text":"雷阵雨"},{"time":"2018-06-17T08:00:00+08:00","code":"11","temperature":"24.3","max":"24.3","min":"21.0","humidity":"75","precip":"3.60","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"225","wind_direction":"西南","clouds":"100.0","feels_like":"24.74","text":"雷阵雨"},{"time":"2018-06-17T14:00:00+08:00","code":"11","temperature":"29.8","max":"29.8","min":"22.4","humidity":"61","precip":"5.30","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"30","wind_direction":"东北","clouds":"70.0","feels_like":"32.65","text":"雷阵雨"},{"time":"2018-06-17T20:00:00+08:00","code":"4","temperature":"25.3","max":"30.0","min":"25.3","humidity":"61","precip":"0.00","wind_speed":"13.32","wind_scale":"3","wind_direction_degree":"24","wind_direction":"东北","clouds":"0.0","feels_like":"25.48","text":"多云"},{"time":"2018-06-18T02:00:00+08:00","code":"4","temperature":"21.9","max":"26.1","min":"21.9","humidity":"81","precip":"0.00","wind_speed":"13.68","wind_scale":"3","wind_direction_degree":"135","wind_direction":"东南","clouds":"10.1","feels_like":"22.26","text":"多云"},{"time":"2018-06-18T08:00:00+08:00","code":"4","temperature":"24.2","max":"24.2","min":"20.0","humidity":"56","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"135","wind_direction":"东南","clouds":"31.8","feels_like":"24.14","text":"多云"},{"time":"2018-06-18T14:00:00+08:00","code":"0","temperature":"30.2","max":"30.2","min":"21.9","humidity":"52","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"135","wind_direction":"东南","clouds":"10.0","feels_like":"31.69","text":"晴"},{"time":"2018-06-18T20:00:00+08:00","code":"0","temperature":"25.7","max":"31.0","min":"25.7","humidity":"70","precip":"0.00","wind_speed":"13.68","wind_scale":"3","wind_direction_degree":"135","wind_direction":"东南","clouds":"10.0","feels_like":"26.15","text":"晴"},{"time":"2018-06-19T02:00:00+08:00","code":"4","temperature":"20.2","max":"26.4","min":"20.2","humidity":"82","precip":"0.00","wind_speed":"6.12","wind_scale":"2","wind_direction_degree":"180","wind_direction":"南","clouds":"37.4","feels_like":"20.42","text":"多云"},{"time":"2018-06-19T08:00:00+08:00","code":"4","temperature":"25.0","max":"25.0","min":"20.0","humidity":"65","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"180","wind_direction":"南","clouds":"10.1","feels_like":"25.25","text":"多云"},{"time":"2018-06-19T14:00:00+08:00","code":"4","temperature":"28.2","max":"28.2","min":"23.4","humidity":"46","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"135","wind_direction":"东南","clouds":"10.1","feels_like":"28.31","text":"多云"},{"time":"2018-06-19T20:00:00+08:00","code":"4","temperature":"26.7","max":"30.0","min":"25.6","humidity":"56","precip":"0.00","wind_speed":"15.12","wind_scale":"3","wind_direction_degree":"135","wind_direction":"东南","clouds":"10.1","feels_like":"27.48","text":"多云"},{"time":"2018-06-20T02:00:00+08:00","code":"4","temperature":"22.6","max":"26.1","min":"22.5","humidity":"76","precip":"0.00","wind_speed":"16.20","wind_scale":"3","wind_direction_degree":"135","wind_direction":"东南","clouds":"74.2","feels_like":"22.90","text":"多云"},{"time":"2018-06-20T08:00:00+08:00","code":"4","temperature":"24.7","max":"24.7","min":"21.0","humidity":"59","precip":"0.00","wind_speed":"13.68","wind_scale":"3","wind_direction_degree":"135","wind_direction":"东南","clouds":"10.1","feels_like":"24.77","text":"多云"},{"time":"2018-06-20T20:00:00+08:00","code":"4","temperature":"29.2","max":"35.8","min":"25.3","humidity":"38","precip":"0.00","wind_speed":"13.68","wind_scale":"3","wind_direction_degree":"222","wind_direction":"西南","clouds":"57.0","feels_like":"28.63","text":"多云"},{"time":"2018-06-21T08:00:00+08:00","code":"0","temperature":"26.4","max":"29.9","min":"22.3","humidity":"60","precip":"0.00","wind_speed":"6.48","wind_scale":"2","wind_direction_degree":"255","wind_direction":"西","clouds":"0.0","feels_like":"26.66","text":"晴"},{"time":"2018-06-21T20:00:00+08:00","code":"4","temperature":"29.7","max":"36.0","min":"26.4","humidity":"56","precip":"0.00","wind_speed":"11.88","wind_scale":"2","wind_direction_degree":"195","wind_direction":"南","clouds":"69.0","feels_like":"31.56","text":"多云"},{"time":"2018-06-22T08:00:00+08:00","code":"4","temperature":"26.1","max":"29.9","min":"22.3","humidity":"70","precip":"0.00","wind_speed":"7.92","wind_scale":"2","wind_direction_degree":"101","wind_direction":"东","clouds":"47.1","feels_like":"26.59","text":"多云"},{"time":"2018-06-22T20:00:00+08:00","code":"13","temperature":"28.7","max":"36.3","min":"26.1","humidity":"74","precip":"1.00","wind_speed":"8.64","wind_scale":"2","wind_direction_degree":"129","wind_direction":"东南","clouds":"85.7","feels_like":"32.78","text":"小雨"},{"time":"2018-06-23T08:00:00+08:00","code":"13","temperature":"28.6","max":"30.9","min":"24.0","humidity":"85","precip":"0.20","wind_speed":"5.76","wind_scale":"1","wind_direction_degree":"37","wind_direction":"东北","clouds":"52.7","feels_like":"34.64","text":"小雨"},{"time":"2018-06-23T20:00:00+08:00","code":"9","temperature":"31.6","max":"38.6","min":"28.6","humidity":"15","precip":"0.00","wind_speed":"12.24","wind_scale":"3","wind_direction_degree":"142","wind_direction":"东南","clouds":"92.7","feels_like":"29.45","text":"阴"},{"time":"2018-06-24T08:00:00+08:00","code":"13","temperature":"27.0","max":"31.4","min":"24.7","humidity":"33","precip":"2.40","wind_speed":"7.56","wind_scale":"2","wind_direction_degree":"11","wind_direction":"北","clouds":"92.5","feels_like":"26.54","text":"小雨"},{"time":"2018-06-24T20:00:00+08:00","code":"13","temperature":"30.9","max":"37.7","min":"27.4","humidity":"63","precip":"5.90","wind_speed":"7.92","wind_scale":"2","wind_direction_degree":"152","wind_direction":"东南","clouds":"78.0","feels_like":"35.39","text":"小雨"},{"time":"2018-06-25T08:00:00+08:00","code":"13","temperature":"27.9","max":"30.9","min":"22.9","humidity":"46","precip":"0.50","wind_speed":"3.96","wind_scale":"1","wind_direction_degree":"92","wind_direction":"东","clouds":"9.4","feels_like":"28.01","text":"小雨"},{"time":"2018-06-25T20:00:00+08:00","code":"0","temperature":"32.9","max":"38.6","min":"27.9","humidity":"41","precip":"0.00","wind_speed":"11.52","wind_scale":"2","wind_direction_degree":"135","wind_direction":"东南","clouds":"10.6","feels_like":"33.84","text":"晴"},{"time":"2018-06-26T08:00:00+08:00","code":"4","temperature":"27.5","max":"32.8","min":"23.4","humidity":"49","precip":"0.00","wind_speed":"10.08","wind_scale":"2","wind_direction_degree":"79","wind_direction":"东","clouds":"22.9","feels_like":"27.84","text":"多云"},{"time":"2018-06-26T20:00:00+08:00","code":"4","temperature":"32.5","max":"38.6","min":"27.6","humidity":"37","precip":"0.00","wind_speed":"19.80","wind_scale":"3","wind_direction_degree":"128","wind_direction":"东南","clouds":"68.4","feels_like":"32.46","text":"多云"},{"time":"2018-06-27T08:00:00+08:00","code":"0","temperature":"25.1","max":"32.1","min":"22.8","humidity":"46","precip":"0.00","wind_speed":"9.00","wind_scale":"2","wind_direction_degree":"57","wind_direction":"东北","clouds":"1.8","feels_like":"24.87","text":"晴"},{"time":"2018-06-27T20:00:00+08:00","code":"4","temperature":"29.9","max":"33.8","min":"25.2","humidity":"22","precip":"0.00","wind_speed":"8.64","wind_scale":"2","wind_direction_degree":"136","wind_direction":"东南","clouds":"44.0","feels_like":"28.23","text":"多云"},{"time":"2018-06-28T08:00:00+08:00","code":"0","temperature":"26.8","max":"29.9","min":"22.3","humidity":"37","precip":"0.00","wind_speed":"4.68","wind_scale":"1","wind_direction_degree":"57","wind_direction":"东北","clouds":"12.0","feels_like":"26.58","text":"晴"}]
         * last_update : 2018-06-13T08:03:24+08:00
         */

        private LocationBean location;
        private String last_update;
        private List<DataBean> data;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class LocationBean {
            /**
             * id : WX4FBXXFKE4F
             * name : 北京
             * country : CN
             * path : 北京,北京
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

        public static class DataBean {
            /**
             * time : 2018-06-13T08:00:00+08:00
             * code : 13
             * temperature : 21.4
             * max : 21.4
             * min : 19.1
             * humidity : 77
             * precip : 0.20
             * wind_speed : 12.96
             * wind_scale : 3
             * wind_direction_degree : 45
             * wind_direction : 东北
             * clouds : 88.3
             * feels_like : 21.61
             * text : 小雨
             */

            private String time;
            private String code;
            private String temperature;
            private String max;
            private String min;
            private String humidity;
            private String precip;
            private String wind_speed;
            private String wind_scale;
            private String wind_direction_degree;
            private String wind_direction;
            private String clouds;
            private String feels_like;
            private String text;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
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

            public String getMax() {
                return max;
            }

            public void setMax(String max) {
                this.max = max;
            }

            public String getMin() {
                return min;
            }

            public void setMin(String min) {
                this.min = min;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getPrecip() {
                return precip;
            }

            public void setPrecip(String precip) {
                this.precip = precip;
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

            public String getClouds() {
                return clouds;
            }

            public void setClouds(String clouds) {
                this.clouds = clouds;
            }

            public String getFeels_like() {
                return feels_like;
            }

            public void setFeels_like(String feels_like) {
                this.feels_like = feels_like;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}
