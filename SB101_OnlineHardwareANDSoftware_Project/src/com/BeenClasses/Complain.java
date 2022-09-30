package com.BeenClasses;

public class Complain {
	
	private int ComplainId;
	private String CName;
	private String Catagory;
	
	public Complain() {
		// TODO Auto-generated constructor stub
	}

	public Complain(int complainId, String cName, String catagory) {
		super();
		ComplainId = complainId;
		CName = cName;
		Catagory = catagory;
	}

	public int getComplainId() {
		return ComplainId;
	}

	public void setComplainId(int complainId) {
		ComplainId = complainId;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getCatagory() {
		return Catagory;
	}

	public void setCatagory(String catagory) {
		Catagory = catagory;
	}

	@Override
	public String toString() {
		return "Complain [ComplainId=" + ComplainId + ", CName=" + CName + ", Catagory=" + Catagory + "]";
	}

	

}
