package com.example.android.architecture.blueprints.todoapp.data.life;

public class LifeIndex {

    private int id;
    private String name;
    private String index;
    private String details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "LifeIndex{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", index='" + index + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}