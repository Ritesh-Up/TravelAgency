package com.example.entities.passengers;

import com.example.entities.Activity;

public class GoldPassenger extends Passenger {
    private double balance;

    public GoldPassenger(int id, String name, int passengerNumber, double balance) {
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
        double discountedCost = activity.getCost() * 0.10; // 10% discount
        if (balance >= discountedCost && activity.isAvailable()) {
            balance -= discountedCost;
            activity.signUp();
            return true;
        }
        return false;
    }
}