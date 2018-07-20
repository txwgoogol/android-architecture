package com.example.android.architecture.blueprints.todoapp.data.city;

/**
 * 城市列表实体类
 */
public class City {

    private String id; //城市ID
    private String time; //当前时间
    private String name; //城市名称
    private String code;//天气情况代码
    private String temperature; //温度

    public City() {
    }

    public City(String id, String time, String name, String code, String temperature) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.code = code;
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }

}