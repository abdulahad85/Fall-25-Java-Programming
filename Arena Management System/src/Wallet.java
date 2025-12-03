

public class Wallet {

    private final String ownerId;
    private double balance = 0;

    public Wallet(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be > 0");
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be > 0");
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "ownerId='" + ownerId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
