package com.example.android.architecture.blueprints.todoapp.data.air;

import java.util.List;

/**
 * 空气质量实况（付费接口）
 */
public class AirNow {

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
         * air : {"city":{"aqi":"104","pm25":"78","pm10":"80","so2":"6","no2":"30","co":"1.367","o3":"98","primary_pollutant":"PM2.5","last_update":"2018-06-13T09:00:00+08:00","quality":"轻度污染"},"stations":null}
         * last_update : 2018-06-13T09:00:00+08:00
         */

        private LocationBean location;
        private AirBean air;
        private String last_update;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public AirBean getAir() {
            return air;
        }

        public void setAir(AirBean air) {
            this.air = air;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
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

        public static class AirBean {
            /**
             * city : {"aqi":"104","pm25":"78","pm10":"80","so2":"6","no2":"30","co":"1.367","o3":"98","primary_pollutant":"PM2.5","last_update":"2018-06-13T09:00:00+08:00","quality":"轻度污染"}
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
                 * aqi : 104
                 * pm25 : 78
                 * pm10 : 80
                 * so2 : 6
                 * no2 : 30
                 * co : 1.367
                 * o3 : 98
                 * primary_pollutant : PM2.5
                 * last_update : 2018-06-13T09:00:00+08:00
                 * quality : 轻度污染
                 */

                private String aqi;
                private String pm25;
                private String pm10;
                private String so2;
                private String no2;
                private String co;
                private String o3;
                private String primary_pollutant;
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

                public String getPrimary_pollutant() {
                    return primary_pollutant;
                }

                public void setPrimary_pollutant(String primary_pollutant) {
                    this.primary_pollutant = primary_pollutant;
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
