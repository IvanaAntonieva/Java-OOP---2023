package Encapsulation.ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box (double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    };
    private void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double calculateSurfaceArea() {
        return 2 * (this.length * this.width + this.length * this.height + this.height * this.width);
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.height * (this.length + this.width);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}
