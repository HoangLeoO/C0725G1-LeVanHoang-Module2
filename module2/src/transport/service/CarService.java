package transport.service;


import transport.entity.Car;

import transport.repository.CarRepository;
import transport.repository.ICarRepository;

import java.util.List;

public class CarService implements ICarService {

    ICarRepository carRepository = new CarRepository();

    @Override
    public List<Car> findAllTransport() {
        return carRepository.findAllTransport();
    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public void addTransport(Car car) {
        carRepository.addTransport(car);
    }


    @Override
    public void editTransport(Car car) {
        carRepository.editTransport(car);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        carRepository.deleteTransport(licensePlate);
    }
}
