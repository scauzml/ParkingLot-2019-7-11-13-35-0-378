package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

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

}
