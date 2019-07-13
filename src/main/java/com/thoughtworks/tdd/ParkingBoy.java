package com.thoughtworks.tdd;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
     private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy() {
    }

    public ParkTicket park(Car car) {
        ParkTicket parkTicket =null;
        boolean isCapacityEnough=this.parkingLot.isCapacityEnough();
        if (isCapacityEnough) {
            parkTicket=new ParkTicket();
            parkingLot.addCar(car);
        }

        return parkTicket;
    }

    public List<ParkTicket> parkCarList(List<Car> carList) {
        List<ParkTicket> list = new ArrayList<>();
        return list;
    }

    public Car fetchRightCar(ParkTicket parkTicket) {
        Car car=null;
        //验证pakTicket是wrong

        if (parkTicket == null||parkTicket.isUsed()) {
            car=null;
        }else {
            car = new Car();
        }
        return car;
    }
}
