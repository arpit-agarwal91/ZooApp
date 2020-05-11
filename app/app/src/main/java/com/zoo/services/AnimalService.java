package com.zoo.services;

import java.util.List;

import com.zoo.dao.Animal;

public interface AnimalService {
	
	public List<Animal> findAll();
	
	public Animal findById(Integer id);
	
	public Animal createAnimal(Animal animal);
	
	public Animal updateAnimal(Animal animal, Integer id);
	
	public boolean removeAnimal(Integer id);
	
}
