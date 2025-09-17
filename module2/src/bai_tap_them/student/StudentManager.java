package bai_tap_them.student;

public class StudentManager {
    private static Student[] students = new Student[100];

    static {
        students[0] = new Student(1, "Hoang");
        students[1] = new Student(2, "Nguyen");
        students[2] = new Student(3, "Khanh");
        students[3] = new Student(4, "Tung");
    }

    public Student[] getStudents() {
        return students;
    }

    public void listStudents() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i].toString());
            }
        }
    }

    public void addStudent(String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                int id = i + 1;
                for (Student student : students) {
                    if (student != null) {
                        if (student.getId() == id) {
                            id++;
                        }
                    }
                }
                students[i] = new Student(id, name);
                break;
            }
        }
    }

    public void editStudent(int id, String name) {
        for (Student student : students) {
            if (student != null) {
                if (student.getId() == id) {
                    student.setName(name);
                }
            }
        }
    }

    public void deleteId(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                students[i] = null;
                break;
            }
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null && students[i+1] != null ) {
                for (int j = i + 1; j < students.length; j++) {
                    if (students[j] != null) {
                        Student temp = students[j];
                        students[j] = students[i];
                        students[i] = temp;
                        break;
                    }
                }
            }
        }
    }

}
