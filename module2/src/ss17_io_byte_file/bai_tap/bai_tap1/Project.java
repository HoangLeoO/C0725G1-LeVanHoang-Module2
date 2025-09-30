package ss17_io_byte_file.bai_tap.bai_tap1;

import java.io.Serializable;

public class Project implements Serializable {
    private String code;
    private String name;
    private double price;
    private String manufacturer;
    private String describe;

    public Project() {
    }

    public Project(String code, String name, double price, String manufacturer, String describe) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
