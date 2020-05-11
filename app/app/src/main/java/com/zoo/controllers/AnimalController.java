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
import com.zoo.services.AnimalService;

@RestController
public class AnimalController {
	
	@Autowired
	AnimalService animalService;
	
	@RequestMapping("/animals")
	public List<Animal> getAllPens(){
		return animalService.findAll();
	}
	
	@RequestMapping(value="/animals"+"/"+"{id}", method=RequestMethod.GET)
	public Animal getAnimalById(@PathVariable("id") Integer id) {
		return animalService.findById(id);
	}

	@RequestMapping(value="/animals", method=RequestMethod.POST)
	public Animal create(@RequestBody Animal animal) {
		return animalService.createAnimal(animal);	
	}
	
	@RequestMapping(value="/animals"+"/"+"{id}", method=RequestMethod.PUT)
	public Animal update(@RequestBody Animal animal,@PathVariable("id") Integer id) {
		return animalService.updateAnimal(animal, id);	
	}
	
	@RequestMapping(value="/animals"+"/"+"{id}", method=RequestMethod.DELETE)
	public boolean remove(@PathVariable("id") Integer id) {
		return animalService.removeAnimal(id);	
	}
	
}
