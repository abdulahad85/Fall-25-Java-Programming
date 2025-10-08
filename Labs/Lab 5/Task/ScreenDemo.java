public class ScreenDemo {
    public static void main(String[] args) {
   
        Screen screen = new Screen("Main Hall");

 
        System.out.println(screen); // Print complete seat info

        // screen.printCompactLayout();
        // screen.printDetailedListing();
        // screen.displayLayout();
        // screen.displayVerbose();


        // screen.findSeatById("R1-001");
        // screen.findSeatByCoordinates(2, 3);
    

        screen.bookSeatById("R2-003");
        screen.bookSeatById("R1-003"); 
        screen.printCompactLayout();
        screen.cancelSeatById("R2-003");
        screen.cancelSeatById("R1-003");
   screen.printCompactLayout();
     
    //     screen.bookSeatByCoordinates(3, 2);
    //     screen.cancelSeatByCoordinates(3, 2);
    //     screen.bookSeatByCoordinates(5, 1); // invalid coordinate

    
    //     screen.displaySeatCounts();

    //     // Display available seat counts by type
    //     screen.displayAvailableSeatsByType(Type.VIP);
    //     screen.displayFirstAvailableSeat(Type.PREMIUM);


    //     screen.displayPrices();
    //     System.out.println("Price for VIP: " + screen.priceFor(Type.VIP));
    //     System.out.println("Price for STANDARD: " + screen.priceFor(Type.STANDARD));

      
    //     System.out.println("Total Rows: " + screen.getRowCount());
    //     System.out.println("Row 3 Length: " + screen.getRowLength(3));


    //     System.out.println("\nBefore Changing Row 4 Type:");
    //     screen.displayLayout();
    //     screen.setRowType(3, Type.VIP, 950.0); // change row 4 type
    //     System.out.println("\nAfter Changing Row 4 Type:");
    //     screen.displayLayout();

   
    //     screen.checkRow(10); // invalid row
    //     screen.checkBounds(2, 20); // invalid coordinate

      
    //     screen.buildDefaultRowLengths(9);

      
    //     System.out.println("\nSeat Type for (2, 1): " + screen.seatTypeFor(2, 1));
    //     System.out.println("Seat Type for (4, 1): " + screen.seatTypeFor(4, 1));


    //     System.out.println("\nFinal Layout:");
    //     screen.printCompactLayout();
    //     screen.displaySeatCounts();

    //   screen.bookSeatById("R1-005");
    //   screen.bookSeatById("R2-005");
    //     screen.printCompactLayout();

    }
}
