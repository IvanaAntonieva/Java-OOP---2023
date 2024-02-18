package RandomArrayList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<Integer>();
        randomArrayList.add(2);
        randomArrayList.add(4);
        randomArrayList.add(8);
        randomArrayList.add(29);
        randomArrayList.add(28);
        System.out.println(randomArrayList.getRandomElement());
    }
}
