package transport.Controller;


import transport.entity.Car;
import transport.service.CarService;
import transport.service.ICarService;
import transport.view.CarView;

public class CarController {
    static ICarService carService = new CarService();

    public static void showListCar() {
        Car[] cars = (Car[]) carService.findAllTransport();
        CarView.showAllCar(cars);
    }

    public static void addCar() {
        carService.addTransport(CarView.addCar());
    }
}
