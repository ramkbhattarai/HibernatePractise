package com.rkb.inheritance;

import javax.persistence.Entity;

@Entity
public class TwoWheelers extends Vechile{
	
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
