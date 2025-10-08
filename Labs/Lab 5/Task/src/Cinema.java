public class Cinema {
    private String cinemaName;
    private Screen[] screens;
    private int screenCount;

    public Cinema(String name, int screenCount) {
        this.cinemaName = name;
        this.screens = new Screen[screenCount];
        this.screenCount = screenCount;
        
        // Initialize screens with default names
        for (int i = 0; i < screenCount; i++) {
            screens[i] = new Screen("Screen-" + (i + 1));
        }
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public int getScreenCount() {
        return screenCount;
    }

    public Screen getScreen(int index) {
        if (index >= 0 && index < screenCount) {
            return screens[index];
        }
        return null;
    }

    public boolean bookSeat(String screenName, int row, int seat) {
        for (Screen screen : screens) {
            if (screen.getScreenName().equals(screenName)) {
                screen.bookSeatByCoordinates(row, seat);
                return true;
            }
        }
        return false;
    }

    public boolean cancelSeat(String screenName, int row, int seat) {
        for (Screen screen : screens) {
            if (screen.getScreenName().equals(screenName)) {
                screen.cancelSeatByCoordinates(row, seat);
                return true;
            }
        }
        return false;
    }

    public Seat findFirstAvailableVIP() {
        for (Screen screen : screens) {
            Seat vipSeat = screen.findFirstAvailable(Type.VIP);
            if (vipSeat != null) {
                return vipSeat;
            }
        }
        return null;
    }

    public int getTotalSeats() {
        int total = 0;
        for (Screen screen : screens) {
            total += screen.getTotalSeats();
        }
        return total;
    }

    public int getAvailableSeats() {
        int available = 0;
        for (Screen screen : screens) {
            available += screen.getAvailableSeats();
        }
        return available;
    }

    public int getAvailableSeats(Type type) {
        int available = 0;
        for (Screen screen : screens) {
            available += screen.getAvailableSeatsByType(type);
        }
        return available;
    }

    public void displayAllLayouts() {
        for (Screen screen : screens) {
            screen.printCompactLayout();
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Cinema: " + cinemaName + " | Screens: " + screenCount + 
               " | Total Seats: " + getTotalSeats() + 
               " | Available: " + getAvailableSeats();
    }
}
