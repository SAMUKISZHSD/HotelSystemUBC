package com.hotel.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.config.DatabaseConnection;
import com.hotel.model.Reserva;

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
                        rs.getDate("data_checkin"),
                        rs.getDate("data_checkout"),
                        rs.getString("status_reserva"),  // Assumindo que há uma coluna para status_reserva
                        rs.getInt("id_hospedes"),
                        rs.getInt("id_funcionario"),    // Assumindo que há uma coluna para id_funcionario
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
            String query = "INSERT INTO Reservas (id_reservas, data_checkin, data_checkout, status_reserva, id_hospedes, id_funcionario, id_quarto) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, reserva.getIdReservas());
            stmt.setDate(2, new java.sql.Date(reserva.getDataCheckin().getTime()));
            stmt.setDate(3, new java.sql.Date(reserva.getDataCheckout().getTime()));
            stmt.setString(4, reserva.getStatusReserva());
            stmt.setInt(5, reserva.getIdHospedes());
            stmt.setInt(6, reserva.getIdFuncionario());
            stmt.setInt(7, reserva.getIdQuarto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReserva(Reserva reserva) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Reservas SET data_checkin = ?, data_checkout = ?, status_reserva = ?, id_hospedes = ?, id_funcionario = ?, id_quarto = ? WHERE id_reservas = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setDate(1, new java.sql.Date(reserva.getDataCheckin().getTime()));
            stmt.setDate(2, new java.sql.Date(reserva.getDataCheckout().getTime()));
            stmt.setString(3, reserva.getStatusReserva());
            stmt.setInt(4, reserva.getIdHospedes());
            stmt.setInt(5, reserva.getIdFuncionario());
            stmt.setInt(6, reserva.getIdQuarto());
            stmt.setInt(7, reserva.getIdReservas());
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
            e.printStackTrace();
        }
    }
}
