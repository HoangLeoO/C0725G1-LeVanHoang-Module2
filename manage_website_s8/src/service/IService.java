package service;

import java.util.List;

public interface IService<T> {
    List<T>  findAll();

    List<T>  findByName(String name);

    T findByCode(String Code);

    boolean addItem(T item);

    boolean deleteItem(T item);
}
