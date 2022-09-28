package com.BeenClasses;

public class HOD {
	
	private String HODName;
	private String Address;
	private int HODMobile;
	private String HODEmail;
	private String HODPassword;
	
	public HOD() {
		// TODO Auto-generated constructor stub
	}

	public HOD(String hODName, String address, int hODMobile, String hODEmail, String hODPassword) {
		super();
		HODName = hODName;
		Address = address;
		HODMobile = hODMobile;
		HODEmail = hODEmail;
		HODPassword = hODPassword;
	}

	public String getHODName() {
		return HODName;
	}

	public void setHODName(String hODName) {
		HODName = hODName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getHODMobile() {
		return HODMobile;
	}

	public void setHODMobile(int hODMobile) {
		HODMobile = hODMobile;
	}

	public String getHODEmail() {
		return HODEmail;
	}

	public void setHODEmail(String hODEmail) {
		HODEmail = hODEmail;
	}

	public String getHODPassword() {
		return HODPassword;
	}

	public void setHODPassword(String hODPassword) {
		HODPassword = hODPassword;
	}

	@Override
	public String toString() {
		return "HOD [HODName=" + HODName + ", Address=" + Address + ", HODMobile=" + HODMobile + ", HODEmail="
				+ HODEmail + ", HODPassword=" + HODPassword + "]";
	}
	
	
	

}
