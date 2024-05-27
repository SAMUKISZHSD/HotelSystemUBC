package controller;

import java.util.List;
import model.Quarto;
import model.dao.QuartoDAO;

public class QuartoController {
    private final QuartoDAO quartoDAO;

    public QuartoController() {
        quartoDAO = new QuartoDAO();
    }

    public List<Quarto> getAllQuartos() {
        return quartoDAO.getAllQuartos();
    }

    public void addQuarto(Quarto quarto) {
        quartoDAO.addQuarto(quarto);
    }

    public void updateQuarto(Quarto quarto) {
        quartoDAO.updateQuarto(quarto);
    }

    public void deleteQuarto(int id) {
        quartoDAO.deleteQuarto(id);
    }
}
