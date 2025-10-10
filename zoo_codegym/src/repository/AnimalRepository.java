package repository;

import entity.Animal;
import util.ReadAndWriterFile;

import java.util.List;

public class AnimalRepository implements IAnimalRepository<String> {

    private static final String PATH_FILE = "src/data/animal.csv";



    @Override
    public List<String> loadFromFile() {
        return ReadAndWriterFile.readFile(PATH_FILE);
    }

    @Override
    public void writeToFile(List<String> animals) {
        ReadAndWriterFile.writerFile(PATH_FILE, animals);
    }

    @Override
    public void appendToFile(List<String> animals, boolean isAppend) {
        ReadAndWriterFile.writerFile(PATH_FILE, animals, isAppend);
    }
}
