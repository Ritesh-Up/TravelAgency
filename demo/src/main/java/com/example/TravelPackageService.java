package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelPackageService {

    private List<TravelPackage> travelPackages = new ArrayList<>();

    public void addTravelPackage(TravelPackage travelPackage) {
        travelPackages.add(travelPackage);
    }

    public boolean addPassengerToPackage(int packageId, Passenger passenger) {
        Optional<TravelPackage> packageOptional = travelPackages.stream()
            .filter(p -> p.getId() == packageId)
            .findFirst();

        if (packageOptional.isPresent()) {
            TravelPackage travelPackage = packageOptional.get();
            if (travelPackage.getPassengers().size() < travelPackage.getPassengerCapacity()) {
                return travelPackage.getPassengers().add(passenger);
            }
        }
        return false;
    }

    public void addDestinationToPackage(int packageId, Destination destination) {
        travelPackages.stream()
                .filter(p -> p.getId() == packageId)
                .findFirst()
                .ifPresent(travelPackage -> travelPackage.getDestinations().add(destination));
    }

    public void addActivityToDestination(int packageId, int destinationId, Activity activity) {
        travelPackages.stream()
                .filter(p -> p.getId() == packageId)
                .findFirst()
                .ifPresent(travelPackage -> travelPackage.getDestinations().stream()
                        .filter(d -> d.getId() == destinationId)
                        .findFirst()
                        .ifPresent(destination -> destination.getActivities().add(activity)));
    }

    public boolean signUpPassengerForActivity(int packageId, int passengerId, int destinationId, int activityId) {
        for (TravelPackage pkg : travelPackages) {
            if (pkg.getId() == packageId) {
                for (Destination dest : pkg.getDestinations()) {
                    if (dest.getId() == destinationId) {
                        for (Activity act : dest.getActivities()) {
                            if (act.getId() == activityId) {
                                for (Passenger pas : pkg.getPassengers()) {
                                    if (pas.getId() == passengerId) {
                                        return pas.signUpForActivity(act);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void printItinerary(int packageId) {
        for (TravelPackage tp : travelPackages) {
            if (tp.getId() == packageId) {
                System.out.println("Package Name: " + tp.getName());
                for (Destination d : tp.getDestinations()) {
                    System.out.println("\tDestination: " + d.getName());
                    for (Activity a : d.getActivities()) {
                        System.out.println("\t\tActivity: " + a.getName() + ", Cost: " + a.getCost() + ", Capacity: " + a.getCapacity() + ", Description: " + a.getDescription());
                    }
                }
                return;
            }
        }
        System.out.println("Package with ID " + packageId + " not found.");
    }

    public void printPassengerList(int packageId) {
        for (TravelPackage tp : travelPackages) {
            if (tp.getId() == packageId) {
                System.out.println("Package Name: " + tp.getName() + ", Passenger Capacity: " + tp.getPassengerCapacity());
                System.out.println("Current Passengers Enrolled: " + tp.getPassengers().size());
                for (Passenger p : tp.getPassengers()) {
                    System.out.println("\tName: " + p.getName() + ", Passenger Number: " + p.getPassengerNumber());
                }
                return;
            }
        }
        System.out.println("Package with ID " + packageId + " not found.");
    }

    public void printPassengerDetails(int passengerId) {
    for (TravelPackage tp : travelPackages) {
        for (Passenger p : tp.getPassengers()) {
            if (p.getId() == passengerId) {
                System.out.println("Name: " + p.getName() + ", Passenger Number: " + p.getPassengerNumber());
                // Assuming a method in Passenger to get balance and signed-up activities
                if (p instanceof StandardPassenger){
                    System.out.println("Balance: " + ((StandardPassenger) p).getBalance());
                } else if(p instanceof GoldPassenger) {
                    System.out.println("Balance: " + ((GoldPassenger) p).getBalance());
                }
                // printSignedUpActivities(p);
                return;
            }
        }
    }
    System.out.println("Passenger with ID " + passengerId + " not found.");
}

}

