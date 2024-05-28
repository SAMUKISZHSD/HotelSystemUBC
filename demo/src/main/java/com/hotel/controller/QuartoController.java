package com.hotel.controller;

import java.util.List;
import com.hotel.model.Quarto;
import com.hotel.model.dao.QuartoDAO;

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
