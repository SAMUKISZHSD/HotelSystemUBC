package com.hotel.view;

import com.hotel.controller.FuncionarioController;
import java.util.List;
import java.util.Scanner;
import com.hotel.model.Funcionario;

public class FuncionarioView {
    private final FuncionarioController funcionarioController;
    private final Scanner scanner;

    public FuncionarioView() {
        funcionarioController = new FuncionarioController();
        scanner = new Scanner(System.in);
    }

    public void displayAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioController.getAllFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getIdFuncionario());
            System.out.println("Nome: " + funcionario.getNomeCompleto());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println("Idade: " + funcionario.getIdadeFuncionario());
            System.out.println("-----------------------------");
        }
    }

    public void addFuncionario() {
        System.out.println("Digite o ID do funcionário:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome completo:");
        String nome = scanner.nextLine();
        System.out.println("Digite o cargo:");
        String cargo = scanner.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite a idade do funcionário:");
        int idade_funcionario = scanner.nextInt();

        Funcionario funcionario = new Funcionario(id, nome, cargo, telefone, idade_funcionario);
        funcionarioController.addFuncionario(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    public void updateFuncionario() {
        System.out.println("Digite o ID do funcionário a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo nome completo:");
        String nome = scanner.nextLine();
        System.out.println("Digite o novo cargo:");
        String cargo = scanner.nextLine();
        System.out.println("Digite o novo telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite a idade do funcionário:");
        int idade_funcionario = scanner.nextInt();

        Funcionario funcionario = new Funcionario(id, nome, cargo, telefone, idade_funcionario);
        funcionarioController.updateFuncionario(funcionario);
        System.out.println("Funcionário atualizado com sucesso!");
    }

    public void deleteFuncionario() {
        System.out.println("Digite o ID do funcionário a ser deletado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        funcionarioController.deleteFuncionario(id);
        System.out.println("Funcionário deletado com sucesso!");
    }
}
