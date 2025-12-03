
public class FootballOnline extends OnlineGame {

    public FootballOnline(String id, String name, int totalSessions, double pricePerHour, int maxPlayersPerSession) {
        super(id, name, totalSessions, pricePerHour, maxPlayersPerSession);
    }

    @Override
    public String getGameCategory() {
        return "Online Football";
    }

    @Override
    public double calculateFinalPrice(int hours) {
        return super.calculateFinalPrice(hours);
    }
}
