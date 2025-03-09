package com.hexagonaljava.infrastructure.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionDb {
    Connection getConexion() throws SQLException;
}
