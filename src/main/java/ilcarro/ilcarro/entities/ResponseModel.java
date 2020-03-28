package ilcarro.ilcarro.entities;

import java.util.List;

public class ResponseModel {
	private String status;
	private List<Object> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public ResponseModel(String status, List<Object> data) {
		super();
		this.status = status;
		this.data = data;
	}

	public ResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
