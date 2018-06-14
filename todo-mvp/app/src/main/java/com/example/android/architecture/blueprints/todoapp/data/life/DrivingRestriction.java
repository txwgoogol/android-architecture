package com.example.android.architecture.blueprints.todoapp.data.life;

import java.util.List;

/**
 * 机动车尾号限行（付费接口）
 */
public class DrivingRestriction {

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
         * restriction : {"penalty":"京牌罚100块，不扣分。非京牌罚100块，扣3分。","region":"五环路以内道路（不包括五环路主路）","time":"周一至五的早7时至晚20时(法定节假日和公休日不限行)","remarks":"临时号牌按号牌尾号数字限行。机动车车尾号为英文字母的按0号管理。本市核发号牌的纯电动小客车不受工作日高峰时段区域限行措施限制。警车、消防车、救护车、出租车、环卫车等非民用车辆不受上述限制, 外埠车辆工作日7时至9时、17时至20时禁止进五环（含），没有进京证禁止进六环（不含）","limits":[{"date":"2018-06-13","plates":["1","6"],"memo":"尾号限行"},{"date":"2018-06-14","plates":["2","7"],"memo":"尾号限行"},{"date":"2018-06-15","plates":["3","8"],"memo":"尾号限行"}]}
         */

        private LocationBean location;
        private RestrictionBean restriction;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public RestrictionBean getRestriction() {
            return restriction;
        }

        public void setRestriction(RestrictionBean restriction) {
            this.restriction = restriction;
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

        public static class RestrictionBean {
            /**
             * penalty : 京牌罚100块，不扣分。非京牌罚100块，扣3分。
             * region : 五环路以内道路（不包括五环路主路）
             * time : 周一至五的早7时至晚20时(法定节假日和公休日不限行)
             * remarks : 临时号牌按号牌尾号数字限行。机动车车尾号为英文字母的按0号管理。本市核发号牌的纯电动小客车不受工作日高峰时段区域限行措施限制。警车、消防车、救护车、出租车、环卫车等非民用车辆不受上述限制, 外埠车辆工作日7时至9时、17时至20时禁止进五环（含），没有进京证禁止进六环（不含）
             * limits : [{"date":"2018-06-13","plates":["1","6"],"memo":"尾号限行"},{"date":"2018-06-14","plates":["2","7"],"memo":"尾号限行"},{"date":"2018-06-15","plates":["3","8"],"memo":"尾号限行"}]
             */

            private String penalty;
            private String region;
            private String time;
            private String remarks;
            private List<LimitsBean> limits;

            public String getPenalty() {
                return penalty;
            }

            public void setPenalty(String penalty) {
                this.penalty = penalty;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public List<LimitsBean> getLimits() {
                return limits;
            }

            public void setLimits(List<LimitsBean> limits) {
                this.limits = limits;
            }

            public static class LimitsBean {
                /**
                 * date : 2018-06-13
                 * plates : ["1","6"]
                 * memo : 尾号限行
                 */

                private String date;
                private String memo;
                private List<String> plates;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getMemo() {
                    return memo;
                }

                public void setMemo(String memo) {
                    this.memo = memo;
                }

                public List<String> getPlates() {
                    return plates;
                }

                public void setPlates(List<String> plates) {
                    this.plates = plates;
                }
            }
        }
    }
}
