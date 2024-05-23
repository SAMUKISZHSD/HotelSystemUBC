package hotel.example.controller;

import java.util.List;

import hotel.example.model.dao.IDAO;
import hotel.example.model.entity.Quarto; // Alterei o nome da entidade para "Quarto"

public class QuartoController {
    private final IDAO<Quarto> quartoDAO; // Alterei o nome da variável para "quartoDAO"

    // Construtor
    public QuartoController(IDAO<Quarto> quartoDAO) {
        this.quartoDAO = quartoDAO;
    }

    // Métodos para controle de quartos
    public String cadastrarQuarto(Quarto quarto) {
        quartoDAO.cadastrar(quarto);
        return "Quarto cadastrado com sucesso!";
    }

    public String atualizarQuarto(Quarto quarto) {
        quartoDAO.atualizar(quarto);
        return "Atualização realizada!";
    }

    public String excluirQuarto(int id) {
        quartoDAO.excluir(id);
        return "Quarto excluído com sucesso!";
    }

    public Quarto buscarQuarto(int id) {
        return quartoDAO.buscar(id);
    }

    public List<Quarto> listarQuartos() {
        return quartoDAO.listar();
    }

    // Métodos para controle de reservas
    public Quarto buscarQuartoReserva(int id) {
        return quartoDAO.buscarReserva(id);
    }

    public String reservarQuarto(Quarto quarto) {
        quartoDAO.reservar(quarto);
        return "Quarto reservado com sucesso!";
    }

    public String cancelarReserva(int id) {
        quartoDAO.cancelarReserva(id);
        return "Reserva cancelada com sucesso!";
    }

    public List<Quarto> listarQuartosReservados() {
        return quartoDAO.listarReservas();
    }
}
