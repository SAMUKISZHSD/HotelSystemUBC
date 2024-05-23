import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        LocalDate dataAtual = LocalDate.now();
        LocalDate data = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        rooms.add(new Room(1, 100.00, true ));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n********************************************************\n");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar um novo quarto");
            System.out.println("2 - Fazer uma nova reserva");
            System.out.println("3 - Cancelar uma reserva existente");
            System.out.println("4 - Modificar uma reserva existente");
            System.out.println("5 - Exibir todas as reservas existentes");
            System.out.println("6 - Exibir todas as reservas para um determinado quarto");
            System.out.println("7 - Sair\n");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número do quarto:");
                    int number = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o preço da diária:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    rooms.add(new Room(number, price, true));
                    System.out.println("Quarto adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o número do quarto:");
                    int numQuarto = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a data de check-in (dd/mm/yyyy):");
                    String dataCheckin = scanner.nextLine();
                    Date checkinDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataCheckin);

                    System.out.println("Digite a data de check-out (dd/mm/yyyy):");
                    String dataCheckout = scanner.nextLine();
                    Date checkoutDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataCheckout);

                    System.out.println("Digite o nome do hóspede:");
                    String nameGuest = scanner.nextLine();

                    System.out.println("Digite a data da reserva:");
                    String reservationDate = scanner.nextLine();

                    Room quarto = null;
                    for (Room q : rooms) {
                        if (q.getNumber() == numQuarto) {
                            quarto = q;
                            break;
                        }
                    }

                    if (quarto == null) {
                        System.out.println("O quarto não existe!");
                        break;
                    }

                    Reservation novaReserva = new Reservation(quarto, nameGuest, reservationDate, dataCheckin, dataCheckout );
                    if (verificaDisponibilidade(quarto, reservations, novaReserva)) {
                        reservations.add(novaReserva);
                        System.out.println("\n********************************************************\n");
                        System.out.println("Reserva efetuada com sucesso!");
                        System.out.println("\n********************************************************\n");
                    } else {
                        System.out.println("\n********************************************************\n");
                        System.out.println("Quarto indisponível no período solicitado!");
                        System.out.println("\n********************************************************\n");
                    }
                    break;

                case 3:
                    System.out.println("Digite o número da reserva:");
                    int numReserva = scanner.nextInt();
                    scanner.nextLine();

                    Reservation reservaExcluida = null;
                    for (Reservation r : reservations) {
                        if (r.getNumero() == numReserva) {
                            reservaExcluida = r;
                            break;
                        }
                    }

                    if (reservaExcluida == null) {
                        System.out.println("\n********************************************************\n");
                        System.out.println("A reserva não existe!");
                        System.out.println("\n********************************************************\n");
                        break;
                    }

                    reservations.remove(reservaExcluida);
                    System.out.println("\n********************************************************\n");
                    System.out.println("Reserva cancelada com sucesso!");
                    System.out.println("\n********************************************************\n");
                    break;

                case 4:
                    System.out.println("Digite o número da reserva:");
                    numReserva = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a nova data de check-in (dd/mm/yyyy):");
                    String novaDataCheckin = scanner.nextLine();

                    System.out.println("Digite a nova data de check-out (dd/mm/yyyy):");
                    String novaDataCheckout = scanner.nextLine();

                    Reservation reservaModificada = null;
                    for (Reservation r : reservations) {
                        if (r.getNumero() == numReserva) {
                            reservaModificada = r;
                            break;
                        }
                    }

                    if (reservaModificada == null) {
                        System.out.println("\n********************************************************\n");
                        System.out.println("A reserva não existe!");
                        System.out.println("\n********************************************************\n");
                        break;
                    }

                    if (!verificaDisponibilidade(reservaModificada.getRoom(), reservations, new Reservation(reservaModificada.getRoom(), novaDataCheckin, novaDataCheckout, reservaModificada.getGuest()))) {
                        System.out.println("\n********************************************************\n");
                        System.out.println("Quarto indisponível no período solicitado!");
                        System.out.println("\n********************************************************\n");
                        break;
                    }

                    reservaModificada.setDataCheckin(novaDataCheckin);
                    reservaModificada.setDataCheckout(novaDataCheckout);
                    System.out.println("\n********************************************************\n");
                    System.out.println("Reserva modificada com sucesso!");
                    System.out.println("\n********************************************************\n");
                    break;

                case 5:
                    System.out.println("\n********************************************************\n");
                    System.out.println("Todas as reservas:");

                    for (Reservation r : reservations) {
                        System.out.println(r);
                    }
                    break;

                case 6:
                    System.out.println("Digite o número do quarto:");
                    numQuarto = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Reservas para o quarto " + numQuarto + ":");

                    for (Reservation r : reservations) {
                        if (r.getRoom().getNumber() == numQuarto) {
                            System.out.println(r);
                            System.out.println("-------------------------------");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Programa encerrado.");
                    System.out.println("\n***************\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n***************\n");
                    System.out.println("Opção inválida!");
                    System.out.println("\n***************\n");
                    break;

            }
        }
    }
    public static boolean verificaDisponibilidade(Room quarto, ArrayList<Reservation> reservations, Reservation novaReserva) {
        for (Reservation r : reservations) {
            if (r.getRoom().getNumber() == quarto.getNumber()) {
                if (r.getCheckInDate().compareTo(novaReserva.getCheckOutDate()) < 0 && r.getCheckOutDate().compareTo(novaReserva.getCheckInDate()) > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
