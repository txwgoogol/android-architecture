package com.example.android.architecture.blueprints.todoapp.data.air;

import java.util.List;

/**
 * 空气质量实况城市排行（付费接口）
 */
public class AirRanking {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * location : {"id":"W7YGK0CKZKF9","name":"茂名","country":"CN","path":"茂名,茂名,广东,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"}
         * aqi : 8
         */

        private LocationBean location;
        private String aqi;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public static class LocationBean {
            /**
             * id : W7YGK0CKZKF9
             * name : 茂名
             * country : CN
             * path : 茂名,茂名,广东,中国
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
    }
}
