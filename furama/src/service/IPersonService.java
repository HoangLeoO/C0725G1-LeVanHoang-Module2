package service;

import java.util.List;

public interface IPersonService<T> {
    List<T> findAll();

    List<T> findFullName(String fullName);

    T findCode(String code);

    boolean add(T object);

    void edit(T object);

    boolean deleteByCode(String code);
}
