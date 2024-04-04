package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.entities.*;
import com.example.entities.passengers.*;
import com.example.services.*;
import java.util.HashMap;
import java.util.Map;

class ActivityServiceTest {
    private ActivityService activityService;
    private HashMap<Integer, TravelPackage> travelPackages;

    @BeforeEach
    void setUp() {
        travelPackages = new HashMap<>();
        activityService = new ActivityService(travelPackages);

        // Setup initial data
        Destination paris = new Destination(101, "Paris");
        TravelPackage europeTrip = new TravelPackage(1, "Europe Trip", 5);
        europeTrip.getDestinations().put(paris.getId(), paris);
        travelPackages.put(europeTrip.getId(), europeTrip);
    }

    @Test
    void addActivityToDestination_Success() {
        Activity eiffelTour = new Activity(1001, "Eiffel Tower Tour", "Tour the famous Eiffel Tower.", 150.0, 20);
        activityService.addActivityToDestination(1, 101, eiffelTour);
        assertTrue(travelPackages.get(1).getDestinations().get(101).getActivities().containsKey(1001));
    }

    @Test
    void addActivityToDestination_DestinationDoesNotExist() {
        Activity louvreVisit = new Activity(1002, "Louvre Visit", "Explore the Louvre Museum.", 120.0, 15);
        activityService.addActivityToDestination(1, 999, louvreVisit); // Non-existing destination ID
        assertFalse(travelPackages.get(1).getDestinations().containsKey(999));
    }
}

class PassengerServiceTest {

    private PassengerService passengerService;
    private Map<Integer, TravelPackage> travelPackages;
    private TravelPackage europeTrip;

    @BeforeEach
    void setUp() {
        // Initialize shared HashMap storage
        travelPackages = new HashMap<>();
        passengerService = new PassengerService(travelPackages);

        // Setup Travel Package
        europeTrip = new TravelPackage(1, "Europe Trip", 2); // Capacity set to 2 for testing
        travelPackages.put(europeTrip.getId(), europeTrip);

        // Setup Destinations and Activities (if needed for signUpPassengerForActivity)
        Destination paris = new Destination(101, "Paris");
        Activity eiffelTour = new Activity(1001, "Eiffel Tower Tour", "A tour of the Eiffel Tower.", 150.00, 20);
        paris.getActivities().put(eiffelTour.getId(), eiffelTour);
        europeTrip.getDestinations().put(paris.getId(), paris);
    }

    @Test
    void addPassengerToPackage_Success() {
        Passenger newPassenger = new StandardPassenger(301, "Alice Doe", 301, 500.0);
        assertTrue(passengerService.addPassengerToPackage(1, newPassenger));
        assertEquals(1, europeTrip.getPassengers().size());
    }

    @Test
    void addPassengerToPackage_Fail_ExceedCapacity() {
        // Add passengers to reach capacity
        passengerService.addPassengerToPackage(1, new StandardPassenger(301, "Alice Doe", 301, 500.0));
        passengerService.addPassengerToPackage(1, new StandardPassenger(302, "Bob Doe", 302, 600.0));

        // Attempt to add another passenger should fail
        assertFalse(passengerService.addPassengerToPackage(1, new StandardPassenger(303, "Charlie Doe", 303, 700.0)));
    }

    @Test
    void addPassengerToPackage_Fail_InvalidPackage() {
        assertFalse(passengerService.addPassengerToPackage(999, new StandardPassenger(301, "Alice Doe", 301, 500.0))); // Non-existent package ID
    }

    @Test
    void signUpPassengerForActivity_Success() {
        Passenger passenger = new StandardPassenger(301, "Alice Doe", 301, 1000.0);
        passengerService.addPassengerToPackage(1, passenger);
        assertTrue(passengerService.signUpPassengerForActivity(301, 1001)); // Assuming signUpForActivity implementation exists and works correctly
    }

    @Test
    void signUpPassengerForActivity_Fail_InvalidActivity() {
        Passenger passenger = new StandardPassenger(301, "Alice Doe", 301, 1000.0);
        passengerService.addPassengerToPackage(1, passenger);
        assertFalse(passengerService.signUpPassengerForActivity(301, 9999)); // Invalid activity ID
    }

    @Test
    void signUpPassengerForActivity_Fail_InvalidPassenger() {
        assertFalse(passengerService.signUpPassengerForActivity(999, 1001)); // Invalid passenger ID
    }

}

class DestinationServiceTest {

    private DestinationService destinationService;
    private HashMap<Integer, TravelPackage> travelPackages;

    @BeforeEach
    void setUp() {
        travelPackages = new HashMap<>();
        destinationService = new DestinationService(travelPackages);

        TravelPackage europeTrip = new TravelPackage(1, "Europe Trip", 5);
        travelPackages.put(europeTrip.getId(), europeTrip);
    }

    @Test
    void addDestinationToPackage_Success() {
        Destination paris = new Destination(101, "Paris");
        destinationService.addDestinationToPackage(1, paris);
        assertEquals(paris, travelPackages.get(1).getDestinations().get(101), "Destination should be successfully added to the package.");
    }
}

class TravelPackageServiceTest {

    private TravelPackageService travelPackageService;
    private HashMap<Integer, TravelPackage> travelPackages;

    @BeforeEach
    void setUp() {
        travelPackages = new HashMap<>();
        travelPackageService = new TravelPackageService(travelPackages);
    }

    @Test
    void addTravelPackage_Success() {
        TravelPackage europeTrip = new TravelPackage(1, "Europe Trip", 5);
        travelPackageService.addTravelPackage(europeTrip);
        assertTrue(travelPackages.containsKey(1), "Travel package should be added.");
        assertEquals(europeTrip, travelPackages.get(1), "Added package should match the provided package.");
    }

    @Test
    void addTravelPackage_NullPackage() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            travelPackageService.addTravelPackage(null);
        });

        assertEquals("Cannot invoke \"com.example.entities.TravelPackage.getId()\" because \"travelPackage\" is null", exception.getMessage());
    }
}
