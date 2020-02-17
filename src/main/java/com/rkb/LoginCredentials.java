package com.rkb;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LoginCredentials implements Serializable{
	
	private static final long serialVersionUID = -8586016858799636358L;
	private String fname;
	private String lname;
	private String username;
	private String email;
	private String password;
	public LoginCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginCredentials(String fname, String lname, String username, String email, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginCredentials [fname=" + fname + ", lname=" + lname + ", username=" + username + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	

}
