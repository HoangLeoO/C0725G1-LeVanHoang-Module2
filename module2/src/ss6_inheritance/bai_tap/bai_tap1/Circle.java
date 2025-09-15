package ss6_inheritance.bai_tap.bai_tap1;

public class Circle {
    private Double radius;
    private String color;

    public Circle(Double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle() {
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "radius : " + this.radius + " color : " + this.color;
    }
}
