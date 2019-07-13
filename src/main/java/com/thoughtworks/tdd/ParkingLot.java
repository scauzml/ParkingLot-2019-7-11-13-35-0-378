package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> cars = new ArrayList<>();
    private List<ParkTicket> parkTicketList = new ArrayList<>();
    private int capacity;
    private int allowance;
    public List<ParkTicket> getParkTicketList() {
        return parkTicketList;
    }

    public void setParkTicketList(List<ParkTicket> parkTicketList) {
        this.parkTicketList = parkTicketList;

    }



    public ParkingLot() {
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.allowance=capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean addCar(Car car) {
        cars.add(car);
        this.allowance=this.capacity-1;
        return true;
    }

    public boolean isCapacityEnough() {
      boolean isEnough=true;
        if (this.cars.size() >= this.capacity) {
            isEnough=false;
        }
        return isEnough;
    }

    public void addParTicket(ParkTicket parkTicket) {
        parkTicketList.add(parkTicket);
    }

    public boolean isContainParkTicket(ParkTicket parkTicket) {

       return this.parkTicketList.contains(parkTicket);
    }
    public boolean isContainCar(Car car) {

        return this.cars.contains(car);
    }
}
