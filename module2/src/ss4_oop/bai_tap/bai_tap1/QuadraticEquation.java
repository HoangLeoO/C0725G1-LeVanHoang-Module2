package ss4_oop.bai_tap.bai_tap1;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean isQuadraticEquation() {
        return a != 0;
    }

    public double[] getRoots() {
        double delta = this.getDiscriminant();
        if (delta > 0) {
            double[] arrayRoots = new double[2];
            arrayRoots[0] = (-b + Math.pow((Math.pow(b, 2) - 4 * a * c), 0.5)) / (2 * a);
            arrayRoots[1] = (-b - Math.pow((Math.pow(b, 2) - 4 * a * c), 0.5)) / (2 * a);
            return arrayRoots;
        } else if (delta == 0) {
            double[] arrayRoots = new double[1];
            arrayRoots[0] = (-b) / (2 * a);
            return arrayRoots;
        } else {
            return new double[0];
        }
    }
}
