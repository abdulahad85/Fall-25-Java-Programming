public abstract class OnlineGame extends Game {
    private int maxPlayersPerSession;
    public OnlineGame(String id, String name, int totalSessions, double pricePerHour, int maxPlayersPerSession) {
        super(id, name, totalSessions, pricePerHour);
        if (maxPlayersPerSession < 1) throw new IllegalArgumentException("maxPlayersPerSession must be >= 1");
        this.maxPlayersPerSession = maxPlayersPerSession;
    }
    public int getMaxPlayersPerSession() { return maxPlayersPerSession; }
    public void setMaxPlayersPerSession(int maxPlayersPerSession) {
        if (maxPlayersPerSession < 1) throw new IllegalArgumentException("must be >= 1");
        this.maxPlayersPerSession = maxPlayersPerSession;
    }
    @Override
    public double calculateFinalPrice(int hours) {
        if (hours < 0) throw new IllegalArgumentException("hours must be >= 0");
        return getPricePerHour() * hours;
    }
}
