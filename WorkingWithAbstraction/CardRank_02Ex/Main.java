package WorkingWithAbstraction.CardRank_02Ex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Ranks:");
        for (Rank value : Rank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
        }
    }
}
