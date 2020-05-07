package com.zoo.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zoo.entities.AnimalType;
import com.zoo.entities.DietCategory;
import com.zoo.entities.LocomotionModes;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String scientificName;
	
	@ElementCollection
	private List<LocomotionModes> locomotionModes;
	
	private boolean layEggs;
	private DietCategory dietCategory;
	private AnimalType animalType;
	private String color;
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Pen pen;
	
	
	public Pen getPen() {
		return pen;
	}
	
	public void setPen(Pen pen) {
		this.pen = pen;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScientificName() {
		return scientificName;
	}
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public List<LocomotionModes> getLocomotionModes() {
		return locomotionModes;
	}
	public void setLocomotionModes(List<LocomotionModes> locomotionModes) {
		this.locomotionModes = locomotionModes;
	}
	public boolean isLayEggs() {
		return layEggs;
	}
	public void setLayEggs(boolean layEggs) {
		this.layEggs = layEggs;
	}
	public DietCategory getDietCategory() {
		return dietCategory;
	}
	public void setDietCategory(DietCategory dietCategory) {
		this.dietCategory = dietCategory;
	}
	public AnimalType getAnimalType() {
		return animalType;
	}
	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

//	public Animal(Builder builder) {
//		this.scientificName = builder.scientificName;
//		this.locomotionModes = builder.locomotionModes;
//		this.layEggs = builder.layEggs;
//		this.dietCategory = builder.dietCategory;
//		this.animalType = builder.animalType;
//	}
//	
//public static class Builder{
//		
//		private String scientificName;
//		private List<LocomotionModes> locomotionModes;
//		private boolean layEggs;
//		private DietCategory dietCategory;
//		private AnimalType animalType;
//		
//		public static Builder newInstance() {
//			return new Builder();
//		}
//		
//		public Builder setScientificName(String name) {
//			this.scientificName = name;
//			return this;
//		}
//		
//		public Builder setLocomotionModes(List<LocomotionModes> locomotionModes) {
//			this.locomotionModes = locomotionModes;
//			return this;
//		}
//		
//		public Builder setLayEggs(boolean layEggs) {
//			this.layEggs = layEggs;
//			return this;
//		}
//		
//		public Builder setDietCategory(DietCategory dietCategory) {
//			this.dietCategory = dietCategory;
//			return this;
//		}
//		
//		public Builder setAnimalType(AnimalType animalType) {
//			this.animalType = animalType;
//			return this;
//		}
//		
//		public Animal build() {
//			return new Animal(this);
//		}
//	}
	
}
