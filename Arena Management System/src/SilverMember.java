
public class SilverMember extends Members {

    private static final double DEFAULT_DISCOUNT = 5.0; // percent

    public SilverMember(String memberId, String memberName) {
        super(memberId, memberName, DEFAULT_DISCOUNT);
    }


    @Override
    public double applyDiscount(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount must be >= 0");
        double discount = (getDiscountPercent() / 100.0) * amount;
        return amount - discount;
    }

    @Override
    public String toString() {
        return "SilverMember{" + "id='" + getMemberId() + '\'' +
                ", name='" + getMemberName() + '\'' +
                ", discount=" + getDiscountPercent() + "%}";
    }
}
