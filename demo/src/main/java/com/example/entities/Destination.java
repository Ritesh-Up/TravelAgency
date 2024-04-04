package com.example.entities;

import java.util.HashMap;
import java.util.Map;

public class Destination {

    private int id;
    private String name;
    private Map<Integer, Activity> activities = new HashMap<>();

    public Destination(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // ID Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Name Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Modified getters and setters for activities
    public Map<Integer, Activity> getActivities() {
        return activities;
    }
}
