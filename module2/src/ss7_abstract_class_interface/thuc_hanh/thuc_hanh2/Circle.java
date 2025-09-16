package ss7_abstract_class_interface.thuc_hanh.thuc_hanh2;

public class Circle {
    private Double radius;
    private String color;
    private boolean filled;

    public Circle(Double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle() {
    }

    public Circle(double radius) {
    }

    public Circle(double radius, String color, boolean filled) {
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
