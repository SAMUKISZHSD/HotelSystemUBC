package model;

public class Funcionario {
    private int idFuncionario;
    private String nomeCompleto;
    private String cargo;
    private String telefone;
    private int idReservas;

    // Construtor, getters e setters
    public Funcionario(int idFuncionario, String nomeCompleto, String cargo, String telefone, int idReservas) {
        this.idFuncionario = idFuncionario;
        this.nomeCompleto = nomeCompleto;
        this.cargo = cargo;
        this.telefone = telefone;
        this.idReservas = idReservas;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(int idReservas) {
        this.idReservas = idReservas;
    }
}

