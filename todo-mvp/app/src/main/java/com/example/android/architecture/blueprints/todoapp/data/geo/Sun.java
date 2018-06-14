package com.example.android.architecture.blueprints.todoapp.data.geo;

import java.util.List;

/**
 * 日出日落（付费接口）
 */
public class Sun {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * location : {"id":"WX4FBXXFKE4F","name":"北京","country":"CN","path":"北京,北京,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"}
         * sun : [{"date":"2018-06-13","sunrise":"04:46","sunset":"19:44"},{"date":"2018-06-14","sunrise":"04:46","sunset":"19:44"},{"date":"2018-06-15","sunrise":"04:46","sunset":"19:45"},{"date":"2018-06-16","sunrise":"04:46","sunset":"19:45"},{"date":"2018-06-17","sunrise":"04:46","sunset":"19:45"},{"date":"2018-06-18","sunrise":"04:46","sunset":"19:46"},{"date":"2018-06-19","sunrise":"04:46","sunset":"19:46"}]
         */

        private LocationBean location;
        private List<SunBean> sun;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public List<SunBean> getSun() {
            return sun;
        }

        public void setSun(List<SunBean> sun) {
            this.sun = sun;
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

        public static class SunBean {
            /**
             * date : 2018-06-13
             * sunrise : 04:46
             * sunset : 19:44
             */

            private String date;
            private String sunrise;
            private String sunset;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }
        }
    }
}
