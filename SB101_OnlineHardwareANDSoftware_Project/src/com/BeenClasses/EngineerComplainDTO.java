package com.BeenClasses;

public class EngineerComplainDTO {
	
	private int ENId;
	private String ENName;
	private String ENCategory;
	
	private int EComplainId;
	private String EComplain;
	
	private String ComplainStatus;
	
	public EngineerComplainDTO() {
		// TODO Auto-generated constructor stub
	}

	public EngineerComplainDTO(int eNId, String eNName, String eNCategory, int eComplainId, String eComplain,
			String complainStatus) {
		super();
		ENId = eNId;
		ENName = eNName;
		ENCategory = eNCategory;
		EComplainId = eComplainId;
		EComplain = eComplain;
		ComplainStatus = complainStatus;
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

	public String getENCategory() {
		return ENCategory;
	}

	public void setENCategory(String eNCategory) {
		ENCategory = eNCategory;
	}

	public int getEComplainId() {
		return EComplainId;
	}

	public void setEComplainId(int eComplainId) {
		EComplainId = eComplainId;
	}

	public String getEComplain() {
		return EComplain;
	}

	public void setEComplain(String eComplain) {
		EComplain = eComplain;
	}

	public String getComplainStatus() {
		return ComplainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		ComplainStatus = complainStatus;
	}

	@Override
	public String toString() {
		return "EngineerComplainDTO [ENId=" + ENId + ", ENName=" + ENName + ", ENCategory=" + ENCategory
				+ ", EComplainId=" + EComplainId + ", EComplain=" + EComplain + ", ComplainStatus=" + ComplainStatus
				+ "]";
	}

	
	
	
}
