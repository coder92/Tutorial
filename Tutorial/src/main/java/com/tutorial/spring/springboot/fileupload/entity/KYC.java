package com.tutorial.spring.springboot.fileupload.entity;

public class KYC {
	private long userId;
	private String aadharNo;
	private String voterCardNo;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getVoterCardNo() {
		return voterCardNo;
	}
	public void setVoterCardNo(String voterCardNo) {
		this.voterCardNo = voterCardNo;
	}
	@Override
	public String toString() {
		return "KYC [userId=" + userId + ", aadharNo=" + aadharNo + ", voterCardNo=" + voterCardNo + "]";
	}

}
