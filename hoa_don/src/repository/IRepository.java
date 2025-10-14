package repository;

import java.util.List;

public interface IRepository<T> {
    List<T> loadFromFile();

    void writeToFile(List<T> items);

}
