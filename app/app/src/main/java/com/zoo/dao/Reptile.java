package com.zoo.dao;

import java.util.ArrayList;

import com.zoo.entities.AnimalType;
import com.zoo.entities.LocomotionModes;

import antlr.collections.List;

public class Reptile extends Animal {
	
	@Override
	public void setAnimalType() {
		this.animalType = AnimalType.REPTILE;
	}

	@Override
	public void setLayEggs() {
		this.layEggs = true;		
	}
	
	@Override
	public void setLocomotionModes() {

		List list = (List) new ArrayList();
		list.add(LocomotionModes.CRAWL);
		list.add(LocomotionModes.SWIM);
		this.locomotionModes = (java.util.List<LocomotionModes>) list;

	}

}
