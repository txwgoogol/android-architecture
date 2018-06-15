package com.example.android.architecture.blueprints.todoapp.data.life;

/**
 * 生活指数
 */
public class Suggestion {

    /**
     * car_washing : {"brief":"较适宜","details":""}
     * dressing : {"brief":"热","details":""}
     * flu : {"brief":"少发","details":""}
     * sport : {"brief":"适宜","details":""}
     * travel : {"brief":"适宜","details":""}
     * uv : {"brief":"弱","details":""}
     */

    private CarWashingBean car_washing;
    private DressingBean dressing;
    private FluBean flu;
    private SportBean sport;
    private TravelBean travel;
    private UvBean uv;

    public CarWashingBean getCar_washing() {
        return car_washing;
    }

    public void setCar_washing(CarWashingBean car_washing) {
        this.car_washing = car_washing;
    }

    public DressingBean getDressing() {
        return dressing;
    }

    public void setDressing(DressingBean dressing) {
        this.dressing = dressing;
    }

    public FluBean getFlu() {
        return flu;
    }

    public void setFlu(FluBean flu) {
        this.flu = flu;
    }

    public SportBean getSport() {
        return sport;
    }

    public void setSport(SportBean sport) {
        this.sport = sport;
    }

    public TravelBean getTravel() {
        return travel;
    }

    public void setTravel(TravelBean travel) {
        this.travel = travel;
    }

    public UvBean getUv() {
        return uv;
    }

    public void setUv(UvBean uv) {
        this.uv = uv;
    }

    public static class CarWashingBean {
        /**
         * brief : 较适宜
         * details :
         */

        private String brief;
        private String details;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    public static class DressingBean {
        /**
         * brief : 热
         * details :
         */

        private String brief;
        private String details;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    public static class FluBean {
        /**
         * brief : 少发
         * details :
         */

        private String brief;
        private String details;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    public static class SportBean {
        /**
         * brief : 适宜
         * details :
         */

        private String brief;
        private String details;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    public static class TravelBean {
        /**
         * brief : 适宜
         * details :
         */

        private String brief;
        private String details;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    public static class UvBean {
        /**
         * brief : 弱
         * details :
         */

        private String brief;
        private String details;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
}