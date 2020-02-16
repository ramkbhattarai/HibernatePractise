package com.rkb;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private LocalDateTime date;
	@Embedded
	private Address address;
	@Lob 
	private String description; // for simple string hibernate has 255 characters but with Lob it says its a large object 
	// and if its on top of string it will create clob (character large object) and for images ie Byte[] it will have Blob(Byte large object)
	private boolean isActive;
	
	
	public UserDetails() {
		super();	
	}

	

	public UserDetails(int id, String username, LocalDateTime date, Address address, String description,
			boolean isActive) {
		super();
		this.id = id;
		this.username = username;
		this.date = date;
		this.address = address;
		this.description = description;
		this.isActive = isActive;
	}



	public LocalDateTime getDate() {
		return date;
	}



	public void setDate(LocalDateTime date) {
		this.date = date;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", username=" + username + ", date=" + date + ", address=" + address
				+ ", description=" + description + ", isActive=" + isActive + "]";
	}

	
	
}
