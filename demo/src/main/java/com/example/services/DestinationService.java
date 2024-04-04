package com.example.services;

import com.example.entities.Destination;
import com.example.entities.TravelPackage;
import java.util.Map;

public class DestinationService {
    private Map<Integer, TravelPackage> travelPackages; // Using HashMap for direct access

    public DestinationService(Map<Integer, TravelPackage> travelPackages) {
        this.travelPackages = travelPackages;
    }

    public void addDestinationToPackage(int packageId, Destination destination) {
        TravelPackage travelPackage = travelPackages.get(packageId);
        if (travelPackage != null) {
            travelPackage.getDestinations().put(destination.getId(), destination);
        } else {
            System.out.println("Travel package with ID " + packageId + " not found.");
        }
    }
}

