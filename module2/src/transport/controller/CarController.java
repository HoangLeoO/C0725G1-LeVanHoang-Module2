package transport.controller;

import transport.entity.Car;
import transport.service.CarService;
import transport.service.ICarService;
import transport.view.CarView;

import java.util.Scanner;

public class CarController {
    static ICarService carService = new CarService();
    static Scanner scanner = new Scanner(System.in);

    public static void showListCar() {
        Car[] cars = carService.findAllCar();
        CarView.showAllCar(cars);
    }

    public static void addCar() {
        carService.addCar(CarView.addCar());
    }
}
