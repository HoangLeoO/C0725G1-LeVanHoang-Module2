package entity.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    private String code;
    private String fullName;
    private LocalDate birthday;
    private String gender;
    private String idCard;
    private String phone;
    private String email;

    public Person() {
    }

    public Person(String code, String fullName, LocalDate birthday, String gender, String idCard, String phone, String email) {
        this.code = code;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String toCSV();

    public void updateFrom(Person other) {
        if (other == null) return;

        this.setCode(other.getCode());
        this.setFullName(other.getFullName());
        this.setBirthday(other.getBirthday());
        this.setGender(other.getGender());
        this.setIdCard(other.getIdCard());
        this.setPhone(other.getPhone());
        this.setEmail(other.getEmail());
    }

    @Override
    public String toString() {
        return "Person{" +
                "code='" + code + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
