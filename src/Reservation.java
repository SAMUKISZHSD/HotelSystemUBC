import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Reservation {
    private static int count = 0;
    private int numero;
    private Room room;
    private Guest guest;
    private String reservationDate;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Room room, String guest, String reservationDate, String checkInDate, String checkOutDate){
        this.numero = ++count;
        this.room = room;
        this.reservationDate = reservationDate;

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.checkInDate = df.parse(checkInDate);
            this.checkOutDate = df.parse(checkOutDate);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
            this.checkInDate = null;
            this.checkOutDate = null;
        }
    };

    public Reservation(Room room, String novaDataCheckin, String novaDataCheckout, Guest guest) {
    }


    public double getValorTotal() {
        long diff = checkOutDate.getTime() - checkInDate.getTime();
        int dias = (int) (diff / (1000 * 60 * 60 * 24));

        return dias * room.getPrice();
    }

    public void setDataCheckin(String checkInDate) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.checkInDate = df.parse(checkInDate);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
        }
    }

    public void setDataCheckout(String checkOutDate) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.checkOutDate = df.parse(checkOutDate);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
        }
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return "Reserva número: " + numero + "\n" +
                "Quarto: " + room.getNumber() + "\n" +
                "Data de check-in: " + df.format(checkInDate) + "\n" +
                "Data de check-out: " + df.format(checkOutDate) + "\n" +
                "Nome do hóspede: " + guest + "\n" +
                "Valor total: " + getValorTotal();
    }
}
