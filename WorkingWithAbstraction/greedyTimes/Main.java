
package workingWithAbstraction.greedyTimes;

import WorkingWithAbstraction.greedyTimes.Bag;
import WorkingWithAbstraction.greedyTimes.Item;
import WorkingWithAbstraction.greedyTimes.Type;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < safe.length; i += 2) {
            String itemName = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            if (itemName.equalsIgnoreCase("Gold")) {
                itemName = "Gold";
            }

            try {
                Item item = new Item(Type.parse(itemName), itemName, amount);
                bag.put(item);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        bag.printContent();
    }
}