package transport.service;

import transport.entity.Car;
import transport.repository.CarRepository;
import transport.repository.ICarRepository;

public class CarService implements ICarService {
    ICarRepository carRepository = new CarRepository();

    @Override
    public Car[] findAllCar() {
        return carRepository.findAllCar();
    }

    @Override
    public Car getCarFindLicensePlate(String licensePlate) {
        return carRepository.getCarFindLicensePlate(licensePlate);
    }

    @Override
    public void addCar(Car car) {
        carRepository.addCar(car);
        System.out.println(" Thêm phương tiện mới có biển số xe " + car.getLicensePlate() + "thành công !");
    }

    @Override
    public void editCar(Car car) {
        carRepository.editCar(car);
    }

    @Override
    public void delete(String licensePlate) {
        carRepository.delete(licensePlate);
    }
}
