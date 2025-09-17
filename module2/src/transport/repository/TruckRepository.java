package transport.repository;

import transport.entity.Truck;

import java.util.Objects;

public class TruckRepository implements ITruckRepository {
    static Truck[] trucks = new Truck[100];

    static {
        trucks[0] = new Truck("41A-212.56", "Toyota", 2019, "Nguyễn Văn A", 10);
        trucks[1] = new Truck("41B-312.23", "Huyndai", 2010, "Nguyễn Văn B", 5);
    }

    @Override
    public Truck[] findAllTruck() {
        return trucks;
    }

    @Override
    public Truck getTruckFindLicensePlate(String licensePlate) {
        for (Truck truck : trucks) {
            if (truck != null) {
                if (Objects.equals(truck.getLicensePlate(), licensePlate)) {
                    return truck;
                }
            }
        }
        return null;
    }

    @Override
    public void addTruck(Truck truck) {
        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i] == null) {
                trucks[i] = truck;
                break;
            }
        }
    }

    @Override
    public void editTruck(Truck truck) {
        System.out.println("test repository" + truck.toString());
        for (Truck value : trucks) {
            if (value != null) {
                if (Objects.equals(value.getLicensePlate(), truck.getLicensePlate())) {
                    System.out.println(truck.getLicensePlate());
                    value.setManufacturer(truck.getManufacturer());
                    value.setYearOfManufacture(truck.getYearOfManufacture());
                    value.setOwner(truck.getOwner());
                    value.setPayloadCapacity(truck.getPayloadCapacity());
                    System.out.println("Edit thành công!");
                    break;
                }
            }
        }
    }

    @Override
    public void deleteTruck(String licensePlate) {
        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i] != null) {
                if (Objects.equals(trucks[i].getLicensePlate(), licensePlate)) {
                    trucks[i] = null;
                    break;
                }
            }
        }
        for (int i = 0; i < trucks.length; i++) {
            if (i + 1 < trucks.length) {
                if (trucks[i] == null && trucks[i + 1] != null) {
                    for (int j = i + 1; j < trucks.length; j++) {
                        if (trucks[j] != null) {
                            Truck temp = trucks[j];
                            trucks[j] = trucks[i];
                            trucks[i] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }
}
