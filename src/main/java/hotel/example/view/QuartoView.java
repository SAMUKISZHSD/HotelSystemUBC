package hotel.example.view;

import java.util.List;

import hotel.example.model.entity.Quarto;

public class QuartoView {
    public void mostrarDetalhesQuarto(QuartoView quarto) {
        System.out.println(">>> Detalhes do quarto <<<");
        System.out.println("Número do quarto: " + quarto.getNumero());
        System.out.println("Tipo: " + quarto.getTipo());
        System.out.println("Capacidade: " + quarto.getCapacidade());
        System.out.println("Preço por noite: " + quarto.getPrecoPorNoite());
    }

    public void mostrarDetalhesReserva(QuartoView quarto) {
        System.out.println(">>> Detalhes da reserva <<<");
        System.out.println("Número do quarto: " + quarto.getNumero());
        System.out.println("Data de check-in: " + quarto.getDataCheckIn());
        System.out.println("Data de check-out: " + quarto.getDataCheckOut());
        System.out.println("Hóspede: " + quarto.getHospede());
    }

    public void mostrarListaQuartos(List<QuartoView> quartos) {
        System.out.println("Lista de quartos disponíveis: ");
        for (QuartoView quarto : quartos) {
            System.out.println("Número: " + quarto.getNumero() + ", Tipo: " + quarto.getTipo());
        }
    }
}
