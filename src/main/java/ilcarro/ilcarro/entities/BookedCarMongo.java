package ilcarro.ilcarro.entities;

public class BookedCarMongo {

    private String serialNumber;
    private RenterBookedPeriod bookedPeriod;

    public BookedCarMongo(String serialNumber, RenterBookedPeriod bookedPeriod) {
        this.serialNumber = serialNumber;
        this.bookedPeriod = bookedPeriod;
    }

    public BookedCarMongo() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public RenterBookedPeriod getBookedPeriod() {
        return bookedPeriod;
    }

    public void setBookedPeriod(RenterBookedPeriod bookedPeriod) {
        this.bookedPeriod = bookedPeriod;
    }
}
