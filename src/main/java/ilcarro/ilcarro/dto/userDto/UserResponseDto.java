package ilcarro.ilcarro.dto.userDto;

import ilcarro.ilcarro.dto.bookingDto.BookedCarDto;
import ilcarro.ilcarro.dto.carDto.CarResponseDto;
import ilcarro.ilcarro.dto.Comment;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UserResponseDto {
    private String firstName;
    private String secondName;
    private LocalDate registrationDate;
    private List<Comment> comments;
    private List<CarResponseDto> ownCars;
    private List<BookedCarDto> bookedCars;
    private List<BookedCarDto> history;

    public UserResponseDto(String firstName,
                           String secondName,
                           LocalDate registrationDate,
                           List<Comment> comments,
                           List<CarResponseDto> ownCars,
                           List<BookedCarDto> bookedCars,
                           List<BookedCarDto> history) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.registrationDate = registrationDate;
        this.comments = comments;
        this.ownCars = ownCars;
        this.bookedCars = bookedCars;
        this.history = history;
    }

    public UserResponseDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<CarResponseDto> getOwnCars() {
        return ownCars;
    }

    public void setOwnCars(List<CarResponseDto> ownCars) {
        this.ownCars = ownCars;
    }

    public List<BookedCarDto> getBookedCars() {
        return bookedCars;
    }

    public void setBookedCars(List<BookedCarDto> bookedCars) {
        this.bookedCars = bookedCars;
    }

    public List<BookedCarDto> getHistory() {
        return history;
    }

    public void setHistory(List<BookedCarDto> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "UserResponseDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", registrationDate=" + registrationDate +
                ", comments=" + comments +
                ", ownCars=" + ownCars +
                ", bookedCars=" + bookedCars +
                ", history=" + history +
                '}';
    }
}
