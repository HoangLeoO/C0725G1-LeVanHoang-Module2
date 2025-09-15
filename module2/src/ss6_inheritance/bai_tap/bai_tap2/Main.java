package ss6_inheritance.bai_tap.bai_tap2;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point3D();
        point2D.setXY(1,2);
        System.out.println(point2D.toString());
        Point3D point3D = (Point3D) point2D;
        point3D.setXYZ(1, 2, 3);
        System.out.println(point3D.toString());
    }
}
