package ilcarro.ilcarro.dto.bookingDto;

import ilcarro.ilcarro.dto.Renter;

import java.time.LocalDate;
import java.util.Date;

public class BookedPeriodDto {
    private long order_id;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean paid;
    private float amount;
    private LocalDate bookingDate;
    private Renter personWhoBooked;

    public BookedPeriodDto(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BookedPeriodDto(long order_id, LocalDate startDate, LocalDate endDate, boolean paid, float amount, LocalDate bookingDate) {
        this.order_id = order_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
        this.amount = amount;
        this.bookingDate = bookingDate;
    }

    public BookedPeriodDto(long order_id,
                           LocalDate startDate,
                           LocalDate endDate,
                           boolean paid,
                           float amount,
                           LocalDate bookingDate,
                           Renter personWhoBooked) {
        this.order_id = order_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
        this.amount = amount;
        this.bookingDate = bookingDate;
        this.personWhoBooked = personWhoBooked;
    }

    public BookedPeriodDto() {
    }

    public Renter getPersonWhoBooked() {
        return personWhoBooked;
    }

    public void setPersonWhoBooked(Renter personWhoBooked) {
        this.personWhoBooked = personWhoBooked;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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
