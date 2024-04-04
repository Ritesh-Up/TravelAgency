package com.example.entities;

import java.util.HashMap;
import java.util.Map;

import com.example.entities.passengers.Passenger;

public class TravelPackage {

    private int id;
    private String name;
    private int passengerCapacity;
    private Map<Integer, Destination> destinations = new HashMap<>();
    private Map<Integer, Passenger> passengers = new HashMap<>();

    // Constructor
    public TravelPackage(int id, String name, int passengerCapacity) {
        this.id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
    }


    public int getId() {
        return this.id;
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

    public Map<Integer, Destination> getDestinations() {
        return destinations;
    }

    public void addDestination(Destination destination) {
        this.destinations.put(destination.getId(), destination);
    }

    public void removeDestination(int destinationId) {
        this.destinations.remove(destinationId);
    }

    // Passengers Getters and Setters
    public Map<Integer, Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.put(passenger.getId(), passenger);
    }

    public void removePassenger(int passengerId) {
        this.passengers.remove(passengerId);
    }

}
