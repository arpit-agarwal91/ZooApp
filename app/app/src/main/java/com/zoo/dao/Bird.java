package com.zoo.dao;

import java.util.ArrayList;

import com.zoo.entities.AnimalType;
import com.zoo.entities.LocomotionModes;

import antlr.collections.List;

public class Bird extends Animal {

	@Override
	public void setAnimalType() {
		this.animalType = AnimalType.BIRD;
	}

	@Override
	public void setLayEggs() {
		this.layEggs = true;
	}

	@Override
	public void setLocomotionModes() {

		List list = (List) new ArrayList();
		list.add(LocomotionModes.FLY);
		list.add(LocomotionModes.HOP);
		this.locomotionModes = (java.util.List<LocomotionModes>) list;

	}

}
