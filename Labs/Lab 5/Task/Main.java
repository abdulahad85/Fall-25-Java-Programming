public class Main {
    public static void main(String[] args) {
        // Create a city with default cinemas
        CityCinema city = new CityCinema("Karachi", 3);
        city.preloadCity();

        System.out.println("=== CITY: " + city.getCityName() + " | All Cinema Layouts ===");

        // Display all cinema layouts
        city.displayAll();

        // Test some functionality
        System.out.println("\n=== Testing Booking Functionality ===");
        city.bookSeat("MegaStar", "Screen-1", 1, 1);
        city.bookSeat("Galaxy", "Screen-1", 2, 1);
        
        System.out.println("\n=== After Booking ===");
        city.displayAll();

        // Find first available VIP seat
        Seat vipSeat = city.findFirstVIPSeat();
        if (vipSeat != null) {
            System.out.println("First available VIP seat: " + vipSeat.getId());
        }
    }
}