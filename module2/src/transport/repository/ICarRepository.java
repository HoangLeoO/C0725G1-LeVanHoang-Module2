package transport.repository;

import transport.entity.Car;

public interface ICarRepository {

    Car[] findAllCar();

    Car getCarFindLicensePlate(String licensePlate);

    void addCar(Car car);

    void editCar(Car car);

    void delete(String licensePlate);
}
