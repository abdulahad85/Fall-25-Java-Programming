
public class CaroomBoard extends PhysicalGame {

    public CaroomBoard(String id, String name, int totalBoards, double pricePerHour, double equipmentFeePerBooking) {
        super(id, name, totalBoards, pricePerHour, equipmentFeePerBooking);
    }

    @Override
    public String getGameCategory() {
        return "Carrom";
    }

    @Override
    public double calculateFinalPrice(int hours) {
        // Carrom boards typically have no equipment fee; still use parent calculation for flexibility
        return super.calculateFinalPrice(hours);
    }
}
