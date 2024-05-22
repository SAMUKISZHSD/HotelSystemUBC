package hotel.example.model.dao;

import java.util.ArrayList;
import java.util.List;

import hotel.example.config.DatabaseConfig;
import hotel.example.model.entity.Quarto;
// Para definir a data da reserva
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// query
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class QuartoDAO implements IDAO<Quarto> {

    // >>>>> OPERAÇÕES NA TABELA QUARTO
    @Override
    public void cadastrar(Quarto entidade) {
        String sql = "INSERT INTO quarto (numero, tipo, precoDiaria) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, entidade.getNumero());
                stmt.setString(2, entidade.getTipo());
                stmt.setDouble(3, entidade.getPrecoDiaria());

                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ... restante do código ...
    @Override
    public List<Quarto> listar() {
        List<Quarto> quartos = new ArrayList<Quarto>();
        String sql = "SELECT * FROM quarto";
        
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    int id = rs.getInt("id");
                    int numero = rs.getInt("numero");
                    String tipo = rs.getString("tipo");
                    double precoDiaria = rs.getDouble("precoDiaria");
                    Quarto quarto = new Quarto(id, numero, tipo, precoDiaria);
                    quartos.add(quarto);
                }

                return quartos;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    // >>>>> OPERAÇÕES NA TABELA RESERVAS
    @Override
    public Quarto buscarReserva(int id) {
        String sql = "SELECT * FROM reservas WHERE id_quarto = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                if(rs.next()) {
                    Quarto quarto = buscar(id);
                    quarto.setReservaCliente(rs.getString("cliente"));
                    quarto.setReservaFuncionario(rs.getString("funcionario"));
                    quarto.setDt_reserva(rs.getString("dt_reserva"));
                    
                    return quarto;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void reservar(Quarto entidade) {
        String sql = "INSERT INTO reservas (cliente, funcionario, dt_reserva, id_quarto) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                // No momento estou controlando a data de reserva como String. 
                LocalDateTime agora = LocalDateTime.now();
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dataFormatada = agora.format(formatador);

                stmt.setString(1, entidade.getReservaCliente());
                stmt.setString(2, entidade.getReservaFuncionario());
                stmt.setString(3, dataFormatada);
                stmt.setInt(4, entidade.getId());

                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void cancelarReserva(int id_quarto) {
        String sql = "DELETE FROM reservas WHERE id_quarto = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id_quarto);

                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Quarto> listarReservas() {
        List<Quarto> quartos = new ArrayList<Quarto>();
        String sql = "SELECT * FROM reservas";
        
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    Quarto quarto = buscar(rs.getInt("id_quarto"));
                    quartos.add(quarto);
                }

                return quartos;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }
}
