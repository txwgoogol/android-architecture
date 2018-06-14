package com.example.android.architecture.blueprints.todoapp.data.life;

/**
 * 生活指数
 */
public class Suggestion {

    /**
     * ac : {"brief":"部分时间开启","details":"您将感到些燥热，建议您在适当的时候开启制冷空调来降低温度，以免中暑。"}
     * air_pollution : {"brief":"良","details":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"}
     * airing : {"brief":"极适宜","details":"天气不错，极适宜晾晒。抓紧时机把久未见阳光的衣物搬出来晒晒太阳吧！"}
     * allergy : {"brief":"不易发","details":"天气条件不易诱发过敏，可放心外出，除特殊体质外，无需担心过敏问题。"}
     * beer : {"brief":"适宜","details":"炎热干燥，一杯清凉的啤酒可有助于缓解燥热之苦，并带来舒爽的感觉。但注意不要贪杯呦！"}
     * boating : {"brief":"较适宜","details":"白天较适宜划船，但较大的风力会对划船产生一定的影响。"}
     * car_washing : {"brief":"较适宜","details":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
     * chill : {"brief":"无","details":"温度未达到风寒所需的低温，稍作防寒准备即可。"}
     * comfort : {"brief":"较不舒适","details":"白天天气晴好，明媚的阳光在给您带来好心情的同时，也会使您感到有些热，不很舒适。"}
     * dating : {"brief":"较不适宜","details":"天气较热，建议尽量不要去室外约会，如果外出，请您挑选荫凉的地点。"}
     * dressing : {"brief":"炎热","details":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"}
     * fishing : {"brief":"不宜","details":"天气太热，不适合垂钓。"}
     * flu : {"brief":"少发","details":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"}
     * hair_dressing : {"brief":"一般","details":"头发需要保持清洁，同时要注意防晒，含防晒成分洗发护发品以及遮阳帽、伞是很好的选择。"}
     * kiteflying : {"brief":"不宜","details":"天气酷热，不适宜放风筝。"}
     * makeup : {"brief":"防脱水防晒","details":"天气炎热，用防脱水防晒指数高的化妆品，少用粉底，常补粉。"}
     * mood : {"brief":"较好","details":"天气较好，注意室内通风降温，保持淡泊宁静的心态。"}
     * morning_sport : {"brief":"较适宜","details":"早晨气象条件较适宜晨练，但风力稍大，晨练时会感觉有点凉，晨练时着装不要过于单薄，选择避风的地点。"}
     * night_life : {"brief":"较适宜","details":"天气较好，虽然有点风，比较适宜夜生活，您可以放心外出。"}
     * road_condition : {"brief":"干燥","details":"天气较好，路面比较干燥，路况较好。"}
     * shopping : {"brief":"较不宜","details":"天气炎热，较不适宜逛街，若坚持出门，请避免长时间在阳光下暴晒，注意防暑降温。"}
     * sport : {"brief":"较适宜","details":"天气较好，但由于风力较大，推荐您在室内进行低强度运动，若在户外运动请注意避风。"}
     * sunscreen : {"brief":"极强","details":"紫外辐射极强，外出时应特别加强防护，建议涂擦SPF20以上，PA++的防晒护肤品，并随时补涂。"}
     * traffic : {"brief":"良好","details":"天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。"}
     * travel : {"brief":"较适宜","details":"天气较好，较热但风稍大，能缓解些炎热的感觉。较适宜旅游，您仍可陶醉于大自然美好风光中。"}
     * umbrella : {"brief":"不带伞","details":"天气较好，您在出门的时候无须带雨伞。"}
     * uv : {"brief":"很强","details":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"}
     */

    private AcBean ac;
    private AirPollutionBean air_pollution;
    private AiringBean airing;
    private AllergyBean allergy;
    private BeerBean beer;
    private BoatingBean boating;
    private CarWashingBean car_washing;
    private ChillBean chill;
    private ComfortBean comfort;
    private DatingBean dating;
    private DressingBean dressing;
    private FishingBean fishing;
    private FluBean flu;
    private HairDressingBean hair_dressing;
    private KiteflyingBean kiteflying;
    private MakeupBean makeup;
    private MoodBean mood;
    private MorningSportBean morning_sport;
    private NightLifeBean night_life;
    private RoadConditionBean road_condition;
    private ShoppingBean shopping;
    private SportBean sport;
    private SunscreenBean sunscreen;
    private TrafficBean traffic;
    private TravelBean travel;
    private UmbrellaBean umbrella;
    private UvBean uv;

    public AcBean getAc() {
        return ac;
    }

    public void setAc(AcBean ac) {
        this.ac = ac;
    }

    public AirPollutionBean getAir_pollution() {
        return air_pollution;
    }

    public void setAir_pollution(AirPollutionBean air_pollution) {
        this.air_pollution = air_pollution;
    }

    public AiringBean getAiring() {
        return airing;
    }

    public void setAiring(AiringBean airing) {
        this.airing = airing;
    }

    public AllergyBean getAllergy() {
        return allergy;
    }

    public void setAllergy(AllergyBean allergy) {
        this.allergy = allergy;
    }

    public BeerBean getBeer() {
        return beer;
    }

    public void setBeer(BeerBean beer) {
        this.beer = beer;
    }

    public BoatingBean getBoating() {
        return boating;
    }

    public void setBoating(BoatingBean boating) {
        this.boating = boating;
    }

    public CarWashingBean getCar_washing() {
        return car_washing;
    }

    public void setCar_washing(CarWashingBean car_washing) {
        this.car_washing = car_washing;
    }

    public ChillBean getChill() {
        return chill;
    }

    public void setChill(ChillBean chill) {
        this.chill = chill;
    }

    public ComfortBean getComfort() {
        return comfort;
    }

    public void setComfort(ComfortBean comfort) {
        this.comfort = comfort;
    }

    public DatingBean getDating() {
        return dating;
    }

    public void setDating(DatingBean dating) {
        this.dating = dating;
    }

    public DressingBean getDressing() {
        return dressing;
    }

    public void setDressing(DressingBean dressing) {
        this.dressing = dressing;
    }

    public FishingBean getFishing() {
        return fishing;
    }

    public void setFishing(FishingBean fishing) {
        this.fishing = fishing;
    }

    public FluBean getFlu() {
        return flu;
    }

    public void setFlu(FluBean flu) {
        this.flu = flu;
    }

    public HairDressingBean getHair_dressing() {
        return hair_dressing;
    }

    public void setHair_dressing(HairDressingBean hair_dressing) {
        this.hair_dressing = hair_dressing;
    }

    public KiteflyingBean getKiteflying() {
        return kiteflying;
    }

    public void setKiteflying(KiteflyingBean kiteflying) {
        this.kiteflying = kiteflying;
    }

    public MakeupBean getMakeup() {
        return makeup;
    }

    public void setMakeup(MakeupBean makeup) {
        this.makeup = makeup;
    }

    public MoodBean getMood() {
        return mood;
    }

    public void setMood(MoodBean mood) {
        this.mood = mood;
    }

    public MorningSportBean getMorning_sport() {
        return morning_sport;
    }

    public void setMorning_sport(MorningSportBean morning_sport) {
        this.morning_sport = morning_sport;
    }

    public NightLifeBean getNight_life() {
        return night_life;
    }

    public void setNight_life(NightLifeBean night_life) {
        this.night_life = night_life;
    }

    public RoadConditionBean getRoad_condition() {
        return road_condition;
    }

    public void setRoad_condition(RoadConditionBean road_condition) {
        this.road_condition = road_condition;
    }

    public ShoppingBean getShopping() {
        return shopping;
    }

    public void setShopping(ShoppingBean shopping) {
        this.shopping = shopping;
    }

    public SportBean getSport() {
        return sport;
    }

    public void setSport(SportBean sport) {
        this.sport = sport;
    }

    public SunscreenBean getSunscreen() {
        return sunscreen;
    }

    public void setSunscreen(SunscreenBean sunscreen) {
        this.sunscreen = sunscreen;
    }

    public TrafficBean getTraffic() {
        return traffic;
    }

    public void setTraffic(TrafficBean traffic) {
        this.traffic = traffic;
    }

    public TravelBean getTravel() {
        return travel;
    }

    public void setTravel(TravelBean travel) {
        this.travel = travel;
    }

    public UmbrellaBean getUmbrella() {
        return umbrella;
    }

    public void setUmbrella(UmbrellaBean umbrella) {
        this.umbrella = umbrella;
    }

    public UvBean getUv() {
        return uv;
    }

    public void setUv(UvBean uv) {
        this.uv = uv;
    }

    public static class AcBean {
        /**
         * brief : 部分时间开启
         * details : 您将感到些燥热，建议您在适当的时候开启制冷空调来降低温度，以免中暑。
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

    public static class AirPollutionBean {
        /**
         * brief : 良
         * details : 气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。
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

    public static class AiringBean {
        /**
         * brief : 极适宜
         * details : 天气不错，极适宜晾晒。抓紧时机把久未见阳光的衣物搬出来晒晒太阳吧！
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

    public static class AllergyBean {
        /**
         * brief : 不易发
         * details : 天气条件不易诱发过敏，可放心外出，除特殊体质外，无需担心过敏问题。
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

    public static class BeerBean {
        /**
         * brief : 适宜
         * details : 炎热干燥，一杯清凉的啤酒可有助于缓解燥热之苦，并带来舒爽的感觉。但注意不要贪杯呦！
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

    public static class BoatingBean {
        /**
         * brief : 较适宜
         * details : 白天较适宜划船，但较大的风力会对划船产生一定的影响。
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

    public static class CarWashingBean {
        /**
         * brief : 较适宜
         * details : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
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

    public static class ChillBean {
        /**
         * brief : 无
         * details : 温度未达到风寒所需的低温，稍作防寒准备即可。
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

    public static class ComfortBean {
        /**
         * brief : 较不舒适
         * details : 白天天气晴好，明媚的阳光在给您带来好心情的同时，也会使您感到有些热，不很舒适。
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

    public static class DatingBean {
        /**
         * brief : 较不适宜
         * details : 天气较热，建议尽量不要去室外约会，如果外出，请您挑选荫凉的地点。
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
         * brief : 炎热
         * details : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
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

    public static class FishingBean {
        /**
         * brief : 不宜
         * details : 天气太热，不适合垂钓。
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
         * details : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
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

    public static class HairDressingBean {
        /**
         * brief : 一般
         * details : 头发需要保持清洁，同时要注意防晒，含防晒成分洗发护发品以及遮阳帽、伞是很好的选择。
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

    public static class KiteflyingBean {
        /**
         * brief : 不宜
         * details : 天气酷热，不适宜放风筝。
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

    public static class MakeupBean {
        /**
         * brief : 防脱水防晒
         * details : 天气炎热，用防脱水防晒指数高的化妆品，少用粉底，常补粉。
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

    public static class MoodBean {
        /**
         * brief : 较好
         * details : 天气较好，注意室内通风降温，保持淡泊宁静的心态。
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

    public static class MorningSportBean {
        /**
         * brief : 较适宜
         * details : 早晨气象条件较适宜晨练，但风力稍大，晨练时会感觉有点凉，晨练时着装不要过于单薄，选择避风的地点。
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

    public static class NightLifeBean {
        /**
         * brief : 较适宜
         * details : 天气较好，虽然有点风，比较适宜夜生活，您可以放心外出。
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

    public static class RoadConditionBean {
        /**
         * brief : 干燥
         * details : 天气较好，路面比较干燥，路况较好。
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

    public static class ShoppingBean {
        /**
         * brief : 较不宜
         * details : 天气炎热，较不适宜逛街，若坚持出门，请避免长时间在阳光下暴晒，注意防暑降温。
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
         * brief : 较适宜
         * details : 天气较好，但由于风力较大，推荐您在室内进行低强度运动，若在户外运动请注意避风。
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

    public static class SunscreenBean {
        /**
         * brief : 极强
         * details : 紫外辐射极强，外出时应特别加强防护，建议涂擦SPF20以上，PA++的防晒护肤品，并随时补涂。
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

    public static class TrafficBean {
        /**
         * brief : 良好
         * details : 天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。
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
         * brief : 较适宜
         * details : 天气较好，较热但风稍大，能缓解些炎热的感觉。较适宜旅游，您仍可陶醉于大自然美好风光中。
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

    public static class UmbrellaBean {
        /**
         * brief : 不带伞
         * details : 天气较好，您在出门的时候无须带雨伞。
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
         * brief : 很强
         * details : 紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。
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