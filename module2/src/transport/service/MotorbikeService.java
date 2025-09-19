package transport.service;


import transport.entity.Motorbike;

import java.util.List;

public class MotorbikeService implements IMotorbikeService {


    @Override
    public List<Motorbike> findAllTransport() {
        return List.of();
    }

    @Override
    public Motorbike findByLicensePlate(String licensePlate) {
        return null;
    }

    @Override
    public void addTransport(Motorbike object) {

    }

    @Override
    public void editTransport(Motorbike object) {

    }

    @Override
    public void deleteTransport(String licensePlate) {

    }
}
