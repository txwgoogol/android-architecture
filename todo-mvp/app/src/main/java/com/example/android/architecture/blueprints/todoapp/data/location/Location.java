package com.example.android.architecture.blueprints.todoapp.data.location;

/**
 * 城市搜索
 */
public class Location {
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
