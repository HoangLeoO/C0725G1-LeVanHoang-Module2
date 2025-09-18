package transport_v2.Controller;


import transport_v2.entity.Car;
import transport_v2.service.CarService;
import transport_v2.service.ICarService;
import transport_v2.view.CarView;

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
