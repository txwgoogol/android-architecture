package com.example.android.architecture.blueprints.todoapp.data.air;

import java.util.List;

/**
 * 过去24小时历史空气质量（付费接口）
 */
public class AirHourlyHistory {

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
         * hourly_history : [{"city":{"aqi":"120","pm25":"91","pm10":"0","so2":"5","no2":"35","co":"1.517","o3":"80","last_update":"2018-06-13T08:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"125","pm25":"95","pm10":"0","so2":"4","no2":"41","co":"1.575","o3":"55","last_update":"2018-06-13T07:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"118","pm25":"89","pm10":"63","so2":"3","no2":"37","co":"1.333","o3":"52","last_update":"2018-06-13T06:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"108","pm25":"81","pm10":"0","so2":"2","no2":"33","co":"1.092","o3":"66","last_update":"2018-06-13T05:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"100","pm25":"75","pm10":"52","so2":"2","no2":"36","co":"0.850","o3":"68","last_update":"2018-06-13T04:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"99","pm25":"74","pm10":"0","so2":"2","no2":"36","co":"0.840","o3":"71","last_update":"2018-06-13T03:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"94","pm25":"70","pm10":"63","so2":"1","no2":"42","co":"0.910","o3":"66","last_update":"2018-06-13T02:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"92","pm25":"68","pm10":"86","so2":"2","no2":"42","co":"0.900","o3":"82","last_update":"2018-06-13T01:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"94","pm25":"70","pm10":"83","so2":"2","no2":"46","co":"1.008","o3":"87","last_update":"2018-06-13T00:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"92","pm25":"68","pm10":"66","so2":"2","no2":"51","co":"1.042","o3":"82","last_update":"2018-06-12T23:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"85","pm25":"63","pm10":"82","so2":"2","no2":"53","co":"1.000","o3":"75","last_update":"2018-06-12T22:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"79","pm25":"58","pm10":"77","so2":"2","no2":"44","co":"0.927","o3":"96","last_update":"2018-06-12T21:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"77","pm25":"56","pm10":"66","so2":"2","no2":"45","co":"0.918","o3":"98","last_update":"2018-06-12T20:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"70","pm25":"48","pm10":"89","so2":"2","no2":"36","co":"0.873","o3":"119","last_update":"2018-06-12T19:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"82","pm25":"60","pm10":"87","so2":"2","no2":"30","co":"0.830","o3":"155","last_update":"2018-06-12T18:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"100","pm25":"75","pm10":"107","so2":"2","no2":"31","co":"0.918","o3":"181","last_update":"2018-06-12T17:00:00+08:00","quality":"良"},"stations":null},{"city":{"aqi":"115","pm25":"68","pm10":"83","so2":"4","no2":"21","co":"0.827","o3":"230","last_update":"2018-06-12T16:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"119","pm25":"69","pm10":"70","so2":"3","no2":"20","co":"0.864","o3":"237","last_update":"2018-06-12T15:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"120","pm25":"74","pm10":"83","so2":"4","no2":"20","co":"0.908","o3":"240","last_update":"2018-06-12T14:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"113","pm25":"82","pm10":"74","so2":"4","no2":"24","co":"0.982","o3":"225","last_update":"2018-06-12T13:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"135","pm25":"103","pm10":"116","so2":"4","no2":"30","co":"1.042","o3":"194","last_update":"2018-06-12T12:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"145","pm25":"111","pm10":"121","so2":"3","no2":"36","co":"1.067","o3":"157","last_update":"2018-06-12T11:00:00+08:00","quality":"轻度污染"},"stations":null},{"city":{"aqi":"152","pm25":"116","pm10":"121","so2":"3","no2":"42","co":"1.067","o3":"118","last_update":"2018-06-12T10:00:00+08:00","quality":"中度污染"},"stations":null},{"city":{"aqi":"149","pm25":"114","pm10":"130","so2":"3","no2":"47","co":"1.033","o3":"84","last_update":"2018-06-12T09:00:00+08:00","quality":"轻度污染"},"stations":null}]
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

        public static class HourlyHistoryBean {
            /**
             * city : {"aqi":"120","pm25":"91","pm10":"0","so2":"5","no2":"35","co":"1.517","o3":"80","last_update":"2018-06-13T08:00:00+08:00","quality":"轻度污染"}
             * stations : null
             */

            private CityBean city;
            private Object stations;

            public CityBean getCity() {
                return city;
            }

            public void setCity(CityBean city) {
                this.city = city;
            }

            public Object getStations() {
                return stations;
            }

            public void setStations(Object stations) {
                this.stations = stations;
            }

            public static class CityBean {
                /**
                 * aqi : 120
                 * pm25 : 91
                 * pm10 : 0
                 * so2 : 5
                 * no2 : 35
                 * co : 1.517
                 * o3 : 80
                 * last_update : 2018-06-13T08:00:00+08:00
                 * quality : 轻度污染
                 */

                private String aqi;
                private String pm25;
                private String pm10;
                private String so2;
                private String no2;
                private String co;
                private String o3;
                private String last_update;
                private String quality;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getLast_update() {
                    return last_update;
                }

                public void setLast_update(String last_update) {
                    this.last_update = last_update;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }
            }
        }
    }
}
