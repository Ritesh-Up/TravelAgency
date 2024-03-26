package com.example;

public class Main {
    public static void main(String[] args) {
        // Create activities
        Activity snorkeling = new Activity(1, "Snorkeling", "Explore underwater life.", 50.0, 10);
        Activity hiking = new Activity(2, "Hiking", "Discover scenic mountain trails.", 40.0, 15);

        // Create destination
        Destination coralIsland = new Destination(1, "Coral Island");
        coralIsland.getActivities().add(snorkeling);
        coralIsland.getActivities().add(hiking);

        // Create passengers
        StandardPassenger johnDoe = new StandardPassenger(1, "John Doe", 101, 200.0);
        GoldPassenger janeDoe = new GoldPassenger(2, "Jane Doe", 102, 300.0);
        PremiumPassenger jackDoe = new PremiumPassenger(3, "Jack Doe", 103);

        // Create travel package
        TravelPackage summerAdventure = new TravelPackage(1, "Summer Adventure", 5);
        summerAdventure.getDestinations().add(coralIsland);

        // Create service and add the package
        TravelPackageService service = new TravelPackageService();
        service.addTravelPackage(summerAdventure);

        // Add passengers to the package
        service.addPassengerToPackage(1, johnDoe);
        service.addPassengerToPackage(1, janeDoe);
        service.addPassengerToPackage(1, jackDoe);

        // Sign up passengers for activities
        service.signUpPassengerForActivity(1, 1, 1, 1); // John signs up for Snorkeling
        service.signUpPassengerForActivity(1, 2, 1, 2); // Jane signs up for Hiking

        // Utilize the service's utility methods to print information
        System.out.println("=== Travel Package Details ===");
        service.printItinerary(1);

        System.out.println("\n=== Passenger List ===");
        service.printPassengerList(1);

        // System.out.println("\n=== Available Activities ===");
        // service.printAvailableActivities();

        System.out.println("\n=== Passenger Details ===");
        // Assuming implementation of printPassengerDetails method that handles individual passenger details
        service.printPassengerDetails(1);
        service.printPassengerDetails(2);
    }
}
