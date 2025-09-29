package ss15_exceptions.bai_tap.bai_tap1;

public class Triangle {
    private double a;
    private double b;
    private double c;


    public Triangle() {

    }

    public Triangle(double a, double b, double c) throws TriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleException("Cạnh tam giác phải là số dương!");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }


}
