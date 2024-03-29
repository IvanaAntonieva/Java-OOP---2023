package Encapsulation.FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Team team = new Team("Black Eagles");

        while (n-- > 0) {
            String[] data = reader.readLine().split(" ");

            String firstName = data[0];
            String secondName = data[1];
            int age = Integer.parseInt(data[2]);
            double salary = Double.parseDouble(data[3]);
            Person person = new Person(firstName, secondName, age, salary);
            
            team.addPlayer(person);
        }
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
