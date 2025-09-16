package bai_tap_them.test;
import java.util.*;

class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Sắp xếp theo id tăng dần
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}



public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Bình"));
        list.add(new Student(1, "An"));
        list.add(new Student(2, "Cường"));

        Collections.sort(list); // sẽ gọi compareTo() của Student

        System.out.println(list);
    }
}