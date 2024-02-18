package HotelReservation;

public enum Discount {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    private double discountFactor;

    Discount(double discountFactor) {
        this.discountFactor = discountFactor;
    }

    public double getDiscountFactor() {
        return discountFactor;
    }

    public static Discount parse(String string) {
        switch (string) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown enum value " + string);
        }
    }
}
