package transport.service;

import transport.entity.Transport;
import transport.repository.CarRepository;
import transport.repository.ICarRepository;

public class CarService implements ICarService {
    ICarRepository carRepository = new CarRepository();
    @Override
    public Transport[] findAllTransport() {
        return carRepository.findAllTransport();
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public void addTransport(Transport transport) {
        carRepository.addTransport(transport);
    }

    @Override
    public void editTransport(Transport transport) {
        carRepository.editTransport(transport);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        carRepository.deleteTransport(licensePlate);
    }
}
