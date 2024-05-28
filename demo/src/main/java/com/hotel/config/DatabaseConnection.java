package com.hotel.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/db_hotelUBC";
    private static final String USER = "postgres";  
    private static final String PASSWORD = "admin";  

    public static Connection getConnection() throws SQLException {
        try {
            // Carregar o driver JDBC
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver do Banco de Dados não encontrado.");
        }
        // Estabelecer a conexão
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            System.out.println("Conexão estabelecida com sucesso!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
