package com.example.todomvvm.data.bean;

import java.util.List;

//一星期预报
public class WeatherForecast {

    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101190405","location":"吴中","parent_city":"苏州","admin_area":"江苏","cnty":"中国","lat":"31.27083969","lon":"120.62461853","tz":"+8.00"}
         * update : {"loc":"2019-07-26 16:57","utc":"2019-07-26 08:57"}
         * status : ok
         * daily_forecast : [{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2019-07-26","hum":"75","mr":"00:00","ms":"13:14","pcpn":"0.0","pop":"25","pres":"1001","sr":"05:10","ss":"18:56","tmp_max":"36","tmp_min":"29","uv_index":"5","vis":"24","wind_deg":"276","wind_dir":"西风","wind_sc":"1-2","wind_spd":"4"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2019-07-27","hum":"78","mr":"00:30","ms":"14:13","pcpn":"3.6","pop":"71","pres":"1003","sr":"05:11","ss":"18:56","tmp_max":"36","tmp_min":"29","uv_index":"5","vis":"24","wind_deg":"190","wind_dir":"南风","wind_sc":"1-2","wind_spd":"10"},{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2019-07-28","hum":"81","mr":"01:11","ms":"15:15","pcpn":"0.0","pop":"25","pres":"1004","sr":"05:12","ss":"18:55","tmp_max":"36","tmp_min":"28","uv_index":"10","vis":"24","wind_deg":"129","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"5"},{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2019-07-29","hum":"77","mr":"01:57","ms":"16:17","pcpn":"0.0","pop":"25","pres":"1004","sr":"05:12","ss":"18:54","tmp_max":"37","tmp_min":"30","uv_index":"6","vis":"25","wind_deg":"170","wind_dir":"南风","wind_sc":"1-2","wind_spd":"1"},{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2019-07-30","hum":"75","mr":"02:50","ms":"17:20","pcpn":"0.0","pop":"20","pres":"1004","sr":"05:13","ss":"18:54","tmp_max":"37","tmp_min":"30","uv_index":"11","vis":"24","wind_deg":"232","wind_dir":"西南风","wind_sc":"1-2","wind_spd":"4"},{"cond_code_d":"305","cond_code_n":"101","cond_txt_d":"小雨","cond_txt_n":"多云","date":"2019-07-31","hum":"78","mr":"03:51","ms":"18:18","pcpn":"1.0","pop":"55","pres":"1004","sr":"05:14","ss":"18:53","tmp_max":"37","tmp_min":"29","uv_index":"10","vis":"25","wind_deg":"236","wind_dir":"西南风","wind_sc":"1-2","wind_spd":"11"},{"cond_code_d":"104","cond_code_n":"104","cond_txt_d":"阴","cond_txt_n":"阴","date":"2019-08-01","hum":"75","mr":"04:58","ms":"19:13","pcpn":"0.0","pop":"25","pres":"1005","sr":"05:14","ss":"18:52","tmp_max":"36","tmp_min":"29","uv_index":"6","vis":"24","wind_deg":"117","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"1"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private List<DailyForecastBean> daily_forecast;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public static class BasicBean {
            /**
             * cid : CN101190405
             * location : 吴中
             * parent_city : 苏州
             * admin_area : 江苏
             * cnty : 中国
             * lat : 31.27083969
             * lon : 120.62461853
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean {
            /**
             * loc : 2019-07-26 16:57
             * utc : 2019-07-26 08:57
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class DailyForecastBean {
            /**
             * cond_code_d : 101
             * cond_code_n : 101
             * cond_txt_d : 多云
             * cond_txt_n : 多云
             * date : 2019-07-26
             * hum : 75
             * mr : 00:00
             * ms : 13:14
             * pcpn : 0.0
             * pop : 25
             * pres : 1001
             * sr : 05:10
             * ss : 18:56
             * tmp_max : 36
             * tmp_min : 29
             * uv_index : 5
             * vis : 24
             * wind_deg : 276
             * wind_dir : 西风
             * wind_sc : 1-2
             * wind_spd : 4
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }
    }
}
