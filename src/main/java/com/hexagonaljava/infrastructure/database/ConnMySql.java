package com.hexagonaljava.infrastructure.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.hexagonaljava.config.HexaSingleton;

public class ConnMySql implements ConnectionDb {

    @Override
    public Connection getConexion() throws SQLException {
        HexaSingleton config = HexaSingleton.INSTANCIA;

        String url = config.get("db.url"); // Clave corregida
        String usuario = config.get("db.user"); // Clave corregida
        String password = config.get("db.password"); // Clave corregida

        System.out.println("🔌 Conectando a la base de datos con usuario: " + usuario);
        return DriverManager.getConnection(url, usuario, password);
    }
}
