package service.person;

import entity.person.Person;
import repository.person.IPersonRepository;

import java.util.List;

public class PersonService implements IPersonService{

    private IPersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return List.of();
    }

    @Override
    public List<Person> findFullName(String fullName) {
        return List.of();
    }

    @Override
    public Person findCode(String code) {
        return null;
    }

    @Override
    public boolean add(Person object) {
        return false;
    }

    @Override
    public void edit(Person object) {

    }

    @Override
    public boolean deleteByCode(String code) {
        return false;
    }
}
