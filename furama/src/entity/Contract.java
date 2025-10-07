package entity;

public class Contract {
    private String contractNumber; // Số hợp đồng
    private String bookingCode;    // Mã booking
    private double deposit;        // Số tiền cọc trước
    private double totalPayment;   // Tổng số tiền thanh toán

    public Contract(String contractNumber, String bookingCode, double deposit, double totalPayment) {
        this.contractNumber = contractNumber;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
    }

    public Contract() {}

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
    @Override
    public String toString() {
        return "=== HỢP ĐỒNG ===\n" +
                "Số hợp đồng: " + contractNumber + "\n" +
                "Mã booking: " + bookingCode + "\n" +
                "Tiền cọc: " + deposit + "\n" +
                "Tổng thanh toán: " + totalPayment + "\n";
    }

}