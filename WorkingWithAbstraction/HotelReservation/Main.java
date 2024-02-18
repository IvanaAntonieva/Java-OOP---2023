package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(inputData[0]);
        int days = Integer.parseInt(inputData[1]);
        Season season = Season.parse(inputData[2]);
        Discount discount = Discount.parse(inputData[3]);

        PriceCalculator calculator = new PriceCalculator(pricePerDay, days, season, discount);

        System.out.printf("%.2f%n", calculator.calculatePrice());
    }
}
