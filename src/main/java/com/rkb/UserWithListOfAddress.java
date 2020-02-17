package com.rkb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class UserWithListOfAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	@ElementCollection // if we need to save a list of addresses for a user and don't know how many they will be there we use this
	@JoinTable(name="user_address", // this is a way to give name for the join table made by hibernate
		joinColumns=@JoinColumn(name="user_id") // this is way to give name for join column in that table
			)
	private Set<Address> addresses = new HashSet<>();
	
//	// if you want to have id in the join table you have to do this
//	@ElementCollection // if we need to save a list of addresses for a user and don't know how many they will be there we use this
//	@JoinTable(name="user_address", // this is a way to give name for the join table made by hibernate
//		joinColumns=@JoinColumn(name="user_id") // this is way to give name for join column in that table
//			)
//	@GenericGenerator(name="hilo-gen", strategy="hilo")// this is generator of the id that we want to have in the join table
	// hilo is the generator that hibernate provides
//	@CollectionId(columns = {@Column(name="address_id")}, generator="hilo-gen", type=@Type(type="long")) // we can have
//	// id only in arraylist so we use the interface collection to get that we can't use the implementing class.
//	private Collection<Address> address = new ArrayList<>();

	public UserWithListOfAddress(int id, String username, Set<Address> addresses) {
		super();
		this.id = id;
		this.username = username;
		this.addresses = addresses;
	}

	public UserWithListOfAddress() {
		super();
		// TODO Auto-generated constructor stub
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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "UserWithListOfAddress [id=" + id + ", username=" + username + ", addresses=" + addresses + "]";
	}
	
	

}
