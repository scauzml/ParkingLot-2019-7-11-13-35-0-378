package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
