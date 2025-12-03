

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== ARENA MANAGEMENT SYSTEM — TEST RUN ===\n");


        UserRepository userRepo = new UserRepository();

        Game snooker = new Snooker("G001", "Snooker Table 1", 7, 300.0, 50.0);
        Game carrom  = new CaroomBoard("G002", "Carrom Board 1", 5, 150.0, 0.0);
        Game foosball= new Foosball("G003", "Foosball Table 1", 4, 200.0, 10.0);


        Game cricket = new CricketOnline("G004", "Online Cricket Room A", 10, 100.0, 11);
        Game football= new FootballOnline("G005", "Online Football Room A", 8, 120.0, 7);

  
        List<Game> games = new ArrayList<>();
        games.add(snooker);
        games.add(carrom);
        games.add(foosball);
        games.add(cricket);
        games.add(football);

        System.out.println("--- Games Loaded in System ---");
        games.forEach(System.out::println);

        // ---------------------- CREATE MEMBERSHIPS ----------------------
        // SilverMember(String memberId, String memberName)
        Members silver = new SilverMember("M001", "Silver Member");
        Members gold   = new GoldMember("M002", "Gold Member");
        Members platinum = new PlatinumMember("M003", "Platinum Member");

        System.out.println("\n--- Membership Types ---");
        System.out.println(silver);
        System.out.println(gold);
        System.out.println(platinum);

        // ---------------------- CREATE USERS ----------------------
        User user1 = new User("U001", "ayesha", "pass123", gold);
        User user2 = new User("U002", "ali",   "abc123",  silver);

        userRepo.add(user1);
        userRepo.add(user2);

        System.out.println("\n--- Users Loaded ---");
        userRepo.getAll().forEach(System.out::println);

        // ---------------------- WALLET TEST ----------------------
        System.out.println("\n--- Wallet Test ---");
        user1.getWallet().deposit(2000.0);
        user2.getWallet().deposit(1000.0);

        System.out.println("Ayesha Wallet: " + user1.getWallet());
        System.out.println("Ali    Wallet: " + user2.getWallet());

        // ---------------------- BOOKING TEST ----------------------
        System.out.println("\n--- Booking Test ---");

        int hours = 2;

        // choose snooker for booking demonstration
        System.out.println("Chosen game: " + snooker.getName() + " (available slots: " + snooker.getAvailableSlotIds() + ")");

        // calculate price using polymorphic calculateFinalPrice
        double originalPrice = snooker.calculateFinalPrice(hours);
        double discountedPrice = user1.getMembership().applyDiscount(originalPrice);

        System.out.printf("Original Price for %d hour(s): %.2f%n", hours, originalPrice);
        System.out.printf("Price after %s discount: %.2f%n", user1.getMembership().getClass().getSimpleName(), discountedPrice);


        if (user1.getWallet().withdraw(discountedPrice)) {
            List<Integer> avail = snooker.getAvailableSlotIds();
            if (!avail.isEmpty()) {
                int chosenSlot = avail.get(0); // pick first available slot
                boolean booked = snooker.bookSlot(chosenSlot);
                if (booked) {
                    Booking booking = new Booking("B001", user1, snooker, chosenSlot, hours, discountedPrice);
                    user1.addBooking(booking);
                    System.out.println("\nBooking Successful!");
                    System.out.println(booking);
                } else {
                    System.out.println("Booking failed: slot could not be booked.");
                }
            } else {
                System.out.println("Booking failed: no available slots.");
            }
        } else {
            System.out.println("Booking Failed! Not enough balance.");
        }

        System.out.println("\n--- Updated Game Status ---");
        System.out.println(snooker);

        System.out.println("\n--- Games with available slots (using generic helper) ---");
        List<Game> available = Game.findAvailableGames(games);
        available.forEach(g -> System.out.println(" - " + g.getName() + " (available: " + g.getAvailableSlotIds() + ")"));

        // ---------------------- TIMER SERVICE TEST ----------------------
        System.out.println("\n--- TimerService Test (5 seconds) ---");
        TimerService timer = new TimerService();
        timer.startTimer(5,
                remaining -> System.out.println("Time Left: " + remaining + " sec"),
                () -> System.out.println("Timer Finished!\n")
        );


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n=== TEST COMPLETE ===");
    }
}
