package repository;

import util.ReadAndWriterFile;

import java.util.List;

public class DonHangRepository implements  IDonHangRepository{

    private static final String PATH_FILE = "src/data/don_hang.csv";

    @Override
    public List<String> loadFromFile() {
        return ReadAndWriterFile.readFile(PATH_FILE);
    }

    @Override
    public void writeToFile(List<String> items) {
        ReadAndWriterFile.writerFile(PATH_FILE,items);
    }

    @Override
    public void appendToFile(List<String> items, boolean isAppend) {
        ReadAndWriterFile.writerFile(PATH_FILE,items,isAppend);
    }
}
