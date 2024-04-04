package com.example.services;

import com.example.entities.TravelPackage;
import com.example.entities.Destination;
import com.example.entities.Activity;
import java.util.HashMap;
import java.util.Map;

public class TravelPackageService {

    private Map<Integer, TravelPackage> travelPackages;

    public TravelPackageService(Map<Integer, TravelPackage> travelPackages) {
        this.travelPackages = travelPackages;
    }

    public void addTravelPackage(TravelPackage travelPackage) {
        travelPackages.put(travelPackage.getId(), travelPackage);
    }

    public void printItinerary(int packageId) {
        TravelPackage tp = travelPackages.get(packageId);
        System.out.println(tp);

        if (tp != null) {
            System.out.println("Package Name: " + tp.getName());
            Map<Integer, Destination> destinations = tp.getDestinations();
            for (Destination d : destinations.values()) {
                System.out.println("\tDestination: " + d.getName());
                Map<Integer, Activity> activities = d.getActivities();
                for (Activity a : activities.values()) {
                    System.out.println("\t\tActivity: " + a.getName() + ", Cost: " + a.getCost() + ", Capacity: " + a.getCapacity() + ", Description: " + a.getDescription());
                }
            }
        } else {
            System.out.println("Package with ID " + packageId + " not found.");
        }
    }
}
