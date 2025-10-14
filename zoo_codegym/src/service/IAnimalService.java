package service;

import java.util.List;

public interface IAnimalService<T> {

    List<T> findAll();

    boolean add(T animal);

    boolean deleteByCode(String codeAnimal);

    boolean  update(T animal);

    List<T> findByName(String name);

    T findByCode(String code);

}
