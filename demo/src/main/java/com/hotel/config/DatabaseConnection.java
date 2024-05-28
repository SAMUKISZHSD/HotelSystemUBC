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
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver do Banco de Dados não encontrado.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


// `private static final String URL = "jdbc:postgresql://localhost:5432/seuBancoDeDados";` : Esta linha define a URL do seu banco de dados PostgreSQL. Você deve substituir `seuBancoDeDados` pelo nome do seu banco de dados.

//`private static final String USER = "seuUsuario";` : Esta linha define o nome de usuário para se conectar ao seu banco de dados PostgreSQL. Você deve substituir `seuUsuario` pelo seu nome de usuário do banco de dados.

//`private static final String PASSWORD = "suaSenha";` : Esta linha define a senha para se conectar ao seu banco de dados PostgreSQL. Você deve substituir `suaSenha` pela sua senha do banco de dados.

//`public static Connection getConnection() throws SQLException {...}` : Este é um método que tenta estabelecer uma conexão com o banco de dados usando as informações fornecidas acima. Ele retorna um objeto `Connection` que pode ser usado para interagir com o banco de dados.

//`Class.forName("org.postgresql.Driver");` : Esta linha carrega o driver do banco de dados PostgreSQL. Se o driver não for encontrado, ele lançará uma exceção `ClassNotFoundException`.

//`return DriverManager.getConnection(URL, USER, PASSWORD);` : Esta linha tenta estabelecer uma conexão com o banco de dados usando a URL, o nome de usuário e a senha fornecidos. Se a conexão não puder ser estabelecida, ele lançará uma exceção `SQLException`.


