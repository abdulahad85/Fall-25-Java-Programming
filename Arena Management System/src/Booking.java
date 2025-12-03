
import java.time.LocalDateTime;

public class Booking {

    private final String bookingId;
    private final User user;
    private final Game game;
    private final int slotId;
    private final int hours;
    private double finalAmount;
    private final LocalDateTime bookingTime;

    public Booking(String bookingId, User user, Game game, int slotId, int hours, double finalAmount) {
        this.bookingId = bookingId;
        this.user = user;
        this.game = game;
        this.slotId = slotId;
        this.hours = hours;
        this.finalAmount = finalAmount;
        this.bookingTime = LocalDateTime.now();
    }

    public String getBookingId() { return bookingId; }
    public User getUser() { return user; }
    public Game getGame() { return game; }
    public int getSlotId() { return slotId; }
    public int getHours() { return hours; }
    public double getFinalAmount() { return finalAmount; }
    public LocalDateTime getBookingTime() { return bookingTime; }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + bookingId + '\'' +
                ", user='" + user.getUsername() + '\'' +
                ", game='" + game.getName() + '\'' +
                ", slot=" + slotId +
                ", hours=" + hours +
                ", finalAmount=" + finalAmount +
                ", time=" + bookingTime +
                '}';
    }
}

