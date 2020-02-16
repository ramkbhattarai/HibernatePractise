package com.rkb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class UserDetails {
	
	@Id
	private int id;
	private String username;
	
	public UserDetails() {
		super();	
	}

	public UserDetails(int id, String username) {
		super();
		this.id = id;
		this.username = username;
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
		return "UserDetails [id=" + id + ", username=" + username + "]";
	}
	
	
}
