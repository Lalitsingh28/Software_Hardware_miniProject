package com.BeenClasses;

public class Engineer {
	
	private int ENId;
	private String ENName;
	private String ENEmail;
	private String ENNPassword;
	private String ENCategory;
	

	public Engineer() {
		// TODO Auto-generated constructor stub
	}


	public Engineer(int eNId, String eNName, String eNEmail, String eNNPassword, String eNCategory) {
		super();
		ENId = eNId;
		ENName = eNName;
		ENEmail = eNEmail;
		ENNPassword = eNNPassword;
		ENCategory = eNCategory;
	}


	public int getENId() {
		return ENId;
	}


	public void setENId(int eNId) {
		ENId = eNId;
	}


	public String getENName() {
		return ENName;
	}


	public void setENName(String eNName) {
		ENName = eNName;
	}


	public String getENEmail() {
		return ENEmail;
	}


	public void setENEmail(String eNEmail) {
		ENEmail = eNEmail;
	}


	public String getENNPassword() {
		return ENNPassword;
	}


	public void setENNPassword(String eNNPassword) {
		ENNPassword = eNNPassword;
	}


	


	public String getENCategory() {
		return ENCategory;
	}


	public void setENCategory(String eNCategory) {
		ENCategory = eNCategory;
	}


	@Override
	public String toString() {
		return "Engineer [ENId=" + ENId + ", ENName=" + ENName + ", ENEmail=" + ENEmail + ", ENNPassword=" + ENNPassword
				+ ", ENCategory=" + ENCategory + "]";
	}


	


	
	
}
