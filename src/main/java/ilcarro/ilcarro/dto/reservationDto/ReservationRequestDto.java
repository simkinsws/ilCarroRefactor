package ilcarro.ilcarro.dto.reservationDto;

import ilcarro.ilcarro.dto.Renter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;

public class ReservationRequestDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private Renter personWhoBooked;

    public ReservationRequestDto(LocalDate startDate, LocalDate endDate, Renter personWhoBooked) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.personWhoBooked = personWhoBooked;
    }

    public ReservationRequestDto() {
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

    public Renter getPersonWhoBooked() {
        return personWhoBooked;
    }

    public void setPersonWhoBooked(Renter personWhoBooked) {
        this.personWhoBooked = personWhoBooked;
    }
}
