package Shape;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public Double calculateArea() {
        return Math.PI * getRadius() * getRadius();
    }
}
