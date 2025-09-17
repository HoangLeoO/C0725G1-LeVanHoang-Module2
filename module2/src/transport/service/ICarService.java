package transport.service;

import transport.entity.Car;

public interface ICarService {

    Car[] findAllCar();

    Car getCarFindLicensePlate(String licensePlate);

    void addCar(Car car);

    void editCar(Car car);

    void delete(String licensePlate);
}
