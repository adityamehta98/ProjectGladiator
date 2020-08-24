package com.lti.Dto;

public class userDto {
	public userDto(String uName, String uEmail, String uPassword, String uAddress, int uPhone) {
		super();
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uPhone = uPhone;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public int getuPhone() {
		return uPhone;
	}
	public void setuPhone(int uPhone) {
		this.uPhone = uPhone;
	}
	private String uName;
	private String uEmail;
	private String uPassword;
	private String uAddress;
	private int uPhone;
	
}
