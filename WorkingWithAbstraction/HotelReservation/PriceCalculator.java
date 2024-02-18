package HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public double calculatePrice() {
        return pricePerDay * days * season.getMultiplier() * discount.getDiscountFactor();
    }

    public PriceCalculator(double pricePerDay, int numberOFDays, Season season, Discount discountType) {
        this.pricePerDay = pricePerDay;
        this.days = numberOFDays;
        this.season = season;
        this.discount = discountType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
