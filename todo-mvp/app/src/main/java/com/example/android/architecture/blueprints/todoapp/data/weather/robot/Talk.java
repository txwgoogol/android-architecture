package com.example.android.architecture.blueprints.todoapp.data.weather.robot;

import java.util.List;

/**
 * 自然语言天气查询（付费接口）
 */
public class Talk {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * query : 北京明天天气怎么样？
         * ic_location : {"id":"WX4FBXXFKE4F","name":"北京","country":"CN","path":"北京,北京,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"}
         * reply : {"type":"WEATHER_FORECAST","plain":"北京明天，周四，多云，18度到31度，天气挺热的，空气质量指数115，轻度污染，注意戴口罩防护。","origin":[{"date":"2018-06-14","text_day":"多云","code_day":"4","text_night":"多云","code_night":"4","high":"31","low":"18","precip":"","wind_direction":"南","wind_direction_degree":"180","wind_speed":"10","wind_scale":"2","air":{"aqi":"115","pm25":"33","pm10":"92","so2":"3","no2":"35","co":"0.733","o3":"176","date":"2018-06-14","quality":"轻度污染"}}]}
         * session : 625aae92-002a-45a5-bde0-ec5990964f4d
         */

        private String query;
        private LocationBean location;
        private ReplyBean reply;
        private String session;

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public ReplyBean getReply() {
            return reply;
        }

        public void setReply(ReplyBean reply) {
            this.reply = reply;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
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

        public static class ReplyBean {
            /**
             * type : WEATHER_FORECAST
             * plain : 北京明天，周四，多云，18度到31度，天气挺热的，空气质量指数115，轻度污染，注意戴口罩防护。
             * origin : [{"date":"2018-06-14","text_day":"多云","code_day":"4","text_night":"多云","code_night":"4","high":"31","low":"18","precip":"","wind_direction":"南","wind_direction_degree":"180","wind_speed":"10","wind_scale":"2","air":{"aqi":"115","pm25":"33","pm10":"92","so2":"3","no2":"35","co":"0.733","o3":"176","date":"2018-06-14","quality":"轻度污染"}}]
             */

            private String type;
            private String plain;
            private List<OriginBean> origin;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPlain() {
                return plain;
            }

            public void setPlain(String plain) {
                this.plain = plain;
            }

            public List<OriginBean> getOrigin() {
                return origin;
            }

            public void setOrigin(List<OriginBean> origin) {
                this.origin = origin;
            }

            public static class OriginBean {
                /**
                 * date : 2018-06-14
                 * text_day : 多云
                 * code_day : 4
                 * text_night : 多云
                 * code_night : 4
                 * high : 31
                 * low : 18
                 * precip :
                 * wind_direction : 南
                 * wind_direction_degree : 180
                 * wind_speed : 10
                 * wind_scale : 2
                 * air : {"aqi":"115","pm25":"33","pm10":"92","so2":"3","no2":"35","co":"0.733","o3":"176","date":"2018-06-14","quality":"轻度污染"}
                 */

                private String date;
                private String text_day;
                private String code_day;
                private String text_night;
                private String code_night;
                private String high;
                private String low;
                private String precip;
                private String wind_direction;
                private String wind_direction_degree;
                private String wind_speed;
                private String wind_scale;
                private AirBean air;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getText_day() {
                    return text_day;
                }

                public void setText_day(String text_day) {
                    this.text_day = text_day;
                }

                public String getCode_day() {
                    return code_day;
                }

                public void setCode_day(String code_day) {
                    this.code_day = code_day;
                }

                public String getText_night() {
                    return text_night;
                }

                public void setText_night(String text_night) {
                    this.text_night = text_night;
                }

                public String getCode_night() {
                    return code_night;
                }

                public void setCode_night(String code_night) {
                    this.code_night = code_night;
                }

                public String getHigh() {
                    return high;
                }

                public void setHigh(String high) {
                    this.high = high;
                }

                public String getLow() {
                    return low;
                }

                public void setLow(String low) {
                    this.low = low;
                }

                public String getPrecip() {
                    return precip;
                }

                public void setPrecip(String precip) {
                    this.precip = precip;
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

                public AirBean getAir() {
                    return air;
                }

                public void setAir(AirBean air) {
                    this.air = air;
                }

                public static class AirBean {
                    /**
                     * aqi : 115
                     * pm25 : 33
                     * pm10 : 92
                     * so2 : 3
                     * no2 : 35
                     * co : 0.733
                     * o3 : 176
                     * date : 2018-06-14
                     * quality : 轻度污染
                     */

                    private String aqi;
                    private String pm25;
                    private String pm10;
                    private String so2;
                    private String no2;
                    private String co;
                    private String o3;
                    private String date;
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

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
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
}
