package repository;

import java.util.List;

public interface IRepository <T>{
    List<T> loadFromFile();

    void writeToFile(List<T> items);

    void appendToFile(List<T> items,boolean isAppend);
}
