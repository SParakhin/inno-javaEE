package ru.inno.stc14.dao.jdbc;

import java.sql.Connection;

public interface ConnectionManager {

    Connection getConnection();
}
