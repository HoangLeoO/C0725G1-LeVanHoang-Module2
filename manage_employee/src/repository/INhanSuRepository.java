package repository;

import java.util.List;

public interface INhanSuRepository<T> {

    List<T> findAll();

    boolean save(T t);

    void update(int index,T t);

    boolean delete(T t);
}
