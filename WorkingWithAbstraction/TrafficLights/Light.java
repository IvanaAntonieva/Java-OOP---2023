package WorkingWithAbstraction.TrafficLights;

public class Light {

    private Color color;

    public Light(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor() {
       if (getColor() == Color.RED) {
           setColor(Color.GREEN);
       } else if (getColor() == Color.GREEN) {
           setColor(Color.YELLOW);
       } else if (getColor() == Color.YELLOW) {
           setColor(Color.RED);
       }
    }
}
