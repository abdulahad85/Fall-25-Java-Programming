

import java.time.LocalDateTime;

public class Transaction {

    public enum Type { DEPOSIT, WITHDRAW, BOOKING_PAYMENT }

    private final String transactionId;
    private final String userId;
    private final double amount;
    private final Type type;
    private final LocalDateTime timestamp;

    public Transaction(String transactionId, String userId, double amount, Type type) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }
    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public Type getType() { return type; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Transaction{id='" + transactionId +
                "', userId='" + userId +
                "', type=" + type +
                ", amount=" + amount +
                ", time=" + timestamp + "}";
    }
}

