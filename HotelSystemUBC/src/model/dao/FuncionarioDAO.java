package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConnection;
import model.Funcionario;

public class FuncionarioDAO {
    public List<Funcionario> getAllFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Funcionarios";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome_completo"),
                        rs.getString("cargo"),
                        rs.getString("telefone"),
                        rs.getInt("id_reservas")
                );
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Funcionarios (id_funcionario, nome_completo, cargo, telefone, id_reservas) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setString(2, funcionario.getNomeCompleto());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setInt(5, funcionario.getIdReservas());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFuncionario(Funcionario funcionario) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Funcionarios SET nome_completo = ?, cargo = ?, telefone = ?, id_reservas = ? WHERE id_funcionario = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, funcionario.getNomeCompleto());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setInt(4, funcionario.getIdReservas());
            stmt.setInt(5, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFuncionario(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Funcionarios WHERE id_funcionario = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
