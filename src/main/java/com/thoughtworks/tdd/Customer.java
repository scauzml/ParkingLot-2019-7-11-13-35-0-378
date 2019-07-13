package com.thoughtworks.tdd;

public class Customer {
     private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public boolean isMyCar(Car car) {
        return this.car==car;
    }
}
