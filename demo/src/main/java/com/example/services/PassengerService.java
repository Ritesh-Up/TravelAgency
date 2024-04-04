package com.example.services;

import com.example.entities.Activity;
import com.example.entities.Destination;
import com.example.entities.TravelPackage;
import com.example.entities.passengers.GoldPassenger;
import com.example.entities.passengers.Passenger;
import com.example.entities.passengers.StandardPassenger;

import java.util.Map;

public class PassengerService {
    private Map<Integer, TravelPackage> travelPackages;

    public PassengerService(Map<Integer, TravelPackage> travelPackages) {
        this.travelPackages = travelPackages;
    }

    public boolean addPassengerToPackage(int packageId, Passenger passenger) {
        TravelPackage travelPackage = travelPackages.get(packageId);
        if (travelPackage != null && travelPackage.getPassengers().size() < travelPackage.getPassengerCapacity()) {
            travelPackage.getPassengers().put(passenger.getId(), passenger);
            return true;
        }
        return false;
    }

    public void printPassengerList(int packageId) {
        TravelPackage tp = travelPackages.get(packageId);
        System.out.println(tp);
        if (tp != null) {
            System.out.println("Package Name: " + tp.getName() + ", Passenger Capacity: " + tp.getPassengerCapacity());
            System.out.println("Current Passengers Enrolled: " + tp.getPassengers().size());
            tp.getPassengers().values().forEach(p -> System.out.println("\tName: " + p.getName() + ", Passenger Number: " + p.getPassengerNumber()));
        } else {
            System.out.println("Package with ID " + packageId + " not found.");
        }
    }

    public void printPassengerDetails(int passengerId) {
        travelPackages.values().forEach(tp -> {
            Passenger p = tp.getPassengers().get(passengerId);
            if (p != null) {
                System.out.println("Name: " + p.getName() + ", Passenger Number: " + p.getPassengerNumber());
                // Assuming a method in Passenger to get balance and signed-up activities
                if (p instanceof StandardPassenger) {
                    System.out.println("Balance: " + ((StandardPassenger) p).getBalance());
                } else if (p instanceof GoldPassenger) {
                    System.out.println("Balance: " + ((GoldPassenger) p).getBalance());
                }
                // Assuming functionality to print signed-up activities, if applicable
                return;
            }
        });
        System.out.println("Passenger with ID " + passengerId + " not found.");
    }

    public boolean signUpPassengerForActivity(int passengerId, int activityId) {
        for (TravelPackage tp : travelPackages.values()) {
            for (Destination dest : tp.getDestinations().values()) {
                Activity act = dest.getActivities().get(activityId);
                if (act != null) {
                    Passenger pas = tp.getPassengers().get(passengerId);
                    if (pas != null && pas.signUpForActivity(act)) {
                        return true; // Successfully signed up
                    }
                }
            }
        }
        return false; // Activity or Passenger not found
    }
}
