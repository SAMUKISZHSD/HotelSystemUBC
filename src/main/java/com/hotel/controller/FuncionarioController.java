package com.hotel.controller;

import java.util.List;
import com.hotel.model.Funcionario;
import com.hotel.model.dao.FuncionarioDAO;

public class FuncionarioController {
    private final FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        funcionarioDAO = new FuncionarioDAO();
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioDAO.getAllFuncionarios();
    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarioDAO.addFuncionario(funcionario);
    }

    public void updateFuncionario(Funcionario funcionario) {
        funcionarioDAO.updateFuncionario(funcionario);
    }

    public void deleteFuncionario(int id) {
        funcionarioDAO.deleteFuncionario(id);
    }
}
