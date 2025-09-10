package ss4_oop.bai_tap.bai_tap3;

public class Fan {
    private final byte SLOW = 1, MEDIUM = 2, FAST = 3;
    private int speed;
    private boolean turnFan;
    private double radius;
    private String color;

    public Fan() {
        this.speed = this.SLOW;
        this.turnFan = false;
        this.radius = 5;
        this.color = "Blue";
    }

    public byte getSLOW() {
        return SLOW;
    }

    public byte getMEDIUM() {
        return MEDIUM;
    }

    public byte getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isTurnFan() {
        return turnFan;
    }

    public void setTurnFan(boolean turnFan) {
        this.turnFan = turnFan;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
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
        if (this.turnFan) {
            return "Fan{" +
                    "speed=" + speed +
                    ", turnFan=" + true +
                    ", radius=" + radius +
                    ", color='" + color  +
                    ", fan is on" +
                    '}';
        } else {
            return "Fan{" +
                    "turnFan=" + false +
                    ", radius=" + radius +
                    ", color='" + color  +
                    ", fan is off" +
                    '}';
        }

    }
}
