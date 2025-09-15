package ss6_inheritance.bai_tap.bai_tap1;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0,"blue");
        Cylinder cylinder = new Cylinder(circle.getRadius(),circle.getColor(),20.0);
        System.out.println("Circle : " + circle.toString());
        System.out.println("Cylinder : " + cylinder.toString());
        System.out.println("Cylinder the tich : " + cylinder.getTheTich());
    }
}
