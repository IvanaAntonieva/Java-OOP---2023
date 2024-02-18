package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> birthableList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputParts = input.split("\\s+");
            switch (inputParts[0]) {
                case "Citizen":
                    String name = inputParts[1];
                    int age = Integer.parseInt(inputParts[2]);
                    String id = inputParts[3];
                    String birthDate = inputParts[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    birthableList.add(citizen);
                    break;
                case "Pet":
                    String petName = inputParts[1];
                    String petBirthDate = inputParts[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    birthableList.add(pet);
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();
        boolean isFound = false;

        for (Birthable birthable : birthableList) {
            if (birthable.getBirthDate().endsWith(year)) {
                isFound = true;
                System.out.println(birthable.getBirthDate());
            }
        }
        if (!isFound) {
            System.out.println("<no output>");
        }
    }
}
