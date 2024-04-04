package com.example.entities;

public class Activity {

    private int id;
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private int availableSpots;

    public Activity(int id, String name, String description, double cost, int capacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.availableSpots = capacity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableSpots() {
        return this.availableSpots;
    }

    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }

    public boolean isAvailable() {
        return availableSpots > 0;
    }

    public boolean signUp() {
        if (isAvailable()) {
            availableSpots--;
            return true;
        }
        return false;
    }
}
