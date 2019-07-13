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

    @Test
    public void should_return_a_ticket_when_parking_a_car_by_manger() {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingLot parkingLot1=new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot1);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);
        Car car = new Car("333");
        //when
        ParkTicket parkTicket=parkingLotManager.park(car);
        //then
        ParkTicket parkTicket1 = new ParkTicket();
        parkTicket1.setCarNumber(car.getCarNumber());
        Assertions.assertEquals(parkTicket1,parkTicket);
    }

    @Test
    public void should_return_right_car_when_get_a_correspond_ticket () {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingLot parkingLot1=new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot1);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);
        ParkTicket parkTicket=new ParkTicket();
        parkingLot.addParTicket(parkTicket);
        Car car = new Car("123");
        parkingLot.addCar(car);
        parkTicket.setCarNumber(car.getCarNumber());
        parkingLot.addParTicket(parkTicket);
        //when
        Car car1 = parkingLotManager.fetchRightCar(parkTicket);
        //then
        Assertions.assertEquals(car,car1);

    }
}
