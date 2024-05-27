package view;

import controller.HospedeController;
import java.util.List;
import java.util.Scanner;
import model.Hospede;

public class HospedeView {
    private final HospedeController hospedeController;
    private final Scanner scanner;

    public HospedeView() {
        hospedeController = new HospedeController();
        scanner = new Scanner(System.in);
    }

    public void displayAllHospedes() {
        List<Hospede> hospedes = hospedeController.getAllHospedes();
        for (Hospede hospede : hospedes) {
            System.out.println("ID: " + hospede.getIdHospedes());
            System.out.println("Nome: " + hospede.getNomeCompleto());
            System.out.println("Data de Nascimento: " + hospede.getDtNascimento());
            System.out.println("Endereço: " + hospede.getEndereco());
            System.out.println("Telefone: " + hospede.getTelefone());
            System.out.println("Email: " + hospede.getEmail());
            System.out.println("CPF: " + hospede.getCpf());
            System.out.println("-----------------------------");
        }
    }

    public void addHospede() {
        System.out.println("Digite o ID do hóspede:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome completo:");
        String nome = scanner.nextLine();
        System.out.println("Digite a data de nascimento (yyyy-mm-dd):");
        String dataNascimento = scanner.nextLine();
        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o email:");
        String email = scanner.nextLine();
        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();

        Hospede hospede = new Hospede(id, nome, java.sql.Date.valueOf(dataNascimento), endereco, telefone, email, cpf);
        hospedeController.addHospede(hospede);
        System.out.println("Hóspede adicionado com sucesso!");
    }

    public void updateHospede() {
        System.out.println("Digite o ID do hóspede a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo nome completo:");
        String nome = scanner.nextLine();
        System.out.println("Digite a nova data de nascimento (yyyy-mm-dd):");
        String dataNascimento = scanner.nextLine();
        System.out.println("Digite o novo endereço:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o novo telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o novo email:");
        String email = scanner.nextLine();
        System.out.println("Digite o novo CPF:");
        String cpf = scanner.nextLine();

        Hospede hospede = new Hospede(id, nome, java.sql.Date.valueOf(dataNascimento), endereco, telefone, email, cpf);
        hospedeController.updateHospede(hospede);
        System.out.println("Hóspede atualizado com sucesso!");
    }

    public void deleteHospede() {
        System.out.println("Digite o ID do hóspede a ser deletado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        hospedeController.deleteHospede(id);
        System.out.println("Hóspede deletado com sucesso!");
    }
}
