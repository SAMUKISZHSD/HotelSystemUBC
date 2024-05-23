import java.util.ArrayList;

public class Room {
    private int number;
    private double price;
    private boolean availability;

    public Room(int number, double price, boolean availability){
        this.number = number;
        this.price = price;
        this.availability = availability;
    }

    ArrayList<Room> rooms = new ArrayList<>();

    public int getNumber(){
        return number;
    };
    public void setNumber(int number){
        this.number = number;
    };

    public double getPrice(){
        return price;
    };
    public void setPrice(){
        this.price = price;
    };

    public boolean getAvailability(){
      return availability;
    };
    public void setAvailability(boolean availability){
        this.availability = availability;
    };

    @Override
    public String toString() {
        return "Quarto " + number + " (" + availability + ") - Preço da diária: R$" + price;
    }
}
