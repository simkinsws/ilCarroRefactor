package ilcarro.ilcarro.entities;

import java.time.LocalDate;
import java.util.Date;

public class RenterBookedPeriod {
    private long orderId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean paid;
    private float amount;
    private LocalDate bookingDate;

    public RenterBookedPeriod() {
    }

    public RenterBookedPeriod(long orderId, LocalDate startDate, LocalDate endDate, boolean paid, float amount, LocalDate bookingDate) {
        this.orderId = orderId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
        this.amount = amount;
        this.bookingDate = bookingDate;
    }

    public long getOrderId() {
        return orderId;
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
