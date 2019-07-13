package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {

    @Test
    public void should_return_a_ticket_when_parking_a_car() {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("333");
        //when
        ParkTicket parkTicket=parkingBoy.park(car);

        //then
        ParkTicket parkTicket1 = new ParkTicket();
        parkTicket1.setCarNumber(car.getCarNumber());
        Assertions.assertEquals(parkTicket1,parkTicket);
    }

//    @Test
//    public void should_return_no_ticket_when_parkingLot_() {
//        //given
//        ParkingLot parkingLot=new ParkingLot();
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
//        Car car = new Car();
//        //when
//        ParkTicket parkTicket=parkingBoy.park(car);
//        //then
//        Assertions.assertEquals(ParkTicket.class,parkTicket.getClass());
//    }
    @Test
    public void should_return_parkTicketList_when_add_a_car_list() {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car("111");
        Car car2 = new Car("222");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        //when
        List<ParkTicket> parkTicketList = parkingBoy.parkCarList(carList);
        //then
        ParkTicket parkTicket = new ParkTicket(car1.getCarNumber());
        ParkTicket parkTicket1 = new ParkTicket(car2.getCarNumber());
        List<ParkTicket>  parkTicketList1= new ArrayList<>();
        parkTicketList1.add(parkTicket);
        parkTicketList1.add(parkTicket1);
        Assertions.assertEquals(parkTicketList1,parkTicketList);
    }
    @Test
    public void should_return_right_car_when_get_a_correspond_ticket () {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkTicket parkTicket=new ParkTicket();
         parkingLot.addParTicket(parkTicket);
        Car car = new Car("123");
        parkingLot.addCar(car);
        parkTicket.setCarNumber(car.getCarNumber());
        parkingLot.addParTicket(parkTicket);

        //when
        Car car1 = parkingBoy.fetchRightCar(parkTicket);
        //then
        Assertions.assertEquals(car,car1);
    }
    @Test
    public void should_return_no_car_when_get_a_ticket_is_null () {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkTicket parkTicket=null;

        //when
        Car car = parkingBoy.fetchRightCar(parkTicket);
        //then
        Assertions.assertEquals(null,car);
    }
    @Test
    public void should_return_no_car_when_get_a_wrong_ticket () {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkTicket parkTicket=new ParkTicket();


        //when
        Car car = parkingBoy.fetchRightCar(parkTicket);
        String errorMessage=parkingBoy.getErrorMessage();
        //then
        Assertions.assertEquals(null,car);
        Assertions.assertEquals("Unrecognized parking ticket.",errorMessage);

    }
    @Test
    public void should_return_no_car_when_get_a_ticket_is_used () {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkTicket parkTicket=new ParkTicket();
        parkTicket.setUsed(true);
        parkingLot.addParTicket(parkTicket);
        //when
        Car car = parkingBoy.fetchRightCar(parkTicket);
        //then
        Assertions.assertEquals(null,car);
    }
}
