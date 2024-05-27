package model;

import java.util.Date;

public class Hospede {
    private int idHospedes;
    private String nomeCompleto;
    private Date dtNascimento;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

    // Construtor, getters e setters
    public Hospede(int idHospedes, String nomeCompleto, Date dtNascimento, String endereco, String telefone, String email, String cpf) {
        this.idHospedes = idHospedes;
        this.nomeCompleto = nomeCompleto;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public int getIdHospedes() {
        return idHospedes;
    }

    public void setIdHospedes(int idHospedes) {
        this.idHospedes = idHospedes;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
