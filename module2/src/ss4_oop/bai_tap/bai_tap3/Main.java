package ss4_oop.bai_tap.bai_tap3;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setTurnFan(true);
        System.out.println(fan1.toString());
        fan1.setColor("Red");
        System.out.println(fan2.toString());
    }
}
