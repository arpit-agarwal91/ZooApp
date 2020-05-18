package com.zoo.dao;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Area implements Zoo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int areaId;
	
	@OneToMany(mappedBy="id")
	private Set<Pen> pens;
	
	public int getAreaId() {
		return areaId;
	}
	
	public void setAreaId(int id) {
		this.areaId = id;
	}
	
	

}
