package transport.controller;


import transport.entity.Car;
import transport.service.CarService;
import transport.service.ICarService;
import transport.view.CarView;
import transport.view.TransportView;

import java.util.List;

public class CarController {
    static ICarService carService = new CarService();

    public static void showListCar() {
        List<Car> cars = carService.findAllTransport();
        CarView.showAllCar(cars);
    }

    public static void addCar() {
        carService.addTransport(CarView.addCar());
    }

    public static void editCar(Car car) {
        carService.editTransport(car);
    }

    public static Car searchCar(String plate) {
        return carService.findByLicensePlate(plate);
    }

    public static void deleteCar(String plate) {
        carService.deleteTransport(plate);
    }
}
