
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private String userId;
    private String username;
    private String password;
    private Members membership;
    private Wallet wallet;
    private final List<Booking> bookings = new ArrayList<>();

    public User(String userId, String username, String password, Members membership) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.membership = membership;
        this.wallet = new Wallet(userId);
    }

    public String getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public Members getMembership() { return membership; }
    public void setMembership(Members membership) { this.membership = membership; }

    public Wallet getWallet() { return wallet; }

    public List<Booking> getBookings() {
        return Collections.unmodifiableList(bookings);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public String toString() {
        return "User {" +
                "id='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", membership=" + membership +
                ", walletBalance=" + wallet.getBalance() +
                ", totalBookings=" + bookings.size() +
                '}';
    }
}

