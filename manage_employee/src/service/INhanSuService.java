package service;

import java.util.List;

public interface INhanSuService<T> {

    T findById(String id);

    List<T> findAll();

    boolean save(T t);

    void update(T t);

    boolean delete(T t);

    List<T> findAllSearch(String name);
}
