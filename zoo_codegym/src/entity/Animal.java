package entity;

public abstract class Animal {
    private String id;
    private String name;
    private int birthYear;
    private String cage;


    public Animal() {
    }


    public Animal(String id, String name, int birthYear, String cage) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.cage = cage;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    // toString để in ra thông tin đối tượng
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", cage='" + cage + '\'' +
                '}';
    }

}
