package hotel.example.model.entity;

public class Quarto extends AbstractEntity {
    private String tipo;
    private int capacidade;
    private double precoPorNoite;
    
    private String dataCheckIn;
    private String dataCheckOut;
    private String hospede;

    // Construtor sem ID
    // Usado para inserir dados no banco de dados caso ainda não tenham sido persistidos
    public Quarto(String tipo, int capacidade, double precoPorNoite) {
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.precoPorNoite = precoPorNoite;
    }

    // Construtor com ID
    // Usado para buscar dados já persistidos no BD com base no ID
    public Quarto(int id, String tipo, int capacidade, double precoPorNoite) {
        super.setId(id);
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.precoPorNoite = precoPorNoite;
    }

    // Getters e setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public double getPrecoPorNoite() { return precoPorNoite; }
    public void setPrecoPorNoite(double precoPorNoite) { this.precoPorNoite = precoPorNoite; }

    public String getDataCheckIn() { return dataCheckIn; }
    public void setDataCheckIn(String dataCheckIn) { this.dataCheckIn = dataCheckIn; }

    public String getDataCheckOut() { return dataCheckOut; }
    public void setDataCheckOut(String dataCheckOut) { this.dataCheckOut = dataCheckOut; }

    public String getHospede() { return hospede; }
    public void setHospede(String hospede) { this.hospede = hospede; }
}
