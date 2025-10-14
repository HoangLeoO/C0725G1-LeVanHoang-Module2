package repository;

import entity.Animal;

import java.util.List;

public interface IAnimalRepository<T> {
    List<T> loadFromFile();

    void writeToFile(List<T> animals);

    void appendToFile(List<T> animals,boolean isAppend);

}
