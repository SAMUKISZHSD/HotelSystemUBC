package model;

public class TipoQuarto {
    private int idTipo;
    private String caracteristica;
    private String descricao;
    private int capacidade;
    private double precoNoite;

    // Construtor, getters e setters
    public TipoQuarto(int idTipo, String caracteristica, String descricao, int capacidade, double precoNoite) {
        this.idTipo = idTipo;
        this.caracteristica = caracteristica;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.precoNoite = precoNoite;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPrecoNoite() {
        return precoNoite;
    }

    public void setPrecoNoite(double precoNoite) {
        this.precoNoite = precoNoite;
    }
}
