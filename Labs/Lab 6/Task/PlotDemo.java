
public class PlotDemo {
    public static void main(String[] args) {
        // Create residential plots
        Plot p1 = new Plot(1, 101, PlotShape.RECTANGLE, PlotType.RES_5_MARLA, "A", "LDA Avenue 1", "Lahore");
        Plot p2 = new Plot(2, 202, PlotShape.TRAPEZOID, PlotType.RES_10_MARLA, "B", "LDA Avenue 2", "Lahore");
        Plot p3 = new Plot(3, 303, PlotShape.L_SHAPE, PlotType.RES_1_KANAL, "C", "LDA Avenue 1", "Lahore");


        // Display all plots
        System.out.println("\n--- Plot Details ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

       CornerPlot c1 = new CornerPlot(2, 11, PlotShape.RECTANGLE, PlotType.RES_5_MARLA, "Block A", "Dream Villas", "Lahore", 4.5, 3.0);
        CornerPlot c2 = new CornerPlot(3, 18, PlotShape.TRAPEZOID, PlotType.RES_10_MARLA, "Block B", "Sunshine City", "Islamabad");
        System.out.println("Plot ID: " + c1.getPlotId() + " | Area: " + c1.calculateArea() + " | Price: " + c1.getPrice());
        System.out.println("Plot ID: " + c2.getPlotId() + " | Area: " + c2.calculateArea() + " | Price: " + c2.getPrice());

        // Book and cancel
        System.out.println("\n--- Booking and Cancellation ---");
        p1.bookPlot();
        p1.bookPlot();   // trying again
        p1.cancelBooking();
        p1.cancelBooking(); // trying again
         p1.bookPlot(); 
       
        // Display compact view
        System.out.println("\n--- Compact View ---");
        System.out.println(p1.displayCompact());
        System.out.println(p2.displayCompact());
        System.out.println(p3.displayCompact());
     
//Shop 

        Shop s1 = new Shop(1, PlotShape.RECTANGLE, PlotType.COMM_SHOP, "Grocery Hub");
        Shop s2 = new Shop(2, PlotShape.TRAPEZOID, PlotType.COMM_SHOP, "Tech Store");
        Shop s3 = new Shop(3, PlotShape.L_SHAPE, PlotType.COMM_OFFICE, "Fashion Boutique");

        // Display compact details before booking
        System.out.println("=== Initial Shop Status ===");
        System.out.println(s1.displayCompact());
        System.out.println(s2.displayCompact());
        System.out.println(s3.displayCompact());

        // Book some shops
        s1.book();
        s3.book();

        // Display compact details after booking
        System.out.println("\n=== After Booking ===");
        System.out.println(s1.displayCompact());
        System.out.println(s2.displayCompact());
        System.out.println(s3.displayCompact());

        // Cancel booking for one
        s1.cancelBooking();

        // Display compact details again
        System.out.println("\n=== After Cancel Booking ===");
        System.out.println(s1.displayCompact());
        System.out.println(s2.displayCompact());
        System.out.println(s3.displayCompact());

        // Show detailed output using toString()
        System.out.println("\n=== Detailed Shop Info ===");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
         
        System.out.println(s3.CompactLayout());
          // park 

        Park park1 = new Park("Rose Garden", PlotShape.RECTANGLE, 1);
        Park park2 = new Park("Family Park", PlotShape.TRAPEZOID, 2);
        System.out.println(park1);
        System.out.println(park2);
    
}
}