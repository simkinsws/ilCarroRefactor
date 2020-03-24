package ilcarro.ilcarro.dto.reservationDto;

import java.time.LocalDate;


public class ReservationResponseDto {
    private long orderNumber;
    private float amount;
    private LocalDate bookingDate;

    public ReservationResponseDto(long orderNumber, float amount, LocalDate bookingDate) {
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.bookingDate = bookingDate;
    }

    public ReservationResponseDto() {
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
