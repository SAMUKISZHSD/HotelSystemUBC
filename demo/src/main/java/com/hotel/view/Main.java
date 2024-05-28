package com.hotel.view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservaView reservaView = new ReservaView();
        FuncionarioView funcionarioView = new FuncionarioView();
        QuartoView quartoView = new QuartoView();
        HospedeView hospedeView = new HospedeView();

        while (true) {
            System.out.println("=== Hotel Braz Cubas ===");
            System.out.println("1. Gerenciamento de Reservas");
            System.out.println("2. Gerenciamento de Funcionários");
            System.out.println("3. Gerenciamento de Quartos");
            System.out.println("4. Gerenciamento de Hóspedes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> gerenciarReservas(reservaView, scanner);
                case 2 -> gerenciarFuncionarios(funcionarioView, scanner);
                case 3 -> gerenciarQuartos(quartoView, scanner);
                case 4 -> gerenciarHospedes(hospedeView, scanner);
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarReservas(ReservaView reservaView, Scanner scanner) {
        while (true) {
            System.out.println("=== Gerenciamento de Reservas ====");
            System.out.println("1. Exibir todas as reservas");
            System.out.println("2. Adicionar reserva");
            System.out.println("3. Atualizar reserva");
            System.out.println("4. Deletar reserva");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> reservaView.displayAllReservas();
                case 2 -> reservaView.addReserva();
                case 3 -> reservaView.updateReserva();
                case 4 -> reservaView.deleteReserva();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarFuncionarios(FuncionarioView funcionarioView, Scanner scanner) {
        while (true) {
            System.out.println("=== Gerenciamento de Funcionários ===");
            System.out.println("1. Exibir todos os funcionários");
            System.out.println("2. Adicionar funcionário");
            System.out.println("3. Atualizar funcionário");
            System.out.println("4. Deletar funcionário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> funcionarioView.displayAllFuncionarios();
                case 2 -> funcionarioView.addFuncionario();
                case 3 -> funcionarioView.updateFuncionario();
                case 4 -> funcionarioView.deleteFuncionario();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarQuartos(QuartoView quartoView, Scanner scanner) {
        while (true) {
            System.out.println("=== Gerenciamento de Quartos ===");
            System.out.println("1. Exibir todos os quartos");
            System.out.println("2. Adicionar quarto");
            System.out.println("3. Atualizar quarto");
            System.out.println("4. Deletar quarto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> quartoView.displayAllQuartos();
                case 2 -> quartoView.addQuarto();
                case 3 -> quartoView.updateQuarto();
                case 4 -> quartoView.deleteQuarto();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarHospedes(HospedeView hospedeView, Scanner scanner) {
        while (true) {
            System.out.println("=== Gerenciamento de Hóspedes ===");
            System.out.println("1. Exibir todos os hóspedes");
            System.out.println("2. Adicionar hóspede");
            System.out.println("3. Atualizar hóspede");
            System.out.println("4. Deletar hóspede");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> hospedeView.displayAllHospedes();
                case 2 -> hospedeView.addHospede();
                case 3 -> hospedeView.updateHospede();
                case 4 -> hospedeView.deleteHospede();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }
}