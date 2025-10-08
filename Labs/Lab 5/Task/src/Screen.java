public class Screen {
    private Seat[][] seats;
    private String screenName;

    private double priceStandard;
    private double pricePremium;
    private double priceVip;
    private double priceRecliner;

    Screen(String name) {
        screenName = name;

        priceStandard = 500.0;
        pricePremium = 750.0;
        priceVip = 1000.0;
        priceRecliner = 1200.0;

        seats = new Seat[4][]; // 4 rows

        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat[9 + i]; // each next row has one more seat

            for (int j = 0; j < seats[i].length; j++) {
                String seatId = String.format("R%d-%03d", i + 1, j + 1);

                if (i == 0) {
                    seats[i][j] = new Seat(Type.STANDARD, seatId, priceStandard, true);
                } else if (i == 1) {
                    seats[i][j] = new Seat(Type.PREMIUM, seatId, pricePremium, true);
                } else if (i == 2) {
                    seats[i][j] = new Seat(Type.VIP, seatId, priceVip, true);
                } else { // i == 3
                    seats[i][j] = new Seat(Type.RECLINER, seatId, priceRecliner, true);
                }
            }
        }
    }

    Screen() {}

    public String getScreenName() {
        return screenName;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n============ ").append(screenName).append(" ============\n");
        str.append(String.format("%-10s %-12s %-10s %-10s\n", "Seat ID", "Type", "Price", "Available"));
        str.append("---------------------------------------------------\n");

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                Seat seat = seats[i][j];
                str.append(String.format("%-10s %-12s %-10.0f %-10s\n",
                        seat.getId(), seat.getSeatType(), seat.getPrice(), seat.isAvailable()));
            }
        }
        return str.toString();
    }

       public void findSeatById(String id) {
        Seat seat = null;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null) 
           continue;
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] != null && seats[i][j].getId().equals(id)) {
                    seat = seats[i][j];
                }
            }
        }
        if (seat != null)
            System.out.println("Found Seat by ID: " + seat);
        else
            System.out.println("Seat not found!");
    }


    public void findSeatByCoordinates(int row, int col) {
        if (row >= 1 && row <= seats.length && col >= 1 && col <= seats[row - 1].length)
            System.out.println("Found Seat at (" + row + "," + col + "): " + seats[row - 1][col - 1]);
        else
            System.out.println("No seat at (" + row + "," + col + ")");
    }

    private Seat findSeat(String id) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] != null && seats[i][j].getId().equals(id)) {
                    return seats[i][j];
                }
            }
        }
        return null;
    }

    public void bookSeatById(String id) {
        Seat seat = findSeat(id);
        if (seat == null)
            System.out.println("Seat not found!");
        else if (seat.bookSeat())
            System.out.println("Seat " + id + " booked successfully!");
        else
            System.out.println("Seat " + id + " is already booked!");
    }

    public void cancelSeatById(String id) {
        Seat seat = findSeat(id);
        if (seat == null)
            System.out.println("Seat not found!");
        else if (seat.cancelBooking())
            System.out.println("Seat " + id + " booking cancelled!");
        else
            System.out.println("Seat " + id + " was not booked!");
    }

    public void bookSeatByCoordinates(int row, int col) {
        if (row >= 1 && row <= seats.length && col >= 1 && col <= seats[row - 1].length) {
            if (seats[row - 1][col - 1].bookSeat())
                System.out.println("Seat (" + row + "," + col + ") booked successfully!");
            else
                System.out.println("Seat (" + row + "," + col + ") is already booked!");
        } else {
            System.out.println("Invalid coordinates!");
        }
    }

    public void cancelSeatByCoordinates(int row, int col) {
        if (row >= 1 && row <= seats.length && col >= 1 && col <= seats[row - 1].length) {
            if (seats[row - 1][col - 1].cancelBooking())
                System.out.println("Seat (" + row + "," + col + ") cancelled successfully!");
            else
                System.out.println("Seat (" + row + "," + col + ") was not booked!");
        } else {
            System.out.println("Invalid coordinates!");
        }
    }

    public void displaySeatCounts() {
        System.out.println("Total Seats: " + getTotalSeats());
        System.out.println("Available Seats: " + getAvailableSeats());
        System.out.println("Standard Seats: " + getSeatsByType(Type.STANDARD));
        System.out.println("Premium Seats: " + getSeatsByType(Type.PREMIUM));
        System.out.println("VIP Seats: " + getSeatsByType(Type.VIP));
        System.out.println("Recliner Seats: " + getSeatsByType(Type.RECLINER));
        System.out.println("Available VIP Seats: " + getAvailableSeatsByType(Type.VIP));
    }

    public void displayFirstAvailableSeat(Type type) {
        Seat seat = findFirstAvailable(type);
        if (seat != null)
            System.out.println("First available " + type + " seat: " + seat);
        else
            System.out.println("No available " + type + " seat found.");
    }

    public void displayAvailableSeatsByType(Type type) {
        Seat[] availableSeats = listAvailable(type);
        System.out.println("Available " + type + " Seats: " + availableSeats.length);
        for (int i = 0; i < availableSeats.length; i++) {
            System.out.println(availableSeats[i]);
        }
    }

    public void displayPrices() {
        System.out.println("Standard Price: " + priceStandard);
        System.out.println("Premium Price: " + pricePremium);
        System.out.println("VIP Price: " + priceVip);
        System.out.println("Recliner Price: " + priceRecliner);
    }

    public int getTotalSeats() {
        int total = 0;
        for (int i = 0; i < seats.length; i++) {
            total += seats[i].length;
        }
        return total;
    }

    public int getAvailableSeats() {
        int available = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++)
                if (seats[i][j] != null && seats[i][j].isAvailable())
                    available++;
        }
        return available;
    }

    public int getSeatsByType(Type type) {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++)
                if (seats[i][j] != null && seats[i][j].getSeatType() == type)
                    count++;
        }
        return count;
    }

    public int getAvailableSeatsByType(Type type) {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++)
                if (seats[i][j] != null && seats[i][j].getSeatType() == type && seats[i][j].isAvailable())
                    count++;
        }
        return count;
    }

    public Seat findFirstAvailable(Type type) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++)
                if (seats[i][j] != null && seats[i][j].getSeatType() == type && seats[i][j].isAvailable())
                    return seats[i][j];
        }
        return null;
    }

    public Seat[] listAvailable(Type type) {
        int count = getAvailableSeatsByType(type);
        Seat[] result = new Seat[count];
        int index = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++)
                if (seats[i][j] != null && seats[i][j].getSeatType() == type && seats[i][j].isAvailable())
                    result[index++] = seats[i][j];
        }
        return result;
    }

    public void printCompactLayout() {
        System.out.println("Screen: " + screenName + "  Layout");

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                Seat seat = seats[i][j];
                String availability = seat.isAvailable() ? "A" : "B";
                System.out.print("[" + (i + 1) + "-" + String.format("%03d", j + 1) + ":" + availability + "] ");
            }
            System.out.println();
        }

        System.out.println("Total: " + getTotalSeats() + ", Available: " + getAvailableSeats());
        System.out.println("(A = Available, B = Booked)");
    }

    public void printDetailedListing() {
        System.out.println("Screen: " + screenName + " -  List");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++)
                if (seats[i][j] != null)
                    System.out.println(seats[i][j]);
        }
        System.out.println();
    }

    public void setRowType(int row, Type type, Double price) {
        if (row >= 1 && row <= seats.length) {
            for (int j = 0; j < seats[row - 1].length; j++) {
                Seat old = seats[row - 1][j];
                seats[row - 1][j] = new Seat(type, old.getId(), price, old.isAvailable());
            }
        } else {
            System.out.println("Invalid row number!");
        }
    }

    public Type seatTypeFor(int row, int col) {
        if (row < 1 || row > seats.length) {
            System.out.println("Invalid row number!");
            return null;
        }
        if (col < 1 || col > seats[row - 1].length) {
            System.out.println("Invalid column number for this row!");
            return null;
        }
        return seats[row - 1][col - 1].getSeatType();
    }

    public double priceFor(Type type) {
        switch (type) {
            case STANDARD: return priceStandard;
            case PREMIUM: return pricePremium;
            case VIP: return priceVip;
            case RECLINER: return priceRecliner;
            default: return 0.0;
        }
    }

    public int getRowLength(int row) {
        if (row >= 1 && row <= seats.length)
            return seats[row - 1].length;
        else
            return 0;
    }

    public int getRowCount() {
        return seats.length;
    }

    public void displayLayout() {
        int total = 0;
        int available = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null)
                continue;

            for (int j = 0; j < seats[i].length; j++) {
                Seat seat = seats[i][j];
                String seatDisplay = String.format("[%d-%03d:%s]", i + 1, j + 1, seat.isAvailable() ? "A" : "B");
                System.out.print(seatDisplay + " ");

                total++;
                if (seat.isAvailable())
                    available++;
            }
            System.out.println();
        }
        System.out.println("Total: " + total + ", Available: " + available);
    }
}
