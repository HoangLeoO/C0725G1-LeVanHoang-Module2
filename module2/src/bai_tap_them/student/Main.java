package bai_tap_them.student;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showList();
    }

    public static void showList() {
        Scanner scanner = new Scanner(System.in);
        boolean flat = true;
        StudentManager studentManager = new StudentManager();
        do {
            System.out.println("======Menu======");
            System.out.println("1.Show List. \n");
            System.out.println("2.Create Student. \n");
            System.out.println("3.Edit Student. \n");
            System.out.println("4.Delete Student. \n");
            System.out.println("5.Exit. \n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("List Student");
                    Student[] students = studentManager.getStudents();
                    for (Student student : students) {
                        if (student != null) {
                            System.out.println(student.getId() + " : " + student.getName());
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Create Student");
                    System.out.println("Name");
                    String name = scanner.nextLine();
                    studentManager.addStudent(name);
                }
                case 3 -> {
                    System.out.println("Edit Student");
                    System.out.println(" Id  student edit ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println(" New Name : ");
                    String name = scanner.nextLine();
                    studentManager.editStudent(id, name);
                }
                case 4 -> {
                    System.out.println("Delete Student");
                    System.out.println(" Id  student edit ");
                    int id = Integer.parseInt(scanner.nextLine());
                    studentManager.deleteId(id);
                }
                default -> {
                    flat = false;
                }
            }

        } while (flat);
    }
}
