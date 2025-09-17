package transport.repository;

import transport.entity.Motorbike;

import java.util.Objects;

public class MotorbikeRepository implements IMotorbikeRepository {
    static Motorbike[] motorbikes = new Motorbike[100];

    static {
        motorbikes[0] = new Motorbike("40A-212.56", "Toyota", 2019, "Nguyễn Văn A", 120);
        motorbikes[1] = new Motorbike("40B-312.23", "Huyndai", 2010, "Nguyễn Văn B", 60);
    }

    @Override
    public Motorbike[] findAllMotorbike() {
        return motorbikes;
    }

    @Override
    public Motorbike getMotorbikeFindLicensePlate(String licensePlate) {
        for (Motorbike motorbike : motorbikes) {
            if (motorbike != null) {
                if (Objects.equals(motorbike.getLicensePlate(), licensePlate)) {
                    return motorbike;
                }
            }
        }
        return null;
    }

    @Override
    public void addMotorbike(Motorbike motorbike) {
        for (int i = 0; i < motorbikes.length; i++) {
            if (motorbikes[i] == null) {
                motorbikes[i] = motorbike;
                break;
            }
        }
    }

    @Override
    public void editMotorbike(Motorbike motorbike) {
        System.out.println("test repository" + motorbike.toString());
        for (Motorbike value : motorbikes) {
            if (value != null) {
                if (Objects.equals(value.getLicensePlate(), motorbike.getLicensePlate())) {
                    System.out.println(motorbike.getLicensePlate());
                    value.setManufacturer(motorbike.getManufacturer());
                    value.setYearOfManufacture(motorbike.getYearOfManufacture());
                    value.setOwner(motorbike.getOwner());
                    value.setEnginePower(motorbike.getEnginePower());
                    System.out.println("Edit thành công!");
                    break;
                }
            }
        }
    }

    @Override
    public void deleteMotorbike(String licensePlate) {
        for (int i = 0; i < motorbikes.length; i++) {
            if (motorbikes[i] != null) {
                if (Objects.equals(motorbikes[i].getLicensePlate(), licensePlate)) {
                    motorbikes[i] = null;
                    break;
                }
            }
        }
        for (int i = 0; i < motorbikes.length; i++) {
            if (i + 1 < motorbikes.length) {
                if (motorbikes[i] == null && motorbikes[i + 1] != null) {
                    for (int j = i + 1; j < motorbikes.length; j++) {
                        if (motorbikes[j] != null) {
                            Motorbike temp = motorbikes[j];
                            motorbikes[j] = motorbikes[i];
                            motorbikes[i] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }
}
