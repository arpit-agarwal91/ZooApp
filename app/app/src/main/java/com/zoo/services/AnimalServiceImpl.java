package com.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.zoo.dao.Animal;
import com.zoo.dao.Bird;
import com.zoo.dao.Mammal;
import com.zoo.dao.Pen;
import com.zoo.dao.Reptile;
import com.zoo.entities.AnimalType;
import com.zoo.repositories.AnimalRepository;
import com.zoo.repositories.PenRepository;

@Service
public class AnimalServiceImpl implements AnimalService {
	

	@Autowired
	@Lazy
	AnimalRepository animalRepository;
	
	@Autowired
	@Lazy
	PenRepository penRepository;

	@Override
	public List<Animal> findAll() {
		return animalRepository.findAll();
	}

	@Override
	public Animal findById(Integer id) {
		return animalRepository.getOne(id);
	}

	@Override
	public Animal createAnimal(Animal animal) {
		if(animal.getAnimalType().equals(AnimalType.BIRD)) {
			Animal bird = new Bird();
			bird.setColor(animal.getColor());
			bird.setDietCategory(animal.getDietCategory());
			bird.setScientificName(animal.getScientificName());
			animalRepository.saveAndFlush(bird);
			animal = bird;
		}
		if(animal.getAnimalType().equals(AnimalType.MAMMAL)) {
			Animal mammal = new Mammal();
			mammal.setColor(animal.getColor());
			mammal.setDietCategory(animal.getDietCategory());
			mammal.setScientificName(animal.getScientificName());
			animalRepository.saveAndFlush(mammal);
			animal = mammal;
		}
		if(animal.getAnimalType().equals(AnimalType.REPTILE)) {
			Animal reptile = new Reptile();
			reptile.setColor(animal.getColor());
			reptile.setDietCategory(animal.getDietCategory());
			reptile.setScientificName(animal.getScientificName());
			animalRepository.saveAndFlush(reptile);
			animal = reptile;
		}
		List<Pen> pens = penRepository.findAll();
		for(Pen pen : pens) {
			if(pen.getContainsAnimal()==animal.getId()) {
				animal.setPen(pen);
			}
		}
		return animal;
	}

	@Override
	public Animal updateAnimal(Animal animal, Integer id) {
		Animal obj = animalRepository.getOne(id);
		obj = animal;
		animalRepository.save(obj);
		return obj;
	}

	@Override
	public boolean removeAnimal(Integer id) {
		animalRepository.deleteById(id);
		return true;
	}

}
