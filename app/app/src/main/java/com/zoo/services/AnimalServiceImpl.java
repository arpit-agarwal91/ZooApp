package com.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.zoo.dao.Animal;
import com.zoo.dao.Pen;
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
		animalRepository.saveAndFlush(animal);
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
