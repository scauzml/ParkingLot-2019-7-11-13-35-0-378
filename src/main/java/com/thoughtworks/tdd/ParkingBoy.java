package com.thoughtworks.tdd;

import com.sun.deploy.util.StringUtils;
import com.thoughtworks.tdd.messageenum.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
     private ParkingLot parkingLot;
     private String errorMessage;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy() {
    }

    public ParkTicket park(Car car) {

        ParkTicket parkTicket =null;

        if (car != null) {
            //查找car是否已经停过
            boolean isParkedCar = parkingLot.isContainCar(car);
            if (!isParkedCar) {
                boolean isCapacityEnough=this.parkingLot.isCapacityEnough();
                if (isCapacityEnough) {
                    parkTicket=new ParkTicket();
                    //关联ticket,与car,而且停车场添加ticket
                    parkTicket.setCarNumber(car.getCarNumber());
                    parkingLot.addParTicket(parkTicket);
                    parkingLot.addCar(car);
                }else {
                    this.errorMessage=ErrorMessage.NOT_ENOUGH_CAPACITY_MESSAGE.getValue();
                }
            }

        }


        return parkTicket;
    }

    public List<ParkTicket> parkCarList(List<Car> carList) {
        List<ParkTicket> list = new ArrayList<>();
        carList.forEach(e->{
            ParkTicket parkTicket = this.park(e);
            list.add(parkTicket);
        });
        return list;
    }

    public Car fetchRightCar(ParkTicket parkTicket) {
        Car car=null;
        //验证pakTicket是wrong
        if (parkTicket != null) {
            boolean isRightTicket=parkingLot.isContainParkTicket(parkTicket);
            if (isRightTicket) {
                if (!parkTicket.isUsed()) {
                    //没有被使用则获取正确car
                   car= this.parkingLot.getCars().stream().
                           filter(e->e.getCarNumber()==parkTicket.getCarNumber()).findFirst().get();
                   this.parkingLot.getCars().remove(car);
                   this.parkingLot.getParkTicketList().remove(parkTicket);

                }else {
                    this.errorMessage= ErrorMessage.WRONG_TICKET_MESSAGE.getValue();
                }
            }else {
                this.errorMessage= ErrorMessage.WRONG_TICKET_MESSAGE.getValue();
            }

        }else {
            this.errorMessage=ErrorMessage.NOT_PROVIDE_TOKET_MESSAGE.getValue();
        }

        return car;
    }
}
