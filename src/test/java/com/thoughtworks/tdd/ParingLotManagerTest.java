package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
