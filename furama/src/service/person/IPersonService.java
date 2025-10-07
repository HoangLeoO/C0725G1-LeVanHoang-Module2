package service.person;

import entity.person.Person;
import service.IService;

import java.util.List;

public interface IPersonService extends IService<Person> {
    List<Person> findFullName(String fullName);
}
