package com.example;

import com.example.entities.*;
import com.example.entities.passengers.*;
import com.example.services.*;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Initialize services with a shared HashMap storage
        HashMap<Integer, TravelPackage> travelPackages = new HashMap<>();
        TravelPackageService travelPackageService = new TravelPackageService(travelPackages);
        ActivityService activityService = new ActivityService(travelPackages);
        PassengerService passengerService = new PassengerService(travelPackages);

        // Create a travel package
        TravelPackage europeTrip = new TravelPackage(1, "Europe Trip", 5);
        travelPackageService.addTravelPackage(europeTrip);

        // Create destinations and add to the package
        Destination paris = new Destination(101, "Paris");
        Destination rome = new Destination(102, "Rome");
        europeTrip.getDestinations().put(paris.getId(), paris);
        europeTrip.getDestinations().put(rome.getId(), rome);

        // Create activities and add to destinations
        Activity eiffelTour = new Activity(1001, "Eiffel Tower Tour", "Tour the famous Eiffel Tower.", 150.0, 20);
        Activity colosseumTour = new Activity(1002, "Colosseum Tour", "Explore the ancient Colosseum.", 125.0, 15);
        paris.getActivities().put(eiffelTour.getId(), eiffelTour);
        rome.getActivities().put(colosseumTour.getId(), colosseumTour);

        // Create passengers and add to the travel package
        Passenger ritesh = new StandardPassenger(201, "John Doe", 123, 1000.0);
        Passenger ritika = new GoldPassenger(202, "Jane Doe", 1234, 10000  ); // Assuming GoldPassenger has a discount rate
        europeTrip.getPassengers().put(ritesh.getId(), ritesh);
        europeTrip.getPassengers().put(ritika.getId(), ritika);

        // Simulate signing up for activities
        ritesh.signUpForActivity(eiffelTour);
        ritika.signUpForActivity(colosseumTour);

        // Print travel package itinerary
        travelPackageService.printItinerary(europeTrip.getId());

        // Print passenger list for the travel package
        passengerService.printPassengerList(europeTrip.getId());

        // Print details for a specific passenger
        passengerService.printPassengerDetails(ritesh.getId());
        passengerService.printPassengerDetails(ritika.getId());

        // Print available activities across all packages
        activityService.printAvailableActivities();
    }
}
