package WorkingWithAbstraction.CardsWithPower_03Ex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        Card card = new Card(CardRank.valueOf(cardRank), CardSuit.valueOf(cardSuit));
        System.out.printf("Card name: %s of %s; Card power: %d%n",card.getRank(), card.getSuit(), card.getPower());
    }
}
