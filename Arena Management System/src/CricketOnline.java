
public class CricketOnline extends OnlineGame {

    public CricketOnline(String id, String name, int totalSessions, double pricePerHour, int maxPlayersPerSession) {
        super(id, name, totalSessions, pricePerHour, maxPlayersPerSession);
    }

    @Override
    public String getGameCategory() {
        return "Online Cricket";
    }

    @Override
    public double calculateFinalPrice(int hours) {
        // Could add dynamic pricing logic here later; currently basic
        return super.calculateFinalPrice(hours);
    }
}
