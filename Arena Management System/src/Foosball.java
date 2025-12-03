
public class Foosball extends PhysicalGame {

    public Foosball(String id, String name, int totalTables, double pricePerHour, double equipmentFeePerBooking) {
        super(id, name, totalTables, pricePerHour, equipmentFeePerBooking);
    }

    @Override
    public String getGameCategory() {
        return "Foosball";
    }

    @Override
    public double calculateFinalPrice(int hours) {
        return super.calculateFinalPrice(hours);
    }
}
