public class Plot {
    private String plotId;
    private PlotShape shape;
    private PlotType type;
    private double price;
    private boolean isAvailable;
    private int plotNo;
    private int streetNo;
    private String blockName;
    private String societyName;
    private String cityName;

    // Constructor for residential plots
    public Plot(int streetNo, int plotNo, PlotShape shape, PlotType type, String blockName, String societyName, String cityName) {
        this.streetNo = streetNo;
        this.plotNo = plotNo;
        this.shape = shape;
        this.type = type;
        this.blockName = blockName;
        this.societyName = societyName;
        this.cityName = cityName;
        this.isAvailable = true;
        this.plotId = String.format("%d-%03d", streetNo, plotNo);
        setPrice();
    }

    // Constructor for shops or commercial plots
    public Plot(int plotNo, PlotShape shape, PlotType type) {
        this.plotNo = plotNo;
        this.shape = shape;
        this.type = type;
        this.isAvailable = true;
        this.plotId = String.format("C-%03d", plotNo);
        setPrice();
    }

    // Default constructor
    public Plot() {}

    public double calculateArea() {
        return shape.calArea(shape);
    }

    // Method to book the plot
    public boolean bookPlot() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Plot " + plotId + " booked successfully!");
            return true;
        } else {
            System.out.println("Plot " + plotId + " is already booked!");
            return false;
        }
    }

    // Method to cancel booking
    public boolean cancelBooking() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Booking cancelled for plot " + plotId);
            return true;
        } else {
            System.out.println("Plot " + plotId + " was not booked!");
            return false;
        }
    }

    // Compact view (A for available, B for booked)
    public String displayCompact() {
        char status = isAvailable ? 'A' : 'B';
        return "[" + plotId + ":" + status + "]";
    }

    @Override
    public String toString() {
        return String.format("%-10s %-18s %,.2f sq.units  %-10s %-10s %-10s  PKR %-18.2f %-10b ", this.getPlotId(), type.name(), calculateArea(), price,blockName,societyName,cityName, isAvailable);
    }

    // Price setup
    public void setPrice() {
        price = type.getBasePrice();
    }

    // Getters
    public String getPlotId() {
        return plotId;
    }

    public PlotShape getShape() {
        return shape;
    }

    public PlotType getPlotType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
                                                                                                                                                                                             
    public boolean isAvailable() {
        return isAvailable;
    }

    public int getPlotNo() {
        return plotNo;
    }

    public int getStreetNo() {
        return streetNo;
    }
      public String getBlockName() {
        return blockName;
    }
      public String getCityName() {
        return cityName;
    }
      public String getSocietyName() {
        return societyName;
    }


    // Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}