package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {

    @Test
    public void should_return_a_ticket_when_parking_a_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        //when
        ParkTicket parkTicket=parkingBoy.park(car);
        //then
        Assertions.assertEquals(ParkTicket.class,parkTicket.getClass());
    }
    @Test
    public void should_return_parkTicketList_when_add_a_car_list() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        Car car1 = new Car();
        List<Car> carList = new ArrayList<>();
        //when
        List<ParkTicket> parkTicketList = parkingBoy.parkCarList(carList);
        //then
        Assertions.assertEquals(new ArrayList<ParkTicket>().getClass(),parkTicketList.getClass());
    }
}
