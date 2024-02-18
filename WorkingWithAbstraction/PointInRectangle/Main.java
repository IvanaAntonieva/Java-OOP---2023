package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();

        Point bottomLeft = new Point(rectangleCoordinates[0], rectangleCoordinates[1]);
        Point topRight = new Point(rectangleCoordinates[2], rectangleCoordinates[3]);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Point currentPoint = PointUtil.pointUtil(scanner.nextLine());
            System.out.println(rectangle.contains(currentPoint));
        }
    }
}
