package com.veterinario.model.entity;

public class Receita extends AbstractEntity {
   
    private int idConsulta;
    private int idMedicamento;
    private String dosagem;

    public Receita(int idConsulta, int idMedicamento, String dosagem) {
        
        this.idConsulta = idConsulta;
        this.idMedicamento = idMedicamento;
        this.dosagem = dosagem;
    }

    public Receita(int idReceita, int idConsulta, int idMedicamento, String dosagem) {
        super.setId(idReceita);
        this.idConsulta = idConsulta;
        this.idMedicamento = idMedicamento;
        this.dosagem = dosagem;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    
}
