package hotel.example;

import java.util.List;
import java.util.Scanner;

import hotel.example.controller.QuartoController;
import hotel.example.model.entity.Quarto;
import hotel.example.view.QuartoView;

public class ReservaHotelSys {
    private QuartoController quartoController;
    private QuartoView quartoView;
    private Scanner scanner;

    // Construtor do Sistema
    public reservaHotelSys(QuartoController quartoController, QuartoView quartoView, Scanner scanner) {
        this.quartoController = quartoController;
        this.quartoView = quartoView;
        this.scanner = scanner;
    }

    // Métodos de Sistema
    public void iniciar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            switch(opcao) {
                case 1 -> cadastrarQuarto();
                case 2 -> listarQuartos();
                case 3 -> atualizarQuarto();
                case 4 -> excluirQuarto();
                case 5 -> buscarQuarto();
                case 6 -> reservarQuarto();
                case 7 -> liberarQuarto();
                case 8 -> buscarReserva();
                case 9 -> listarQuartosReservados();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção invalida.");
            }
        } while(opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("======= MENU =======");
        System.out.println("|>>>> CADASTRADOS <<<<");
        System.out.println("|> 1. Cadastrar Quarto");
        System.out.println("|> 2. Listar Quartos");
        System.out.println("|> 3. Atualizar Quarto");
        System.out.println("|> 4. Excluir Quarto");
        System.out.println("|> 5. Buscar Quarto");
        System.out.println("|>>>> RESERVADOS <<<<");
        System.out.println("|> 6. Reservar Quarto");
        System.out.println("|> 7. Liberar Quarto");
        System.out.println("|> 8. Detalhes da Reserva");
        System.out.println("|> 9. Listar Quartos Reservados");
        System.out.println("|> 0. Sair");
        System.out.println("====================");
        System.out.println("Escolha uma opção: ");
      }

    private void cadastrarQuarto() {
        scanner.nextLine(); // Limpar buffer
        System.out.println("Digite o tipo do quarto:");
        String tipo = scanner.nextLine();
        System.out.println("Digite a capacidade do quarto:");
        int capacidade = scanner.nextInt();

        Quarto novoQuarto = new Quarto(tipo, capacidade);
        String retorno = quartoController.cadastrarQuarto(novoQuarto);
        System.out.println(retorno);
    }

    private void listarQuartos() {
        System.out.println("=== Quartos Cadastrados ===");
        List<Quarto> quartos = quartoController.listarQuartos();
        quartoView.mostrarListaQuartos(quartos);
        System.out.println("===========================");
    }

    private void atualizarQuarto() {
        System.out.println("Digite o ID do quarto a ser atualizado: ");
        int id = scanner.nextInt();
        Quarto quarto = quartoController.buscarQuarto(id);
        if (quarto != null) {
            scanner.nextLine(); // Limpar buffer
            System.out.println("Digite o novo tipo do quarto: ");
            String tipo = scanner.nextLine();
            quarto.setTipo(tipo);
            System.out.println("Digite a nova capacidade do quarto: ");
            int capacidade = scanner.nextInt();
            quarto.setCapacidade(capacidade);
            String retorno = quartoController.atualizarQuarto(quarto);
            System.out.println(retorno);
        } else {
            System.out.println("Quarto não encontrado!");
        }
    }

    private void excluirQuarto() {
        System.out.println("Digite o ID do quarto a ser excluído: ");
        int id = scanner.nextInt();

        Quarto quarto = quartoController.buscarQuarto(id);
        if (quarto == null) {
            System.out.println("Quarto não encontrado!");
            return;
        }

        String retorno = quartoController.excluirQuarto(id);
        System.out.println(retorno);
    }

    private void buscarQuarto() {
        System.out.println("Digite o ID do quarto a ser buscado: ");
        int id = scanner.nextInt();
        Quarto quarto = quartoController.buscarQuarto(id);
        if (quarto != null) {
            quartoView.mostrarDetalhesQuarto(quarto);
        } else {
            System.out.println("Quarto não encontrado!");
        }
    }

    private void reservarQuarto() {
        System.out.println("Digite o ID do quarto a ser RESERVADO: ");
        int id = scanner.nextInt();

        Quarto quarto = quartoController.buscarQuarto(id);
        if (quarto != null) {
            Quarto reservadoCheck = quartoController.buscarQuartoReservado(id);
            if (reservadoCheck == null) {
                scanner.nextLine(); // Limpar buffer
                System.out.println("Digite para quem o quarto foi reservado: ");
                String hospede = scanner.nextLine();
                quarto.setReservaHospede(hospede);
                System.out.println("Digite quem lançou a reserva: ");
                String funcionario = scanner.nextLine();
                quarto.setReservaResponsavel(funcionario);

                quartoController.reservaQuarto(quarto);
            } else {
                System.out.println("Quarto já está reservado! Aguarde liberação.");
            }
        } else {
            System.out.println("Quarto não encontrado!");
        }
    };

    private void liberarQuarto() {
        System.out.println("Digite o ID do quarto a ser liberado: ");
        int id_quarto = scanner.nextInt();

        Quarto quarto = quartoController.buscarQuarto(id_quarto);
        if (quarto == null) {
            System.out.println("Quarto não encontrado!");
            return;
        }

        String retorno = quartoController.liberarQuarto(id_quarto);
        System.out.println(retorno);
    };

    private void listarQuartosReservados() {
        System.out.println("=+=+=+= Quartos Reservados =+=+=");
        List<Quarto> quartos = quartoController.listarQuartosReservados();
        quartoView.mostrarListaQuartos(quartos);
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
    }

    private void buscarReserva() {
        System.out.println("Digite o ID do quarto para consulta da reserva: ");
        int id = scanner.nextInt();
        Quarto quarto = quartoController.buscarQuartoReservado(id);
        if (quarto != null) {
            quartoView.mostrarDetalhesReserva(quarto);
        } else {
            System.out.println("Quarto não encontrado!");
        }
    }
}
