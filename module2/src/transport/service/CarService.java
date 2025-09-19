package transport.service;

import ss5_access_modifier_static.thuc_hanh.thuc_hanh2.Car;

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
