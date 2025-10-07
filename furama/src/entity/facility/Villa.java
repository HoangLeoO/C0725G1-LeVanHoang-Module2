package entity.facility;

import entity.enums.RentalType;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int numFloors;

    public Villa() {
    }

    public Villa(String roomStandard, double poolArea, int numFloors) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numFloors = numFloors;
    }

    public Villa(String serviceCode, String serviceName, double usableArea, double rentalCost, int maxPeople, RentalType rentalType, String roomStandard, double poolArea, int numFloors) {
        super(serviceCode, serviceName, usableArea, rentalCost, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numFloors = numFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    @Override
    public String toString() {
        return String.format(
                "[VILLA] %s | Tiêu chuẩn phòng: %s | Diện tích hồ bơi: %.2f | Số tầng: %d",
                super.toString(), roomStandard, poolArea, numFloors
        );
    }
}
