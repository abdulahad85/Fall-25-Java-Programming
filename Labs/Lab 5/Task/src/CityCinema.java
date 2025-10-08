public class CityCinema {
    private String cityName;
    private Cinema[] cinemas;
    private int count;

    public CityCinema(String cityName, int capacity) {
        this.cityName = cityName;
        cinemas = new Cinema[capacity];
        count = 0;
    }

    public void addCinema(String name, int screenCount) {
        if (count == cinemas.length) {
            Cinema[] temp = new Cinema[cinemas.length * 2];
            for (int i = 0; i < cinemas.length; i++)
                temp[i] = cinemas[i];
            cinemas = temp;
        }
        cinemas[count++] = new Cinema(name, screenCount);
        System.out.println("Cinema added: " + name);
    }

  public Cinema findCinema(String name) {
    for (int i = 0; i < count; i++) {
        String cinemaName = cinemas[i].getCinemaName();

     
        if (cinemaName.equals(name)) {  
            return cinemas[i];
        }
    }
    return null;
}


    public boolean bookSeat(String cinemaName, String screenName, int row, int seat) {
        Cinema c = findCinema(cinemaName);
        if (c != null)
            return c.bookSeat(screenName, row, seat);
        System.out.println("Cinema not found!");
        return false;
    }

    public boolean cancelSeat(String cinemaName, String screenName, int row, int seat) {
        Cinema c = findCinema(cinemaName);
        if (c != null)
            return c.cancelSeat(screenName, row, seat);
        System.out.println("Cinema not found!");
        return false;
    }

    public Seat findFirstVIPSeat() {
        for (int i = 0; i < count; i++) {
            Seat vipSeat = cinemas[i].findFirstAvailableVIP();
            if (vipSeat != null)
                return vipSeat;
        }
        return null;
    }

    public int getTotalSeats() {
        int total = 0;
        for (int i = 0; i < count; i++)
            total += cinemas[i].getTotalSeats();
        return total;
    }

    public int getAvailableSeats() {
        int total = 0;
        for (int i = 0; i < count; i++)
            total += cinemas[i].getAvailableSeats();
        return total;
    }

    public int getAvailableSeats(Type type) {
        int total = 0;
        for (int i = 0; i < count; i++)
            total += cinemas[i].getAvailableSeats(type);
        return total;
    }

    public void preloadCity() {
        addCinema("MegaStar", 2);
        addCinema("Galaxy", 3);
        addCinema("StarView", 2);
    }

    public void displayAll() {
        System.out.println("\nCity: " + cityName);
        for (int i = 0; i < count; i++) {
            System.out.println(cinemas[i]);
            cinemas[i].displayAllLayouts();
        }
        System.out.println("\nTotal Seats: " + getTotalSeats());
        System.out.println("Available Seats: " + getAvailableSeats());
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "City: " + cityName + " | Cinemas: " + count +
                " | Total Seats: " + getTotalSeats() +
                " | Available: " + getAvailableSeats();
    }
}
