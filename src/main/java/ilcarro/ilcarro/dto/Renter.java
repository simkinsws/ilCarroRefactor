package ilcarro.ilcarro.dto;

public class Renter {
    private String email;
    private String firstName;
    private String secondName;
    private String phone;

    public Renter(String email,
                  String firstName,
                  String secondName,
                  String phone) {
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
    }

    public Renter() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
