package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    public void should_return_true_or_false_when_add_a_car() {
        //given
        ParkingLot parlingLot=new ParkingLot();
        Car car = new Car();
        //when
        boolean isSuccess=parlingLot.addCar(car);
        //then
        Assertions.assertEquals(true,isSuccess);
    }
}
