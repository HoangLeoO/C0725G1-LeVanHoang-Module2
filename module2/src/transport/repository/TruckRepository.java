package transport.repository;

import transport.entity.Truck;
import transport.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TruckRepository implements ITruckRepository {

    private static final String PATH_TRUCK = "src/transport/data/truck.csv";

    @Override
    public List<Truck> findAllTransport() {
        List<Truck> trucks = new ArrayList<>();
        List<String> stringFile = ReadAndWriteFile.readFromCSV(PATH_TRUCK);
        String[] array;
        for (String string : stringFile) {
            array = string.split(",");
            trucks.add(new Truck(array[0], array[1], Integer.parseInt(array[2]), array[3], Double.parseDouble(array[4])));
        }
        return trucks;
    }

    @Override
    public Truck findByLicensePlate(String licensePlate) {
        List<Truck> trucks = findAllTransport();
        for (Truck truck : trucks) {
            if (truck != null && Objects.equals(truck.getLicensePlate(), licensePlate)) {
                return truck;
            }
        }
        return null;
    }

    @Override
    public void addTransport(Truck truck) {
        List<String> strings = new ArrayList<>();
        strings.add(truck.getInfoToSCV());
        ReadAndWriteFile.writerToFileCSV(PATH_TRUCK, strings, true);
    }

    @Override
    public void editTransport(Truck truck) {
        List<Truck> trucks = findAllTransport();
        for (Truck t : trucks) {
            if (t.getLicensePlate().equals(truck.getLicensePlate())) {
                t.updateFrom(truck);
            }
        }
        List<String> strings = new ArrayList<>();
        for (Truck t : trucks) {
            strings.add(t.getInfoToSCV());
        }
        ReadAndWriteFile.writerToFileCSV(PATH_TRUCK, strings, false);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        List<Truck> trucks = findAllTransport();
        trucks.removeIf(t -> t.getLicensePlate().equals(licensePlate));

        List<String> strings = new ArrayList<>();
        for (Truck t : trucks) {
            strings.add(t.getInfoToSCV());
        }
        ReadAndWriteFile.writerToFileCSV(PATH_TRUCK, strings, false);
    }
}
