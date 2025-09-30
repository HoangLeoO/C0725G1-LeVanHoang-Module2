package entity.person;

import entity.enums.EducationLevel;
import entity.enums.Position;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Person {
    private EducationLevel level;
    private Position position;
    private double salary;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Employee(){}

    public Employee(String code, String fullName, LocalDate birthday, String gender, String idCard, String phone, String email, EducationLevel level, Position position, double salary) {
        super(code, fullName, birthday, gender, idCard, phone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public EducationLevel getLevel() {
        return level;
    }

    public void setLevel(EducationLevel level) {
        this.level = level;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toCSV() {
        return String.join(",",
                super.getCode(),
                super.getFullName(),
                super.getBirthday().format(FORMATTER),
                super.getGender(),
                super.getIdCard(),
                super.getPhone(),
                super.getEmail(),
                level.name(),
                position.name(),
                String.valueOf(salary)
        );
    }

    public static Employee fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Employee(
                parts[0],
                parts[1],
                LocalDate.parse(parts[2], FORMATTER),
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                EducationLevel.valueOf(parts[7]),
                Position.valueOf(parts[8]),
                Double.parseDouble(parts[9])
        );
    }

    @Override
    public void updateFrom(Person other) {
        super.updateFrom(other);
        if (other instanceof Employee) {
            Employee e = (Employee) other;
            this.position = e.position;
            this.salary = e.salary;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
