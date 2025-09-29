package transport.service;


import transport.entity.Motorbike;
import transport.repository.IMotorbikeRepository;
import transport.repository.MotorbikeRepository;

import java.util.List;

public class MotorbikeService implements IMotorbikeService {

    private IMotorbikeRepository motorbikeRepository = new MotorbikeRepository();

    @Override
    public List<Motorbike> findAllTransport() {
        return motorbikeRepository.findAllTransport();
    }
    @Override
    public Motorbike findByLicensePlate(String licensePlate) {
        return motorbikeRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public void addTransport(Motorbike object) {
        motorbikeRepository.addTransport(object);
    }

    @Override
    public void editTransport(Motorbike object) {
        motorbikeRepository.editTransport(object);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        motorbikeRepository.deleteTransport(licensePlate);
    }
}
