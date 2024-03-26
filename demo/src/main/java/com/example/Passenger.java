package com.example;

public abstract class Passenger {

    protected int id;
    protected String name;
    protected int passengerNumber;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerNumber() {
        return this.passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public Passenger(int id, String name, int passengerNumber) {
        this.id = id;
        this.name = name;
        this.passengerNumber = passengerNumber;
    }

    public abstract boolean signUpForActivity(Activity activity);
}
