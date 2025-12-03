

public class PlatinumMember extends Members {

    private static final double DEFAULT_DISCOUNT = 20.0;

    public PlatinumMember(String memberId, String memberName) {
        super(memberId, memberName, DEFAULT_DISCOUNT);
    }

    @Override
    public double applyDiscount(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be >= 0");

        double discount = (getDiscountPercent() / 100.0) * amount;
        return amount - discount;
    }

    @Override
    public String toString() {
        return "PlatinumMember{" +
                "id='" + getMemberId() + '\'' +
                ", name='" + getMemberName() + '\'' +
                ", discount=" + getDiscountPercent() + "%}";
    }
}
