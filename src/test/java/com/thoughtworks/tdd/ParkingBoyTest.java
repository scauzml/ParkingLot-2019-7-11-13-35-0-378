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
    public void should_return_no_ticket_when_parkingLot_() {
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
    @Test
    public void should_return_right_car_when_get_a_correspond_ticket () {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkTicket parkTicket=new ParkTicket();

        //when
        Car car = parkingBoy.fetchRightCar(parkTicket);
        //then
        Assertions.assertEquals(Car.class,car.getClass());
    }
    @Test
    public void should_return_no_car_when_get_a_ticket_is_null () {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkTicket parkTicket=null;

        //when
        Car car = parkingBoy.fetchRightCar(parkTicket);
        //then
        Assertions.assertEquals(null,car);
    }
    @Test
    public void should_return_no_car_when_get_a_wrong_ticket () {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();


        //when

        //then

    }
    @Test
    public void should_return_no_car_when_get_a_ticket_is_used () {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkTicket parkTicket=new ParkTicket();
        parkTicket.setUsed(true);

        //when
        Car car = parkingBoy.fetchRightCar(parkTicket);
        //then
        Assertions.assertEquals(null,car);
    }
}
