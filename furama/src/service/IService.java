package service;

import java.util.List;

public interface IService<T> {
    T findCode(String code);

    List<T> findAll();

    boolean add(T object);

    void edit(T object);

    boolean deleteByCode(String code);
}
