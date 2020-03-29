package ilcarro.ilcarro.dto.carDto;

public class OwnerDto {
	private String firstName;
	private String secondName;
	private String registrationDate;

	public OwnerDto(String firstName, String secondName, String registrationDate) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.registrationDate = registrationDate;
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

	public OwnerDto() {
	}

	@Override
	public String toString() {
		return "OwnerDto{" + "firstName='" + firstName + '\'' + ", secondName='" + secondName + '\''
				+ ", registrationDate=" + registrationDate + '}';
	}
}
