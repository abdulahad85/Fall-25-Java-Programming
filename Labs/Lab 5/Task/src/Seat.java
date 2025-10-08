// Name: Abdul Ahad Shahid 
// Reg no: SP25-BCS-001

enum Type {
    STANDARD,
    PREMIUM,
    VIP,
    RECLINER;
}

public class Seat {
    private Type seatType;
    private String id;
    private double price;
    private boolean isAvailable;

    public Seat(Type seatType, String id, double price, boolean isAvailable) {
        this.seatType = seatType;
        this.id = id;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Seat() {
    }

    public Type getSeatType() {
        return seatType;
    }

    public String getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setSeatType(Type seatType) {
        this.seatType = seatType;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean bookSeat() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Seat " + id + " has been BOOKED.");
            return true;
        } else {
            System.out.println("Seat " + id + " is already booked.");
        }
        return false;
    }

    public boolean cancelBooking() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Seat " + id + " has been CANCELLED.");
            return true;
        } else {
            System.out.println("Seat " + id + " was not booked, so it cannot be cancelled.");
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Seat Type: %s  Seat ID: %s  Price: %.2f  Availability: %b",
                seatType, id, price, isAvailable);
    }
}
