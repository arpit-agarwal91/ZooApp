package com.zoo.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pen implements Zoo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private boolean isEmpty;
	
	//@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = true)
	private int containsAnimal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public int getContainsAnimal() {
		return containsAnimal;
	}
	public void setContainsAnimal(int containsAnimal) {
		this.containsAnimal = containsAnimal;
	}

}
