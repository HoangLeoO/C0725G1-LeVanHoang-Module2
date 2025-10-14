package repository;

import util.ReadAndWriterFile;

import java.util.List;

public class HoaDonRepository implements IHoaDonRepository{

    private static final String PATH_FILE = "src/data/hoa_don.csv";

    @Override
    public List<String> loadFromFile() {
        return ReadAndWriterFile.readFile(PATH_FILE);
    }

    @Override
    public void writeToFile(List<String> items) {
        ReadAndWriterFile.writerFile(PATH_FILE, items);
    }

}
