public class Shop extends Plot {

    private String shopName;
    private boolean availability;

    public Shop(int plotNo, PlotShape shape, PlotType plotType, String shopName) {
        super(plotNo, shape, plotType);
        this.shopName = shopName;
        this.availability = super.isAvailable();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%-15s %-12s", shopName, checkAvailability(availability)));
        return sb.toString();
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public int getShopNo() {
        return getPlotNo();
    }

    public double getRentPrice() {
        return getPrice();
    }

    public boolean getAvailability() {
        return availability;
    }

    public boolean book() {
        if (!availability) {
            return false;
        }
        this.availability = false;
        setAvailable(false);
        return true;
    }

    public boolean cancelBooking() {
        if (availability) {
            return false;
        }
        this.availability = true;
        setAvailable(true);
        return true;
    }
    public String CompactLayout() {
        char status = isAvailable() ? 'A' : 'B';
        return "[" + getPlotId() + ":" + status + "]";
    }

    private String checkAvailability(boolean a) {
        return a ? "Available" : "Rented Out";
    }

    @Override
    public String displayCompact() {
        String status = availability ? "Available" : "Rented Out";
        return String.format("[Shop: %s] [ID: %s] [Type: %s] [Status: %s]",
                shopName,getPlotId(),getPlotType(),status);
    }
}
