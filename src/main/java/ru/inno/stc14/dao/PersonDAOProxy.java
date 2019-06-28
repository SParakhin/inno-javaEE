package ru.inno.stc14.dao;

import ru.inno.stc14.entity.Person;

import java.sql.Connection;
import java.util.List;

public class PersonDAOProxy implements PersonDAO {

    private final PersonDAO personDAO;

    public PersonDAOProxy(Connection con) {
        this.personDAO = new PersonDAOImpl(con);
    }

    @Override
    public List<Person> getList() {
        List<Person> people = personDAO.getList();
        for (Person p : people) {
            p.setName(p.getName().concat(" - added with proxy pattern"));
        }
        return people;
    }

    @Override
    public boolean addPerson(Person person) {
        return personDAO.addPerson(person);
    }

    @Override
    public Person getPersonByLoginAndPassword(String login, String password) {
        return personDAO.getPersonByLoginAndPassword(login, password);
    }
}
