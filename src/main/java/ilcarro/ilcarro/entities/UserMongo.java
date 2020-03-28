package ilcarro.ilcarro.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ilcarro.ilcarro.dto.Comment;

@Document(collection = "users")
public class UserMongo {
	@Id
	private String email;
	private String firstName;
	private String secondName;
	private String photoUrl;
	private String phone;
	private String password;
	private LocalDate registrationDate;
	private List<Comment> comments;
	private List<CarMongo> ownCars;
	private List<BookedCarMongo> bookedCars;
	private List<BookedCarMongo> history;

	public UserMongo(String email, String firstName, String secondName, String photoUrl, String phone, String password,
			LocalDate registrationDate, List<Comment> comments, List<CarMongo> ownCars, List<BookedCarMongo> bookedCars,
			List<BookedCarMongo> history) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.secondName = secondName;
		this.photoUrl = photoUrl;
		this.phone = phone;
		this.password = password;
		this.registrationDate = registrationDate;
		this.comments = comments;
		this.ownCars = ownCars;
		this.bookedCars = bookedCars;
		this.history = history;
	}

	public UserMongo() {
	}

	public List<BookedCarMongo> getBookedCars() {
		if (this.bookedCars == null) {
			return new ArrayList<>();
		}
		return bookedCars;
	}

	public void setBookedCars(List<BookedCarMongo> bookedCars) {
		this.bookedCars = bookedCars;
	}

	public List<BookedCarMongo> getHistory() {
		if (this.history == null) {
			return new ArrayList<>();
		}
		return history;
	}

	public void setHistory(List<BookedCarMongo> history) {
		this.history = history;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
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
		if (this.comments == null) {
			return new ArrayList<>();
		}
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<CarMongo> getOwnCars() {
		if (this.ownCars == null) {
			return new ArrayList<>();
		}
		return ownCars;
	}

	public void setOwnCars(List<CarMongo> ownCars) {
		this.ownCars = ownCars;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
