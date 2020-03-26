package ilcarro.ilcarro.entities;

public class JwtResponse {
	private final String jwttoken;
	private String status;

	public JwtResponse(String jwttoken, String status) {
		this.jwttoken = jwttoken;
		this.status = status;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}