package ru.inno.stc14.service;

import ru.inno.stc14.dao.PersonDAO;
import ru.inno.stc14.dao.PersonDAOImpl;
import ru.inno.stc14.entity.Person;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonServiceImpl implements PersonService {
    private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());
    private final PersonDAO personDAO;

    public PersonServiceImpl(Connection con) {
        personDAO = new PersonDAOImpl(con);
    }

    @Override
    public List<Person> getList() {
        return personDAO.getList();
    }

    @Override
    public boolean addPerson(String name, String birth, String email, String telephone, String login, String password) {
        Person person = new Person();
        person.setName(name);
        Date date = safeParseDate(birth);
        person.setBirthDate(date);
        person.setEmail(email);
        person.setTelephone(telephone);
        person.setLogin(login);
        person.setPassword(password);
        return personDAO.addPerson(person);
    }

    @Override
    public Person getPersonByLoginAndPassword(String login, String password) {
        return personDAO.getPersonByLoginAndPassword(login, password);
    }

    private Date safeParseDate(String birthStr) {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(birthStr);
        } catch (ParseException e) {
            logger.log(Level.SEVERE, "Date parsing error", e);
            throw new RuntimeException(e);
        }
    }
}