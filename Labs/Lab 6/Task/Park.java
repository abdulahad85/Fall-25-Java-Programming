public class Park {

    private String parkName;
    private String parkId;
    private PlotShape shape;
    private int parkNo;

    public Park(String parkName, PlotShape shape, int parkNo) {
        this.parkName = parkName;
        this.shape = shape;
        this.parkNo = parkNo;
        setParkId(parkNo);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %10.2f sq.units", parkId,parkName,calArea());
    }

    // ----- Setters and Getters -----
    public void setParkId(int parkNo) {
        this.parkId = String.format("P-%03d", parkNo);
    }

    public String getParkId() {
        return parkId;
    }

    public void setShape(PlotShape shape) {
        this.shape = shape;
    }

    public PlotShape getShape() {
        return shape;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public double calArea() {
        return shape.calArea(shape);
    }
}
