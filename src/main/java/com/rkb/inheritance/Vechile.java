package com.rkb.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // this is default way to go 
@DiscriminatorColumn(
		name="Vechile_type",
		discriminatorType = DiscriminatorType.STRING
		)
public class Vechile {
	// when we try to save the data of the classes that are in the inheritance tree hibernate will create only one table by default called
	// vechile and it will add dtype column on its own seperate ie discriminate between the inheriting classes 
	// other classes like twowheeler and fourwheeler will have their fields added to vechile table as well.
	// this is default way by which hibernate creates table in the inheritance structure
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	public Vechile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vechile(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Vechile [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
