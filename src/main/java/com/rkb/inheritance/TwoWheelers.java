package com.rkb.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
//@DiscriminatorValue(value = "Bike") // this is the way to rename the column created in the vechile table
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
