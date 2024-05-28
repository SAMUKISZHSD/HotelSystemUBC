package com.hotel.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.hotel.controller.ReservaController;
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
            System.out.println("Data de Início: " + reserva.getDataCheckin());
            System.out.println("Data de Fim: " + reserva.getDataCheckout());
            System.out.println("ID Hóspede: " + reserva.getIdHospedes());
            System.out.println("ID Quarto: " + reserva.getIdQuarto());
            System.out.println("-----------------------------");
        }
    }

    public void addReserva() {
        try {
            System.out.println("Digite a data de início (yyyy-MM-dd):");
            String dataCheckinStr = scanner.nextLine();
            System.out.println("Digite a data de fim (yyyy-MM-dd):");
            String dataCheckoutStr = scanner.nextLine();
            System.out.println("Digite o ID do hóspede:");
            int idHospede = scanner.nextInt();
            System.out.println("Digite o ID do quarto:");
            int idQuarto = scanner.nextInt();
            scanner.nextLine();  // Consome o newline sobrante

            LocalDate dataCheckin = LocalDate.parse(dataCheckinStr, formatter);
            LocalDate dataCheckout = LocalDate.parse(dataCheckoutStr, formatter);
            long diasPassados = ChronoUnit.DAYS.between(dataCheckin, dataCheckout);

            Reserva reserva = new Reserva(0, java.sql.Date.valueOf(dataCheckin), java.sql.Date.valueOf(dataCheckout), "Status", idHospede, 0, idQuarto);
            reservaController.addReserva(reserva);
            System.out.println("Reserva adicionada com sucesso! Dias de reserva: " + diasPassados);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar reserva: " + e.getMessage());
        }
    }

    public void updateReserva() {
        try {
            System.out.println("Digite o ID da reserva a ser atualizada:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite a nova data de início (yyyy-MM-dd):");
            String dataCheckinStr = scanner.nextLine();
            System.out.println("Digite a nova data de fim (yyyy-MM-dd):");
            String dataCheckoutStr = scanner.nextLine();
            System.out.println("Digite o novo ID do hóspede:");
            int idHospede = scanner.nextInt();
            System.out.println("Digite o novo ID do quarto:");
            int idQuarto = scanner.nextInt();
            scanner.nextLine();  // Consome o newline sobrante

            LocalDate dataCheckin = LocalDate.parse(dataCheckinStr, formatter);
            LocalDate dataCheckout = LocalDate.parse(dataCheckoutStr, formatter);

            Reserva reserva = new Reserva(id, java.sql.Date.valueOf(dataCheckin), java.sql.Date.valueOf(dataCheckout), "Status", idHospede, 0, idQuarto);
            reservaController.updateReserva(reserva);
            System.out.println("Reserva atualizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar reserva: " + e.getMessage());
        }
    }

    public void deleteReserva() {
        try {
            System.out.println("Digite o ID da reserva a ser deletada:");
            int id = scanner.nextInt();
            scanner.nextLine();
            reservaController.deleteReserva(id);
            System.out.println("Reserva deletada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar reserva: " + e.getMessage());
        }
    }
}
