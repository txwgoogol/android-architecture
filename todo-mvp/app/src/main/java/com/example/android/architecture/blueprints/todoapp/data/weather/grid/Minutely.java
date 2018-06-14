package com.example.android.architecture.blueprints.todoapp.data.weather.grid;

import java.util.List;

/**
 * 分钟级降水预报（付费接口）
 */
public class Minutely {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * location : {"longitude":"116.359805","latitude":"39.865927"}
         * text : 雨势渐大，15分钟后转为大雨，直到1小时40分钟后雨渐停
         * precipitation : [2.28,1.846,1.43,1.052,0.729,0.48,0.329,0.316,0.486,0.886,1.56,2.516,3.609,4.656,5.474,5.88,5.751,5.207,4.427,3.591,2.88,2.43,2.208,2.14,2.149,2.16,2.122,2.081,2.107,2.27,2.64,3.249,3.977,4.664,5.151,5.28,4.948,4.278,3.451,2.645,2.04,1.771,1.789,2.003,2.317,2.64,2.903,3.135,3.392,3.729,4.2,4.838,5.585,6.361,7.086,7.68,8.083,8.309,8.394,8.373,8.28,8.139,7.931,7.625,7.191,6.6,5.841,4.985,4.126,3.353,2.76,2.412,2.275,2.288,2.39,2.52,2.629,2.713,2.779,2.832,2.88,2.931,3,3.104,3.258,3.48,3.771,4.073,4.314,4.421,4.32,3.966,3.416,2.755,2.069,1.44,0.937,0.559,0.289,0.109,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
         * last_update : 2018-06-13T12:30:00+08:00
         */

        private LocationBean location;
        private String text;
        private String last_update;
        private List<Double> precipitation;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }

        public List<Double> getPrecipitation() {
            return precipitation;
        }

        public void setPrecipitation(List<Double> precipitation) {
            this.precipitation = precipitation;
        }

        public static class LocationBean {
            /**
             * longitude : 116.359805
             * latitude : 39.865927
             */

            private String longitude;
            private String latitude;

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }
        }
    }
}
