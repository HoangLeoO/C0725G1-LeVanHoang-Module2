package transport.entity;

public abstract class Transport {
    private String licensePlate;
    private String manufacturer;
    private int yearOfManufacture;
    private String owner;

    public Transport() {

    }

    public Transport(String licensePlate, String manufacturer, int yearOfManufacture, String owner) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "=============================\n" +
                "   THÔNG TIN PHƯƠNG TIỆN\n" +
                "=============================\n" +
                "  Biển kiểm soát : " + this.licensePlate + "\n" +
                "  Hãng sản xuất  : " + this.manufacturer + "\n" +
                "  Năm sản xuất   : " + this.yearOfManufacture + "\n" +
                "  Chủ sở hữu     : " + this.owner + "\n"
             ;
    }
}
