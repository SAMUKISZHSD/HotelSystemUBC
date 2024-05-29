package com.hotel.controller;

import java.util.List;

import com.hotel.model.Reserva;
import com.hotel.model.dao.ReservaDAO;

public class ReservaController {
    private ReservaDAO reservaDAO;

    public ReservaController() {
        reservaDAO = new ReservaDAO();
    }

    public List<Reserva> getAllReservas() {
        return reservaDAO.getAllReservas();
    }

    public void addReserva(Reserva reserva) {
        reservaDAO.addReserva(reserva);
    }

    public void updateReserva(Reserva reserva) {
        reservaDAO.updateReserva(reserva);
    }

    public void deleteReserva(int id) {
        reservaDAO.deleteReserva(id);
    }
}
