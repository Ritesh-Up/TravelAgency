package com.example.entities.passengers;

import com.example.entities.Activity;

public class StandardPassenger extends Passenger {
    private double balance;

    public StandardPassenger(int id, String name, int passengerNumber, double balance) {
        super(id, name, passengerNumber);
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean signUpForActivity(Activity activity) {
        if (balance >= activity.getCost() && activity.isAvailable()) {
            balance -= activity.getCost();
            activity.signUp();
            return true;
        }
        return false;
    }
}