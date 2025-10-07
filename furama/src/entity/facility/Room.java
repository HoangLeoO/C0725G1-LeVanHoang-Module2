package entity.facility;

import entity.enums.RentalType;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceCode, String serviceName, double usableArea, double rentalCost, int maxPeople, RentalType rentalType, String freeService) {
        super(serviceCode, serviceName, usableArea, rentalCost, maxPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return String.format(
                "[ROOM] %s | Dịch vụ miễn phí: %s",
                super.toString(), freeService
        );
    }

}
