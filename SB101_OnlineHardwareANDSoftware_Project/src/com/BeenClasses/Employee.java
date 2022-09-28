package com.BeenClasses;

public class Employee {
	
	private int EId;
	private String EName;
	private String EEmail;
	private String EPassword;
	private String EComplain;
	private int EComplainId;
	
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}



	public Employee(int eId, String eName, String eEmail, String ePassword, String eComplain, int eComplainId) {
		super();
		EId = eId;
		EName = eName;
		EEmail = eEmail;
		EPassword = ePassword;
		EComplain = eComplain;
		EComplainId = eComplainId;
	}



	public int getEId() {
		return EId;
	}



	public void setEId(int eId) {
		EId = eId;
	}



	public String getEName() {
		return EName;
	}



	public void setEName(String eName) {
		EName = eName;
	}



	public String getEEmail() {
		return EEmail;
	}



	public void setEEmail(String eEmail) {
		EEmail = eEmail;
	}



	public String getEPassword() {
		return EPassword;
	}



	public void setEPassword(String ePassword) {
		EPassword = ePassword;
	}



	public String getEComplain() {
		return EComplain;
	}



	public void setEComplain(String eComplain) {
		EComplain = eComplain;
	}



	public int getEComplainId() {
		return EComplainId;
	}



	public void setEComplainId(int eComplainId) {
		EComplainId = eComplainId;
	}



	@Override
	public String toString() {
		return "Employee [EId=" + EId + ", EName=" + EName + ", EEmail=" + EEmail + ", EPassword=" + EPassword
				+ ", EComplain=" + EComplain + ", EComplainId=" + EComplainId + "]";
	}
	
	
}
