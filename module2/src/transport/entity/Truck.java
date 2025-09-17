package transport.entity;

public class Truck extends Transport {
    private double payloadCapacity;

    public Truck(){

    }

    public Truck(String licensePlate, String manufacturer, int yearOfManufacture, String owner, double payloadCapacity) {
        super(licensePlate, manufacturer, yearOfManufacture, owner);
        this.payloadCapacity = payloadCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "  Loại xe        : Xe tải\n" +
                "  Trọng tải      : " + payloadCapacity + " tấn\n" +
                "-----------------------------\n";
    }
}
