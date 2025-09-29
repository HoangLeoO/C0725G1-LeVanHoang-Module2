package transport.repository;


import transport.entity.Car;
import transport.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CarRepository implements ICarRepository {

    private final String PATH_CAR = "src/transport/data/car.csv";

    @Override
    public List<Car> findAllTransport() {
        List<Car> cars = new ArrayList<>();
        List<String> stringFile = ReadAndWriteFile.readFromCSV(PATH_CAR);
        String[] array = null;
        for (String string : stringFile) {
            array = string.split(",");
            cars.add(new Car(array[0], array[1], Integer.parseInt(array[2]), array[3], Integer.parseInt(array[4]), array[5]));
        }
        return cars;
    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
        List<Car> cars = findAllTransport();
        for (Car car : cars) {
            if (car != null && Objects.equals(car.getLicensePlate(), licensePlate)) {
                System.out.println(car);
                return car;
            }
        }
        return null;
    }

    @Override
    public void addTransport(Car car) {
        List<String> strings = new ArrayList<>();
        strings.add(car.getInfoToSCV());
        ReadAndWriteFile.writerToFileCSV(PATH_CAR, strings, true);
    }

    @Override
    public void editTransport(Car car) {
        List<Car> cars = findAllTransport();
        for (Car car1 : cars) {
            if (car1.getLicensePlate().equals(car.getLicensePlate())) {
                car1.updateFrom(car);
            }
        }
        // Ghi lại file
        List<String> strings = new ArrayList<>();
        for (Car c : cars) {
            strings.add(c.getInfoToSCV());
        }
        ReadAndWriteFile.writerToFileCSV(PATH_CAR, strings);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        List<Car> cars = findAllTransport();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlate().equals(licensePlate)) {
                cars.remove(cars.get(i));
            }
        }
        // Ghi lại file
        List<String> strings = new ArrayList<>();
        for (Car c : cars) {
            strings.add(c.getInfoToSCV());
        }
        ReadAndWriteFile.writerToFileCSV(PATH_CAR, strings, false);
    }
}
