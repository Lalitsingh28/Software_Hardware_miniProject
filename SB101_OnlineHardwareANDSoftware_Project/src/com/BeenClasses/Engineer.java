package com.BeenClasses;

public class Engineer {
	
	private int ENId;
	private String ENName;
	private String ENNPassword;
	private int ENComplainId;
	private String ENCategory;
	

	public Engineer() {
		// TODO Auto-generated constructor stub
	}


	public Engineer(int eNId, String eNName, String eNNPassword, int eNComplainId, String eNCategory) {
		super();
		ENId = eNId;
		ENName = eNName;
		ENNPassword = eNNPassword;
		ENComplainId = eNComplainId;
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


	public String getENNPassword() {
		return ENNPassword;
	}


	public void setENNPassword(String eNNPassword) {
		ENNPassword = eNNPassword;
	}


	public int getENComplainId() {
		return ENComplainId;
	}


	public void setENComplainId(int eNComplainId) {
		ENComplainId = eNComplainId;
	}


	public String getENCategory() {
		return ENCategory;
	}


	public void setENCategory(String eNCategory) {
		ENCategory = eNCategory;
	}


	@Override
	public String toString() {
		return "Engineer [ENId=" + ENId + ", ENName=" + ENName + ", ENNPassword=" + ENNPassword + ", ENComplainId="
				+ ENComplainId + ", ENCategory=" + ENCategory + "]";
	}
	
	
}
