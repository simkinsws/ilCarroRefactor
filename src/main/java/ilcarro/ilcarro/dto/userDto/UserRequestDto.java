package ilcarro.ilcarro.dto.userDto;

public class UserRequestDto {
    private String firstName;
    private String secondName;
    private String phone;
    private String photoUrl;

    public UserRequestDto(
                          String firstName,
                          String secondName,
                          String phone,
                          String photoUrl) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.photoUrl = photoUrl;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "UserRequestDto{" +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
