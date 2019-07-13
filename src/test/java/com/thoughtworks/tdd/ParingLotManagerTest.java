package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParingLotManagerTest {
    @Test
    public void should_add_a_parking_boy_into_managementList_when_call_method() {
        //given
        ParkingLotManager parkingManger = new ParkingLotManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        parkingManger.addParkingBogyIntoManagementList(parkingBoy);
        //then
        Assertions.assertTrue(parkingManger.getParkingBoys().contains(parkingBoy));

    }
    @Test
    public void should_specify_a_parking_boy_to_park_or_fetch_when_call_method() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingLotManager parkingManger = new ParkingLotManager();
        String parkingBoyname="boy1";
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.setName(parkingBoyname);
        parkingManger.getParkingBoys().add(parkingBoy);
        Car car = new Car();
        //when
       boolean isSucessful= parkingManger.specifyBoyToPark(parkingBoyname,car);

        //then
        Assertions.assertTrue(isSucessful);

    }
}
