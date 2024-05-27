package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConnection;
import model.Reserva;

public class ReservaDAO {

    public List<Reserva> getAllReservas() {
        List<Reserva> reservas = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Reservas";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getInt("id_reservas"),
                        rs.getDate("data_inicio"),
                        rs.getDate("data_fim"),
                        rs.getInt("id_hospedes"),
                        rs.getInt("id_quarto")
                );
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public void addReserva(Reserva reserva) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Reservas (id_reservas, data_inicio, data_fim, id_hospedes, id_quarto) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, reserva.getIdReservas());
            stmt.setDate(2, new java.sql.Date(reserva.getDataInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(reserva.getDataFim().getTime()));
            stmt.setInt(4, reserva.getIdHospedes());
            stmt.setInt(5, reserva.getIdQuarto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReserva(Reserva reserva) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Reservas SET data_inicio = ?, data_fim = ?, id_hospedes = ?, id_quarto = ? WHERE id_reservas = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setDate(1, new java.sql.Date(reserva.getDataInicio().getTime()));
            stmt.setDate(2, new java.sql.Date(reserva.getDataFim().getTime()));
            stmt.setInt(3, reserva.getIdHospedes());
            stmt.setInt(4, reserva.getIdQuarto());
            stmt.setInt(5, reserva.getIdReservas());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReserva(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Reservas WHERE id_reservas = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();}
        }
}