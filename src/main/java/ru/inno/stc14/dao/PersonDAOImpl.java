package ru.inno.stc14.dao;

import ru.inno.stc14.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDAOImpl implements PersonDAO {

    private static Logger logger = Logger.getLogger(PersonDAOImpl.class.getName());
    private final Connection connection;

    public PersonDAOImpl(Connection con) {
        this.connection = con;
    }

    private static final String INSERT_PERSON_SQL_TEMPLATE =
            "insert into person (name, birth_date,login,password,email,telephone) values (?, ?,?,?,?,?)";
    private static final String SELECT_PERSON_SQL_TEMPLATE =
            "select id, name, birth_date,email,telephone from person";
    private static final String SELECT_PERSON_SQL_LOGIN_PASSWORD =
            "select login,password from person where login=? and password=? ";

    @Override
    public List<Person> getList() {
        List<Person> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PERSON_SQL_TEMPLATE)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Person person = new Person.Builder()
                            .withName(resultSet.getString(2))
                            .withBirthDate(new Date(resultSet.getLong(3)))
                            .withEmail(resultSet.getString(4))
                            .withPhone(resultSet.getString(5))
                            .build();
                    person.setId(resultSet.getInt(1));
                    result.add(person);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception occurred on the DAO layer.", e);
        }
        return result;
    }

    @Override
    public boolean addPerson(Person person) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PERSON_SQL_TEMPLATE)) {
            statement.setString(1, person.getName());
            if (person.getBirthDate() == null) {
                statement.setNull(2, Types.BIGINT);
            } else {
                statement.setLong(2, person.getBirthDate().getTime());
            }
            statement.setString(3, person.getLogin());
            statement.setString(4, person.getPassword());
            statement.setString(5, person.getEmail());
            statement.setString(6, person.getTelephone());
            statement.execute();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception occurred on the DAO layer.", e);
            return false;
        }
    }

    @Override
    public Person getPersonByLoginAndPassword(String login, String password) {
        Person person = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PERSON_SQL_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    person = new Person.Builder()
                            .withLogin(resultSet.getString(1))
                            .withPassword(resultSet.getString(2))
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }
}