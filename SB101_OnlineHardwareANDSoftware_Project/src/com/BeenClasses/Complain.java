package com.BeenClasses;

public class Complain {
	
	private int ComplainId;
	private String Catagory;
	
	public Complain() {
		// TODO Auto-generated constructor stub
	}

	public Complain(int complainId, String catagory) {
		super();
		ComplainId = complainId;
		Catagory = catagory;
	}

	public int getComplainId() {
		return ComplainId;
	}

	public void setComplainId(int complainId) {
		ComplainId = complainId;
	}

	public String getCatagory() {
		return Catagory;
	}

	public void setCatagory(String catagory) {
		Catagory = catagory;
	}

	@Override
	public String toString() {
		return "Complain [ComplainId=" + ComplainId + ", Catagory=" + Catagory + "]";
	}
	
	

}
