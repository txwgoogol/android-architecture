package com.example.android.architecture.blueprints.todoapp.data.geo;

import java.util.List;

/**
 * 月出月落和月相（付费接口）
 */
public class Moon {

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
         * moon : [{"date":"2018-06-13","rise":"04:17","set":"19:02","fraction":"0.02","phase":"0.95","phase_name":"亏眉月"},{"date":"2018-06-14","rise":"05:05","set":"20:08","fraction":"0","phase":"0.99","phase_name":"亏眉月"},{"date":"2018-06-15","rise":"06:01","set":"21:09","fraction":"0.01","phase":"0.03","phase_name":"蛾眉月"},{"date":"2018-06-16","rise":"07:05","set":"22:03","fraction":"0.05","phase":"0.07","phase_name":"蛾眉月"},{"date":"2018-06-17","rise":"08:14","set":"22:51","fraction":"0.11","phase":"0.11","phase_name":"蛾眉月"},{"date":"2018-06-18","rise":"09:25","set":"23:31","fraction":"0.19","phase":"0.14","phase_name":"蛾眉月"},{"date":"2018-06-19","rise":"10:36","set":"10:20","fraction":"0.29","phase":"0.18","phase_name":"蛾眉月"}]
         */

        private LocationBean location;
        private List<MoonBean> moon;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public List<MoonBean> getMoon() {
            return moon;
        }

        public void setMoon(List<MoonBean> moon) {
            this.moon = moon;
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

        public static class MoonBean {
            /**
             * date : 2018-06-13
             * rise : 04:17
             * set : 19:02
             * fraction : 0.02
             * phase : 0.95
             * phase_name : 亏眉月
             */

            private String date;
            private String rise;
            private String set;
            private String fraction;
            private String phase;
            private String phase_name;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getRise() {
                return rise;
            }

            public void setRise(String rise) {
                this.rise = rise;
            }

            public String getSet() {
                return set;
            }

            public void setSet(String set) {
                this.set = set;
            }

            public String getFraction() {
                return fraction;
            }

            public void setFraction(String fraction) {
                this.fraction = fraction;
            }

            public String getPhase() {
                return phase;
            }

            public void setPhase(String phase) {
                this.phase = phase;
            }

            public String getPhase_name() {
                return phase_name;
            }

            public void setPhase_name(String phase_name) {
                this.phase_name = phase_name;
            }
        }
    }
}
