package hotel.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DatabaseConfig {
    // Usando o PostgreSQL como banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/db_hotelMgmtSys";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTables() throws SQLException {
        try (Connection conexao = getConnection()) {
            DatabaseMetaData dbm = conexao.getMetaData();
            // Verifica a existência da tabela "quarto"
            ResultSet tablesQuarto = dbm.getTables(null, null, "quarto", null);
            if (!tablesQuarto.next()) {
                String sqlQuarto =
                        "CREATE TABLE quarto (" +
                                "id serial PRIMARY KEY," +
                                "numero int NOT NULL," +
                                "tipo varchar(50) NOT NULL," +
                                "capacidade int NOT NULL," +
                                "disponivel boolean NOT NULL" +
                                ");";
                Statement statement = conexao.createStatement();
                statement.execute(sqlQuarto);
            }
            // Verifica a existência da tabela "reserva"
            ResultSet tablesReserva = dbm.getTables(null, null, "reserva", null);
            if (!tablesReserva.next()) {
                String sqlReserva =
                        "CREATE TABLE reserva (" +
                                "id serial PRIMARY KEY," +
                                "id_quarto int NOT NULL," +
                                "data_inicio date NOT NULL," +
                                "data_fim date NOT NULL," +
                                "CONSTRAINT id_quarto_fk FOREIGN KEY (id_quarto)" +
                                "REFERENCES quarto(id)" +
                                ");";
                Statement statement = conexao.createStatement();
                statement.execute(sqlReserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
