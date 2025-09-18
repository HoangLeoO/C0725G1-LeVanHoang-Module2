package transport_v2.service;


import transport_v2.entity.Transport;
import transport_v2.repository.IMotorbikeRepository;
import transport_v2.repository.MotorbikeRepository;

public class MotorbikeService implements IMotorbikeService {

    IMotorbikeRepository motorbikeRepository = new MotorbikeRepository();

    @Override
    public Transport[] findAllTransport() {
        return motorbikeRepository.findAllTransport();
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        return motorbikeRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public void addTransport(Transport transport) {
        motorbikeRepository.addTransport(transport);
    }

    @Override
    public void editTransport(Transport transport) {
        motorbikeRepository.editTransport(transport);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        motorbikeRepository.deleteTransport(licensePlate);
    }
}
