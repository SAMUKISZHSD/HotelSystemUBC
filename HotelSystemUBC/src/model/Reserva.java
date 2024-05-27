package model;

import java.util.Date;

public class Reserva {
    private int idReservas;
    private Date dataCheckin;
    private Date dataCheckout;
    private String status;
    private int idHospedes;
    private int idFuncionario;
    private int idQuarto;

    // Construtor, getters e setters
    public Reserva(int idReservas, Date dataCheckin, Date dataCheckout, String status, int idHospedes, int idFuncionario, int idQuarto) {
        this.idReservas = idReservas;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.status = status;
        this.idHospedes = idHospedes;
        this.idFuncionario = idFuncionario;
        this.idQuarto = idQuarto;
    }

    public Reserva(int id, java.sql.Date valueOf, java.sql.Date valueOf2, int idHospede, int idQuarto2) {
        //TODO Auto-generated constructor stub
    }

    public int getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(int idReservas) {
        this.idReservas = idReservas;
    }

    public Date getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public Date getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(Date dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDataInicio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDataInicio'");
    }

    public String getDataFim() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDataFim'");
    }
}
