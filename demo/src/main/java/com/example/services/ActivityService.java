package com.example.services;

import com.example.entities.Activity;
import com.example.entities.Destination;
import com.example.entities.TravelPackage;
import java.util.Map;

public class ActivityService {
    private Map<Integer, TravelPackage> travelPackages; // HashMap for direct access

    public ActivityService(Map<Integer, TravelPackage> travelPackages) {
        this.travelPackages = travelPackages;
    }

    public void addActivityToDestination(int packageId, int destinationId, Activity activity) {
        TravelPackage travelPackage = travelPackages.get(packageId);
        if (travelPackage != null) {
            Destination destination = travelPackage.getDestinations().get(destinationId);
            if (destination != null) {
                destination.getActivities().put(activity.getId(), activity);
            } else {
                System.out.println("Destination not found.");
            }
        } else {
            System.out.println("Travel package not found.");
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        travelPackages.values().forEach(travelPackage -> travelPackage.getDestinations().values().forEach(destination -> destination.getActivities().values().forEach(activity -> {
            if (activity.isAvailable()) {
                System.out.println(String.format("Package: %s, Destination: %s, Activity: %s, Cost: %.2f, Available Spots: %d",
                        travelPackage.getName(), destination.getName(), activity.getName(), activity.getCost(), activity.getAvailableSpots()));
            }
        })));
    }
}
