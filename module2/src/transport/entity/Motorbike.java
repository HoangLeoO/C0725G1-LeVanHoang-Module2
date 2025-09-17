package transport.entity;

public class Motorbike extends Transport {
    private double enginePower;

    public Motorbike(){

    }

    public Motorbike(String licensePlate, String manufacturer, int yearOfManufacture, String owner, double enginePower) {
        super(licensePlate, manufacturer, yearOfManufacture, owner);
        this.enginePower = enginePower;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public String toString() {
        return super.toString() +
                "  Loại xe        : Xe máy\n" +
                "  Công suất      : " + enginePower + " cc\n" +
                "-----------------------------\n";
    }
}
