package transport.view.service;


import transport.view.entity.Car;

import java.util.List;

public class CarService implements ICarService {

    @Override
    public List<Car> findAllTransport() {
        return List.of();
    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
        return null;
    }

    @Override
    public void addTransport(Car object) {

    }


    @Override
    public void editTransport(Car object) {

    }

    @Override
    public void deleteTransport(String licensePlate) {

    }
}
