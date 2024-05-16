package br.com.brazcubas.hotelSystem;

import java.util.List;
import java.util.Scanner;

import br.com.brazcubas.hotelSystem.controller.HotelController;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;
import br.com.brazcubas.hotelSystem.view.HotelView;


public class HotelSystem {
    private HotelController hotelController;
    private HotelView hotelView;
    private Scanner scanner;

    // Construtor do Sistema
    public LibrarySystem(HotelController hotelController, HotelView hotelView, Scanner scanner) {
        this.hotelController = hotelController;
        this.hotelView = hotelView;
        this.scanner = scanner;
    }

    // Métodos de Sistema
    public void iniciar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            switch(opcao) {
                case 1 -> cadastrarHospedes();
                case 2 -> listarHospedes();
                case 3 -> atualizarHospedes();
                case 4 -> excluirHospedes();
                case 5 -> buscarHospedes();
                case 6 -> reservarQuarto();
                case 7 -> checkOUT();
                case 8 -> detalheQuartosReservados();
                case 9 -> buscarQuartosReservados();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção invalida.");
            }
        } while(opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("======= MENU =======");
        System.out.println("|---- CADASTRO DE HOSPEDES ----");
        System.out.println("|> 1. Cadastrar Hospede");
        System.out.println("|> 2. Listar Hospedes");
        System.out.println("|> 3. Atualizar Hospedes");
        System.out.println("|> 4. Excluir Hospedes");
        System.out.println("|> 5. Buscar Hospedes");
        System.out.println("|---- RESERVAS ----");
        System.out.println("|> 6. Reservar Quarto");
        System.out.println("|> 7. Liberar Quarto");
        System.out.println("|> 8. Detalhes da Reserva do Quarto");
        System.out.println("|> 9. Listar Quartos Reservados");
        System.out.println("|> 0. Sair");
        System.out.println("====================");
        System.out.println("Escolha uma opção: ");
      }

    private void cadastrarHospedes() {
        scanner.nextLine(); // Limpar buffer
        System.out.println("Digite o nome completo do Hospede:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o sexo do Hospede:");
        String autor = scanner.nextLine();
        System.out.println("Digite a idade do Hospede:");
        int numPaginas = scanner.nextInt();

        Hotel novoHospede = new Hospede(titulo, autor, numPaginas);
        String retorno = hotelController.cadastrarHospedes(novoHospede);
        System.out.println(retorno);
    }

    private void listarHospedes() {
        System.out.println("=== Hospedes Cadastrados ===");
        List<Hospede> Hotel = hotelController.listarHospedes();
        hotelView.mostrarListaHospede(hospede);
        System.out.println("===========================");
    }

    private void atualizarHospedes() {
        System.out.println("Digite o ID do hospede a ser atualizado: ");
        int id = scanner.nextInt();
        Livro livro = hotelController.buscarLivro(id);
        if (livro != null) {
            scanner.nextLine(); // Limpar buffer
            System.out.println("Digite o novo nome do hospode: ");
            String titulo = scanner.nextLine();
            livro.setTitulo(titulo);
            System.out.println("Digite o novo sexo do hospode: ");
            String autor = scanner.nextLine();
            livro.setAutor(autor);
            System.out.println("Digite a novo idade do hospede: ");
            int numPaginas = scanner.nextInt();
            livro.setNumPaginas(numPaginas);
            String retorno = hotelController.atualizarHospedes(livro);
            System.out.println(retorno);
        } else {
            System.out.println("Hospede não encontrado!");
        }
    }


//parou aqui...
    private void excluirLivro() {
        System.out.println("Digite o ID do hospede a ser excluído: ");
        int id = scanner.nextInt();

        Livro livro = livroController.buscarLivro(id);
        if (livro == null) {
            System.out.println("Hospede não encontrado!");
            return;
        }

        String retorno = livroController.excluirLivro(id);
        System.out.println(retorno);
    }

    private void buscarLivro() {
        System.out.println("Digite o ID do livro a ser buscado: ");
        int id = scanner.nextInt();
        Livro livro = livroController.buscarLivro(id);
        if (livro != null) {
            livroView.mostrarDetalhesLivro(livro);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private void emprestarLivro() {
        System.out.println("Digite o ID do livro a ser EMPRESTADO: ");
        int id = scanner.nextInt();

        Livro livro = livroController.buscarLivro(id);
        if (livro != null) {
            Livro emprestadoCheck = livroController.buscarLivroEmpr(id);
            if (emprestadoCheck == null) {
                scanner.nextLine(); // Limpar buffer
                System.out.println("Digite para quem o livro foi emprestado: ");
                String membro = scanner.nextLine();
                livro.setEmprestimoMembro(membro);
                System.out.println("Digite quem lançou o emprestimo: ");
                String funcionario = scanner.nextLine();
                livro.setEmprestimoResponsavel(funcionario);

                livroController.emprestaLivro(livro);
            } else {
                System.out.println("Livro já está emprestado! Aguarde devolução.");
            }
        } else {
            System.out.println("Livro não encontrado!");
        }

    };

    private void devolverLivro() {
        System.out.println("Digite o ID do livro a ser devolvido: ");
        int id_livro = scanner.nextInt();

        Livro livro = livroController.buscarLivro(id_livro);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }

        String retorno = livroController.devolverLivro(id_livro);
        System.out.println(retorno);
    };

    private void listarLivrosEmprestados() {
        System.out.println("=+=+=+= Livros Emprestados =+=+=");
        List<Livro> livros = livroController.listarLivrosEmprestados();
        livroView.mostrarListaLivros(livros);
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
    }

    private void buscarEmpre() {
        System.out.println("Digite o ID do livro para consulta do emprestimo: ");
        int id = scanner.nextInt();
        Livro livro = livroController.buscarLivroEmpr(id);
        if (livro != null) {
            livroView.mostrarDetalhesEmprestimo(livro);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }
}
