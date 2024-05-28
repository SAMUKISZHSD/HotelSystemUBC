package com.hotel.view;

import com.hotel.controller.ReservaController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import com.hotel.model.Reserva;

public class ReservaView {
    private final ReservaController reservaController;
    private final Scanner scanner;
    private final DateTimeFormatter formatter;

    public ReservaView() {
        reservaController = new ReservaController();
        scanner = new Scanner(System.in);
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public void displayAllReservas() {
        List<Reserva> reservas = reservaController.getAllReservas();
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getIdReservas());
            System.out.println("Data de Início: " + reserva.getDataInicio());
            System.out.println("Data de Fim: " + reserva.getDataFim());
            System.out.println("ID Hóspede: " + reserva.getIdHospedes());
            System.out.println("ID Quarto: " + reserva.getIdQuarto());
            System.out.println("-----------------------------");
        }
    }

    public void addReserva() {
        System.out.println("Digite a data de início (yyyy-MM-dd):");
        String dataInicioStr = scanner.nextLine();
        System.out.println("Digite a data de fim (yyyy-MM-dd):");
        String dataFimStr = scanner.nextLine();
        System.out.println("Digite o ID do hóspede:");
        int idHospede = scanner.nextInt();
        System.out.println("Digite o ID do quarto:");
        int idQuarto = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatter);
        LocalDate dataFim = LocalDate.parse(dataFimStr, formatter);
        long diasPassados = ChronoUnit.DAYS.between(dataInicio, dataFim);

        Reserva reserva = new Reserva(0, java.sql.Date.valueOf(dataInicio), java.sql.Date.valueOf(dataFim), idHospede, idQuarto);
        reservaController.addReserva(reserva);
        System.out.println("Reserva adicionada com sucesso! Dias de reserva: " + diasPassados);
    }

    public void updateReserva() {
        System.out.println("Digite o ID da reserva a ser atualizada:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a nova data de início (yyyy-MM-dd):");
        String dataInicioStr = scanner.nextLine();
        System.out.println("Digite a nova data de fim (yyyy-MM-dd):");
        String dataFimStr = scanner.nextLine();
        System.out.println("Digite o novo ID do hóspede:");
        int idHospede = scanner.nextInt();
        System.out.println("Digite o novo ID do quarto:");
        int idQuarto = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatter);
        LocalDate dataFim = LocalDate.parse(dataFimStr, formatter);

        Reserva reserva = new Reserva(id, java.sql.Date.valueOf(dataInicio), java.sql.Date.valueOf(dataFim), idHospede, idQuarto);
        reservaController.updateReserva(reserva);
        System.out.println("Reserva atualizada com sucesso!");
    }

    public void deleteReserva() {
        System.out.println("Digite o ID da reserva a ser deletada:");
        int id = scanner.nextInt();
        scanner.nextLine();
        reservaController.deleteReserva(id);
        System.out.println("Reserva deletada com sucesso!");
    }
}
