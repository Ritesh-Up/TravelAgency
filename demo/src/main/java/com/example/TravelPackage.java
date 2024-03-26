package com.example;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {

    private int id;
    private String name;
    private int passengerCapacity;
    private List<Destination> destinations = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();

    // Constructor
    public TravelPackage(int id, String name, int passengerCapacity) {
        this.id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
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

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public List<Destination> getDestinations() {
        return this.destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
