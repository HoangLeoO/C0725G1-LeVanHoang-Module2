package repository.person;

import entity.person.Person;
import repository.IRepository;

import java.util.List;

public interface IPersonRepository extends IRepository<Person> {

    List<Person> findFullName(String fullName);

}
