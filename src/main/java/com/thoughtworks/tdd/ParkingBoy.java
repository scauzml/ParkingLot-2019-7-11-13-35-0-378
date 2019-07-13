package com.thoughtworks.tdd;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    public ParkTicket park(Car car) {
        ParkTicket parkTicket = new ParkTicket();
        return parkTicket;
    }

    public List<ParkTicket> parkCarList(List<Car> carList) {
        List<ParkTicket> list = new ArrayList<>();
        return list;
    }

    public Car fetchRightCar(ParkTicket parkTicket) {
        Car car=null;
        if (parkTicket == null||parkTicket.isUsed()) {
            car=null;
        }else {
            car = new Car();
        }
        return car;
    }
}
