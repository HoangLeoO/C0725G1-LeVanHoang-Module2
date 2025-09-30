package repository.Person;

import entity.person.Person;
import repository.IService;

import java.util.List;

public interface IPersonRepository extends IService<Person> {

    List<Person> findFullName(String fullName);

}
