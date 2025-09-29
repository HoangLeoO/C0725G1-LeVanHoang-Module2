package transport.view.controller;


import transport.view.service.CarService;
import transport.view.service.ICarService;

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
