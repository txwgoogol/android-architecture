package top.txwgoogol.weather.todoapp.data.bean.city;

import java.util.List;

/**
 * 根据城市经纬度 查询地理位置 实体类
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class Address {

    private List<Double> queryLocation;
    private List<AddrListBean> addList;

    public List<Double> getQueryLocation() {
        return queryLocation;
    }

    public void setQueryLocation(List<Double> queryLocation) {
        this.queryLocation = queryLocation;
    }

    public List<AddrListBean> getAddrList() {
        return addList;
    }

    public void setAddrList(List<AddrListBean> addrList) {
        this.addList = addrList;
    }

    public static class AddrListBean {
        /**
         * type : poi
         * status : 1
         * name : 五环数码图文
         * id : ANB02001BD3T
         * admCode : 320508
         * admName : 江苏省,苏州市,,
         * addr : 西环路888号
         * nearestPoint : [120.58054,31.29028]
         * distance : 60.828
         */

        private String type;
        private int status;
        private String name;
        private String id;
        private String admCode;
        private String admName;
        private String addr;
        private double distance;
        private List<Double> nearestPoint;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAdmCode() {
            return admCode;
        }

        public void setAdmCode(String admCode) {
            this.admCode = admCode;
        }

        public String getAdmName() {
            return admName;
        }

        public void setAdmName(String admName) {
            this.admName = admName;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public List<Double> getNearestPoint() {
            return nearestPoint;
        }

        public void setNearestPoint(List<Double> nearestPoint) {
            this.nearestPoint = nearestPoint;
        }
    }
}