package com.hotel.view;

import com.hotel.controller.QuartoController;
import java.util.List;
import java.util.Scanner;
import com.hotel.model.Quarto;

public class QuartoView {
    private final QuartoController quartoController;
    private final Scanner scanner;

    public QuartoView() {
        quartoController = new QuartoController();
        scanner = new Scanner(System.in);
    }

    public void displayAllQuartos() {
        List<Quarto> quartos = quartoController.getAllQuartos();
        for (Quarto quarto : quartos) {
            System.out.println("ID: " + quarto.getIdQuarto());
            System.out.println("Número: " + quarto.getNumQuarto());
            System.out.println("Tipo: " + quarto.getTipo());
            System.out.println("Preço: " + quarto.getPreco());
            System.out.println("ID Tipo: " + quarto.getIdTipo());
            System.out.println("-----------------------------");
        }
    }

    public void addQuarto() {
        System.out.println("Digite o ID do quarto:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o número do quarto:");
        int numQuarto = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o tipo de quarto:");
        String tipo = scanner.nextLine();
        System.out.println("Digite o preço do quarto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite o ID do tipo:");
        int idTipo = scanner.nextInt();

        Quarto quarto = new Quarto(id, numQuarto, tipo, preco, idTipo);
        quartoController.addQuarto(quarto);
        System.out.println("Quarto adicionado com sucesso!");
    }

    public void updateQuarto() {
        System.out.println("Digite o ID do quarto a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo número do quarto:");
        int numQuarto = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo tipo de quarto:");
        String tipo = scanner.nextLine();
        System.out.println("Digite o novo preço do quarto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite o novo ID do tipo:");
        int idTipo = scanner.nextInt();

        Quarto quarto = new Quarto(id, numQuarto, tipo, preco, idTipo);
        quartoController.updateQuarto(quarto);
        System.out.println("Quarto atualizado com sucesso!");
    }

    public void deleteQuarto() {
        System.out.println("Digite o ID do quarto a ser deletado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        quartoController.deleteQuarto(id);
        System.out.println("Quarto deletado com sucesso!");
    }
}
