package ilcarro.ilcarro.dto.userDto;

import java.util.List;

import ilcarro.ilcarro.dto.Comment;
import ilcarro.ilcarro.dto.bookingDto.BookedCarDto;
import ilcarro.ilcarro.dto.carDto.CarResponseDto;

public class UserResponseDto {
	private String firstName;
	private String secondName;
	private String email;
	private String registrationDate;
	private List<Comment> comments;
	private List<CarResponseDto> ownCars;
	private List<BookedCarDto> bookedCars;
	private List<BookedCarDto> history;

	public UserResponseDto(String firstName, String secondName, String email, String registrationDate,
			List<Comment> comments, List<CarResponseDto> ownCars, List<BookedCarDto> bookedCars,
			List<BookedCarDto> history) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
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

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserResponseDto{" + "firstName='" + firstName + '\'' + ", secondName='" + secondName + '\''
				+ ", registrationDate=" + registrationDate + ", comments=" + comments + ", ownCars=" + ownCars
				+ ", bookedCars=" + bookedCars + ", history=" + history + '}';
	}
}
