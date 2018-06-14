package com.example.android.architecture.blueprints.todoapp.data.weather;

/**
 * 气象灾害预警（付费接口）
 */
public class Alarm {
    /**
     * title : 北京市气象台发布冰雹黄色预警
     * type : 冰雹
     * level : 黄色
     * status :
     * description : 北京市气象台13日09时45分发布冰雹黄色预警,预计当前至12时，延庆、怀柔、昌平、密云、平谷、顺义、通州将出现分散性冰雹，请注意防范。
     * pub_date : 2018-06-13T09:45:00+08:00
     */

    private String title;
    private String type;
    private String level;
    private String status;
    private String description;
    private String pub_date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }
}