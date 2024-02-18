package PointInRectangle;

public class PointUtil {
    public static Point pointUtil(String input) {
        String[] pointCoordinates = input.split("\\s+");
        int pointX = Integer.parseInt(pointCoordinates[0]);
        int pointY = Integer.parseInt(pointCoordinates[1]);
        return new Point(pointX, pointY);
    }
}
