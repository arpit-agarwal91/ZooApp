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
public class PenServiceImpl implements PenService {
	
	@Autowired
	@Lazy
	PenRepository penRepository;
	
	@Autowired
	@Lazy
	AnimalRepository animalRepository;

	@Override
	public List<Pen> findAll() {
		return penRepository.findAll();
	}

	@Override
	public Pen findById(Integer id) {
		return penRepository.getOne(id);
	}

	@Override
	public Pen createPen(Pen pen) {
		penRepository.save(pen);
		List<Animal> animals = animalRepository.findAll();
		for(Animal animal: animals) {
			if(pen.getContainsAnimal()==animal.getId()) {
				animal.setPen(pen);
				animalRepository.saveAndFlush(animal);
			}
		}
		
		return pen;
	}

	@Override
	public Pen updatePen(Pen newValue, Integer id) {
		Pen obj = penRepository.getOne(id);
		obj = newValue;
		penRepository.save(obj);
		return obj;
	}

	@Override
	public boolean deletePen(Integer id) {
		penRepository.deleteById(id);
		return true;
	}

}
