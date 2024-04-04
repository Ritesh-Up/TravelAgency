package com.example.entities.passengers;

import com.example.entities.Activity;

public class PremiumPassenger extends Passenger {
    public PremiumPassenger(int id, String name, int passengerNumber) {
        super(id, name, passengerNumber);
    }

    public boolean signUpForActivity(Activity activity) {
        if (activity.isAvailable()) {
            activity.signUp();
            return true;
        }
        return false;
    }

    // Getters and Setters
}

