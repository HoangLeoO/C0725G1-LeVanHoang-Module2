package ss6_inheritance.bai_tap.bai_tap1;

import ss4_oop.bai_tap.bai_tap2.Main;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(Double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getTheTich(){
        return Math.PI*Math.pow(super.getRadius(),2)*this.height;
    }

    @Override
    public String toString() {
        return super.toString() + " height : " + this.height;
    }
}
