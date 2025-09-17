package transport.repository;

import transport.entity.Car;

import java.util.Objects;

public class CarRepository implements ICarRepository {
    public static Car[] cars = new Car[100];

    static {
        cars[0] = new Car("43A-212.56", "Toyota", 2019, "Nguyễn Văn A", 7, "Du Lịch");
        cars[1] = new Car("43B-312.23", "Huyndai", 2010, "Nguyễn Văn B", 45, "Xe khách");
        cars[2] = new Car("43C-441.44", "Toyota", 2020, "Nguyễn Văn D", 16, "Xe khách");
        cars[3] = new Car("43D-523.33", "Ford", 2015, "Nguyễn Văn E", 4, "Du Lịch");
    }

    @Override
    public Car[] findAllCar() {
        return cars;
    }

    @Override
    public Car getCarFindLicensePlate(String licensePlate) {
        for (Car car : cars) {
            if (car != null) {
                if (Objects.equals(car.getLicensePlate(), licensePlate)) {
                    return car;
                }
            }
        }
        return null;
    }

    @Override
    public void addCar(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = car;
                break;
            }
        }
    }

    @Override
    public void editCar(Car car) {
        System.out.println("test repository" + car.toString());
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (Objects.equals(cars[i].getLicensePlate(), car.getLicensePlate())) {
                    System.out.println(car.getLicensePlate());
                    cars[i].setManufacturer(car.getManufacturer());
                    cars[i].setYearOfManufacture(car.getYearOfManufacture());
                    cars[i].setOwner(car.getOwner());
                    cars[i].setNumberOfSeats(car.getNumberOfSeats());
                    cars[i].setVehicleType(car.getVehicleType());
                    System.out.println("Edit thành công!");
                    break;
                }
            }
        }
    }

    @Override
    public void delete(String licensePlate) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (Objects.equals(cars[i].getLicensePlate(), licensePlate)) {
                    cars[i] = null;
                    break;
                }
            }
        }
        for (int i = 0; i < cars.length; i++) {
            if (i + 1 < cars.length) {
                if (cars[i] == null && cars[i + 1] != null) {
                    for (int j = i + 1; j < cars.length; j++) {
                        if (cars[j] != null) {
                            Car temp = cars[j];
                            cars[j] = cars[i];
                            cars[i] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }
}
