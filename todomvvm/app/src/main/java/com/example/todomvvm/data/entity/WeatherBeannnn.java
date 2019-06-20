package com.example.todomvvm.data.entity;

public class WeatherBeannnn {

    /**
     * weatherinfo : {"Radar":"","SD":"93%","WD":"西北风","WS":"2级","WSE":"2","city":"无锡","cityid":"101190201","isRadar":"0","njd":"暂无实况","qy":"1008","temp":"12","time":"10:25"}
     */

    private WeatherinfoBean weatherinfo;

    public WeatherinfoBean getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(WeatherinfoBean weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public static class WeatherinfoBean {
        /**
         * Radar :
         * SD : 93%
         * WD : 西北风
         * WS : 2级
         * WSE : 2
         * city : 无锡
         * cityid : 101190201
         * isRadar : 0
         * njd : 暂无实况
         * qy : 1008
         * temp : 12
         * time : 10:25
         */

        private String Radar;
        private String SD;
        private String WD;
        private String WS;
        private String WSE;
        private String city;
        private String cityid;
        private String isRadar;
        private String njd;
        private String qy;
        private String temp;
        private String time;

        public String getRadar() {
            return Radar;
        }

        public void setRadar(String Radar) {
            this.Radar = Radar;
        }

        public String getSD() {
            return SD;
        }

        public void setSD(String SD) {
            this.SD = SD;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public String getWS() {
            return WS;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public String getWSE() {
            return WSE;
        }

        public void setWSE(String WSE) {
            this.WSE = WSE;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getIsRadar() {
            return isRadar;
        }

        public void setIsRadar(String isRadar) {
            this.isRadar = isRadar;
        }

        public String getNjd() {
            return njd;
        }

        public void setNjd(String njd) {
            this.njd = njd;
        }

        public String getQy() {
            return qy;
        }

        public void setQy(String qy) {
            this.qy = qy;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
