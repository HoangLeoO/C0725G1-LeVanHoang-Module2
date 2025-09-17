package transport.repository;

import transport.entity.Car;
import transport.entity.Truck;

public interface ITruckRepository {
    Truck[] findAllTruck();

    Truck getTruckFindLicensePlate(String licensePlate);

    void addTruck(Truck truck);

    void editTruck(Truck truck);

    void deleteTruck(String licensePlate);
}
