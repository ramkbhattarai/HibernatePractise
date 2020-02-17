package com.rkb;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Column;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Embedded // this is another way to set the whole object as primary key using hibernate
	private LoginCredentials user;
	
	private LocalDateTime date;
	@Embedded // we can have two instances of address with different values, we can generate different field for home and office address
	// we can do it in both homeAddress and officeAddress but one will suffice
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="office_street")),
		@AttributeOverride(name="city", column=@Column(name="office_city")),
		@AttributeOverride(name="state", column=@Column(name="office_state")),
		@AttributeOverride(name="zipcode", column=@Column(name="office_zipcode"))
	})
	private Address officeAddress;
	@Lob 
	private String description; // for simple string hibernate has 255 characters but with Lob it says its a large object 
	// and if its on top of string it will create clob (character large object) and for images ie Byte[] it will have Blob(Byte large object)
	private boolean isActive;
	
	
	public UserDetails() {
		super();	
	}

	





	public UserDetails(int id ,LoginCredentials user, LocalDateTime date, Address homeAddress, Address officeAddress,
			String description, boolean isActive) {
		super();
		this.user = user;
		this.id = id;
		this.date = date;
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
		this.description = description;
		this.isActive = isActive;
	}







	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public LocalDateTime getDate() {
		return date;
	}



	public void setDate(LocalDateTime date) {
		this.date = date;
	}



	



	public Address getHomeAddress() {
		return homeAddress;
	}







	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}







	public Address getOfficeAddress() {
		return officeAddress;
	}







	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
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





	public LoginCredentials getUser() {
		return user;
	}







	public void setUser(LoginCredentials user) {
		this.user = user;
	}







	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", user=" + user + ", date=" + date + ", homeAddress=" + homeAddress
				+ ", officeAddress=" + officeAddress + ", description=" + description + ", isActive=" + isActive + "]";
	}



}
