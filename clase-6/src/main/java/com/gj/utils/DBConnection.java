package com.gj.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static final String URL = "jdbc:postgresql://localhost:5432/registrosdb";
    public static final String USER = "postgres";
    public static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection get() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}