package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotManager {
    private List<ParkingBoy> parkingBoys = new ArrayList<>();

    public ParkingLotManager(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public ParkingLotManager() {
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void setParkingBoys(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public void addParkingBogyIntoManagementList(ParkingBoy boy) {
        parkingBoys.add(boy);
    }


    public boolean specifyBoyToPark(String parkingBoyname, Car car) {
        ParkingBoy parkingBoy=this.getParkingBoys().stream().filter(e->e.getName()==parkingBoyname).map(e->(e)).findFirst().get();
        ParkTicket parkTicket = parkingBoy.park(car);

        if (parkingBoy != null) {
            return true;
        }else {
            return false;
        }
    }
}
