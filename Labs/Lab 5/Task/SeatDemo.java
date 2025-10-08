public class SeatDemo {
    public static void main(String[] args) {
        System.out.println("=== Seat Demo — Lab 5: Cinema Management System ===\n");

        Seat s1 = new Seat(Type.STANDARD, "R1-001", 500.0, true);
        Seat s2 = new Seat(Type.PREMIUM, "R1-002", 750.0, true);
        Seat s3 = new Seat(Type.VIP, "R1-003", 1000.0, true);
        Seat s4 = new Seat(Type.RECLINER, "R1-004", 1200.0, true);

        System.out.println("Initial seat states:");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println();

        s1.bookSeat();
        s1.bookSeat();
        s1.cancelBooking();
        s1.cancelBooking();
        System.out.println();

        s3.bookSeat();
        s4.setPrice(1350.0);
        System.out.println("\nAfter booking VIP and changing Recliner price:");
        System.out.println(s3);
        System.out.println(s4);
        System.out.println();

        System.out.println("Final seat states:");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}