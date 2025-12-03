
public class Snooker extends PhysicalGame {

    public Snooker(String id, String name, int totalTables, double pricePerHour, double equipmentFeePerBooking) {
        super(id, name, totalTables, pricePerHour, equipmentFeePerBooking);
    }

    @Override
    public String getGameCategory() {
        return "Snooker";
    }

    @Override
    public double calculateFinalPrice(int hours){
        return super.calculateFinalPrice(hours);
    }
}
