package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);
        Pizza pizza = null;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughInfo = scanner.nextLine().split("\\s+");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double weightInGrams = Double.parseDouble(doughInfo[3]);
        try {
            Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String toppingInfo = scanner.nextLine();
        while (!toppingInfo.equals("END")) {
            String[] toppingData = toppingInfo.split("\\s+");
            String toppingType = toppingData[1];
            double toppingWeightInGrams = Double.parseDouble(toppingData[2]);

            try {
                Topping topping = new Topping(toppingType, toppingWeightInGrams);
                pizza.addTopping(topping);
                numberOfToppings--;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            if (numberOfToppings > 0) {
                toppingInfo = scanner.nextLine();
            } else {
                break;
            }
        }
        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
