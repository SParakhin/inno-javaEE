package ru.inno.stc14.service;

import ru.inno.stc14.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getList();

    boolean addPerson(String name, String birth, String login, String password);

    Person getPersonByLoginAndPassword(String login, String password);
}
