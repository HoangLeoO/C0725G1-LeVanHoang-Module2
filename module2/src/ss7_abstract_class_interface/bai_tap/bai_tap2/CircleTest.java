package ss7_abstract_class_interface.bai_tap.bai_tap2;

public class CircleTest {
    public static void main(String[] args) {
        Circle c = new Circle(10);
        System.out.println("Bán kính ban đầu: " + c.getRadius());

        c.resize(50); // tăng 50%
        System.out.println("Sau khi resize 50%: " + c.getRadius());

        c.resize(-20); // giảm 20%
        System.out.println("Sau khi resize -20%: " + c.getRadius());
    }
}