package transport.controller;


import transport.service.CarService;
import transport.service.ICarService;

public class CarController {
    static ICarService carService = new CarService();

    public static void showListCar() {
//        Car[] cars = (Car[]) carService.findAllTransport();
//        CarView.showAllCar(cars);
    }

    public static void addCar() {
//        carService.addTransport(CarView.addCar());
    }
}
