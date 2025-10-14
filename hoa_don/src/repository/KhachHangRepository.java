package repository;

import util.ReadAndWriterFile;

import java.util.List;

public class KhachHangRepository implements IKhachHangRepository {

    private static final String PATH_FILE = "src/data/khach_hang.csv";

    private static final String PATH_FILE_TYPE =  "src/data/loai_khach.csv";

    @Override
    public List<String> loadFromFile() {
        return ReadAndWriterFile.readFile(PATH_FILE);
    }


    @Override
    public void writeToFile(List<String> items) {
        ReadAndWriterFile.writerFile(PATH_FILE, items);
    }
    @Override
    public List<String> loadFromType() {
        return ReadAndWriterFile.readFile(PATH_FILE_TYPE);
    }
}
