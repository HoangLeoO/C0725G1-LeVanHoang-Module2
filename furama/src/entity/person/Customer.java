package entity.person;

import entity.enums.CustomerType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer extends Person {
    private CustomerType customerType;
    private String address;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Customer() {
    }

    public Customer(String code, String fullName, LocalDate birthday, String gender,
                    String idCard, String phone, String email,
                    CustomerType customerType, String address) {
        super(code, fullName, birthday, gender, idCard, phone, email);
        this.customerType = customerType;
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toCSV() {
        return String.join(",",
                getCode(), getFullName(),
                super.getBirthday().format(FORMATTER),
                super.getGender(),
                super.getIdCard(),
                super.getPhone(),
                super.getEmail(),
                this.customerType.name(),
                this.address
        );
    }

    @Override
    public void updateFrom(Person other) {
        super.updateFrom(other);
        if (other instanceof Customer c) {
            this.customerType = c.customerType;
            this.address = c.address;
        }
    }

    public static Customer fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Customer(
                parts[0],
                parts[1],
                LocalDate.parse(parts[2], FORMATTER),
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                CustomerType.valueOf(parts[7]),
                parts[8]
        );
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +   // gọi toString() của Person
                ", customerType=" + this.customerType +
                ", address='" + this.address + '\'' +
                '}';
    }
}
