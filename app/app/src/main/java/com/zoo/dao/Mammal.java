package com.zoo.dao;

import java.util.ArrayList;

import com.zoo.entities.AnimalType;
import com.zoo.entities.LocomotionModes;

import antlr.collections.List;

public class Mammal extends Animal {

	@Override
	public void setAnimalType() {
		this.animalType = AnimalType.MAMMAL;
	}

	@Override
	public void setLayEggs() {
		this.layEggs = false;
	}

	@Override
	public void setLocomotionModes() {

		List list = (List) new ArrayList();
		list.add(LocomotionModes.RUN);
		this.locomotionModes = (java.util.List<LocomotionModes>) list;

	}
}
