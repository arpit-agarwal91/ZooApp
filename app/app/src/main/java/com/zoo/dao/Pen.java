package com.zoo.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pen extends Area {
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private boolean isEmpty;
	
	@ManyToOne
	@JoinColumn(name="areaId", nullable=false, updatable = false)
	private Area area;
	
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
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
	public void setEmpty() {
		if(this.getContainsAnimal()>-1) {
			this.isEmpty = false;
		}
		else {
			this.isEmpty = true;
		}
	}
	public int getContainsAnimal() {
		return containsAnimal;
	}
	public void setContainsAnimal(int containsAnimal) {
		this.containsAnimal = containsAnimal;
	}

}
