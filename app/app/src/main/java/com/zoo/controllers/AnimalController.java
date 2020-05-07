package com.zoo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.dao.Animal;
import com.zoo.dao.Pen;
import com.zoo.repositories.AnimalRepository;
import com.zoo.repositories.PenRepository;

@RestController
public class AnimalController {

	@Autowired
	@Lazy
	AnimalRepository animalRepository;
	
	@Autowired
	@Lazy
	PenRepository penRepository;
	
	@RequestMapping("/animals")
	public List<Animal> getAllPens(){
		
		return animalRepository.findAll();
	}
	
	@RequestMapping(value="/animals"+"/"+"{id}", method=RequestMethod.GET)
	public Animal getPenById(@PathVariable("id") Integer id) {
		return animalRepository.getOne(id);
	}

	@RequestMapping(value="/animals", method=RequestMethod.POST)
	public Animal create(@RequestBody Animal animal) {
		animalRepository.saveAndFlush(animal);
		List<Pen> pens = penRepository.findAll();
		for(Pen pen : pens) {
			if(pen.getContainsAnimal()==animal.getId()) {
				animal.setPen(pen);
			}
		}
		return animal;	
	}
	
	@RequestMapping(value="/animals"+"/"+"{id}", method=RequestMethod.PUT)
	public Animal update(@RequestBody Animal animal,@PathVariable("id") Integer id) {
		Animal obj = animalRepository.getOne(id);
		obj = animal;
		animalRepository.save(obj);
		return obj;	
	}
	
	@RequestMapping(value="/animals"+"/"+"{id}", method=RequestMethod.DELETE)
	public boolean remove(@PathVariable("id") Integer id) {
		animalRepository.deleteById(id);
		return true;	
	}
	
}
