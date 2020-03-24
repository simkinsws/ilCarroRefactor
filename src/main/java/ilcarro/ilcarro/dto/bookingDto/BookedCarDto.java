package ilcarro.ilcarro.dto.bookingDto;

public class BookedCarDto {
    private String serialNumber;
    private BookedPeriodDto bookedPeriodDto;

    public BookedCarDto(String serialNumber, BookedPeriodDto bookedPeriodDto) {
        this.serialNumber = serialNumber;
        this.bookedPeriodDto = bookedPeriodDto;
    }

    public BookedCarDto() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BookedPeriodDto getBookedPeriodDto() {
        return bookedPeriodDto;
    }

    public void setBookedPeriodDto(BookedPeriodDto bookedPeriodDto) {
        this.bookedPeriodDto = bookedPeriodDto;
    }
}
