package entity.facility;

import entity.enums.RentalType;

import java.util.Objects;

public class House extends Facility {
    private String roomStandard;
    private int numFloors;

    public House() {
    }

    public House(String roomStandard, int numFloors) {
        this.roomStandard = roomStandard;
        this.numFloors = numFloors;
    }

    public House(String serviceCode, String serviceName, double usableArea, double rentalCost, int maxPeople, RentalType rentalType, String roomStandard, int numFloors) {
        super(serviceCode, serviceName, usableArea, rentalCost, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numFloors = numFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
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
                "[HOUSE] %s | Tiêu chuẩn phòng: %s | Số tầng: %d",
                super.toString(), roomStandard, numFloors
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        House house = (House) o;
        return numFloors == house.numFloors && Objects.equals(roomStandard, house.roomStandard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomStandard, numFloors);
    }
}
