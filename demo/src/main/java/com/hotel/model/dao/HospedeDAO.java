package com.hotel.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.config.DatabaseConnection;
import com.hotel.model.Hospede;

public class HospedeDAO {
    public List<Hospede> getAllHospedes() {
        List<Hospede> hospedes = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Hospedes";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Hospede hospede = new Hospede(
                        rs.getInt("id_hospedes"),
                        rs.getString("nome_completo"),
                        rs.getInt("idade"),
                        rs.getString("endereço"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf")
                );
                hospedes.add(hospede);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospedes;
    }

    public void addHospede(Hospede hospede) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Hospedes (id_hospedes, nome_completo, idade, endereço, telefone, email, cpf) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, hospede.getIdHospedes());
            stmt.setString(2, hospede.getNomeCompleto());
            stmt.setInt(3, hospede.getIdade());
            stmt.setString(4, hospede.getEndereco());
            stmt.setString(5, hospede.getTelefone());
            stmt.setString(6, hospede.getEmail());
            stmt.setString(7, hospede.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHospede(Hospede hospede) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Hospedes SET nome_completo = ?, idade = ?, endereço = ?, telefone = ?, email = ?, cpf = ? WHERE id_hospedes = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, hospede.getNomeCompleto());
            stmt.setInt(2, hospede.getIdade());
            stmt.setString(3, hospede.getEndereco());
            stmt.setString(4, hospede.getTelefone());
            stmt.setString(5, hospede.getEmail());
            stmt.setString(6, hospede.getCpf());
            stmt.setInt(7, hospede.getIdHospedes());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHospede(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Hospedes WHERE id_hospedes = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
