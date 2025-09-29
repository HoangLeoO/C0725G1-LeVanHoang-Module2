package transport.repository;

import transport.entity.Motorbike;
import transport.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MotorbikeRepository implements IMotorbikeRepository {

    private static final String PATH_MOTORBIKE = "src/transport/data/motorbike.csv";

    @Override
    public List<Motorbike> findAllTransport() {
        List<Motorbike> motorbikes = new ArrayList<>();
        List<String> stringFile = ReadAndWriteFile.readFromCSV(PATH_MOTORBIKE);
        String[] array;
        for (String string : stringFile) {
            array = string.split(",");
            motorbikes.add(new Motorbike(array[0], array[1], Integer.parseInt(array[2]), array[3], Double.parseDouble(array[4])));
        }
        return motorbikes;
    }

    @Override
    public Motorbike findByLicensePlate(String licensePlate) {
        List<Motorbike> motorbikes = findAllTransport();
        for (Motorbike m : motorbikes) {
            if (m != null && Objects.equals(m.getLicensePlate(), licensePlate)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void addTransport(Motorbike motorbike) {
        List<String> strings = new ArrayList<>();
        strings.add(motorbike.getInfoToSCV());
        ReadAndWriteFile.writerToFileCSV(PATH_MOTORBIKE, strings, true);
    }

    @Override
    public void editTransport(Motorbike motorbike) {
        List<Motorbike> motorbikes = findAllTransport();
        for (Motorbike m : motorbikes) {
            if (m.getLicensePlate().equals(motorbike.getLicensePlate())) {
                m.updateFrom(motorbike);
            }
        }
        List<String> strings = new ArrayList<>();
        for (Motorbike m : motorbikes) {
            strings.add(m.getInfoToSCV());
        }
        ReadAndWriteFile.writerToFileCSV(PATH_MOTORBIKE, strings, false);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        List<Motorbike> motorbikes = findAllTransport();
        motorbikes.removeIf(m -> m.getLicensePlate().equals(licensePlate));

        List<String> strings = new ArrayList<>();
        for (Motorbike m : motorbikes) {
            strings.add(m.getInfoToSCV());
        }
        ReadAndWriteFile.writerToFileCSV(PATH_MOTORBIKE, strings, false);
    }
}
