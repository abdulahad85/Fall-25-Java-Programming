
import java.util.Objects;


public abstract class Members {

    private final String memberId;
    private String memberName;
    private double discountPercent; // default percent to show, but subclasses may override behavior

    public Members(String memberId, String memberName, double discountPercent) {
        this.memberId = Objects.requireNonNull(memberId, "memberId required");
        this.memberName = Objects.requireNonNull(memberName, "memberName required");
        if (discountPercent < 0) throw new IllegalArgumentException("discountPercent must be >= 0");
        this.discountPercent = discountPercent;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = Objects.requireNonNull(memberName);
    }

    public double getDiscountPercent() {
        return discountPercent;
    }
    public void setDiscountPercent(double discountPercent) {
        if (discountPercent < 0) throw new IllegalArgumentException("discountPercent must be >= 0");
        this.discountPercent = discountPercent;
    }


    public abstract double applyDiscount(double amount);

    @Override
    public String toString() {
        return String.format("Member{id='%s', name='%s', baseDiscount=%.2f%%}",
                memberId, memberName, discountPercent);
    }
}

