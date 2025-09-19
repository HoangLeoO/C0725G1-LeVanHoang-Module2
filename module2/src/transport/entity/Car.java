package transport.entity;

public class Car extends Transport {
    private int numberOfSeats;
    private String vehicleType;

    public Car(){

    }

    public Car(String licensePlate, String manufacturer, int yearOfManufacture, String owner, int numberOfSeats, String vehicleType) {
        super(licensePlate, manufacturer, yearOfManufacture, owner);
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "  Loại xe        : Ôtô\n" +
                "  Số chỗ ngồi    : " + numberOfSeats + "\n" +
                "  Kiểu xe        : " + vehicleType + "\n" +
                "-----------------------------\n";
    }

    @Override
    public void updateFrom(Transport transport) {
        super.updateFrom(transport);
        if (transport instanceof Car c){
            this.numberOfSeats = c.getNumberOfSeats();
            this.vehicleType = c.getVehicleType();
        }
    }
}
