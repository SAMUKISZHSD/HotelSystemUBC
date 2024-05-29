package com.hotel.model;

import java.util.Date;

public class Reserva {
    private int idReservas;
    private Date dataCheckin;
    private Date dataCheckout;
    private String statusReserva;
    private int idHospedes;
    private int idFuncionario;
    private int idQuarto;

    // Construtor, getters e setters
    public Reserva(int idReservas, Date dataCheckin, Date dataCheckout, String statusReserva, int idHospedes, int idFuncionario, int idQuarto) {
        this.idReservas = idReservas;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.statusReserva = statusReserva;
        this.idHospedes = idHospedes;
        this.idFuncionario = idFuncionario;
        this.idQuarto = idQuarto;
    }

    public Reserva(int idReservas, java.sql.Date dataCheckin, java.sql.Date dataCheckout, int idHospedes, String statusReserva, int idFuncionario, int idQuarto) {
        this.idReservas = idReservas;
        this.dataCheckin = dataCheckin != null ? new Date(dataCheckin.getTime()) : null;
        this.dataCheckout = dataCheckout != null ? new Date(dataCheckout.getTime()) : null;
        this.statusReserva = statusReserva;
        this.idHospedes = idHospedes;
        this.idFuncionario = idFuncionario;
        this.idQuarto = idQuarto;
    }

    public int getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(int idReservas) {
        this.idReservas = idReservas;
    }

    public java.sql.Date getDataCheckin() {
        return dataCheckin != null ? new java.sql.Date(dataCheckin.getTime()) : null;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public java.sql.Date getDataCheckout() {
        return dataCheckout != null ? new java.sql.Date(dataCheckout.getTime()) : null;
    }

    public void setDataCheckout(Date dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public String getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(String statusReserva) {
        this.statusReserva = statusReserva;
    }

    public int getIdHospedes() {
        return idHospedes;
    }

    public void setIdHospedes(int idHospedes) {
        this.idHospedes = idHospedes;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }
}
