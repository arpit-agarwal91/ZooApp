package com.zoo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.dao.Animal;
import com.zoo.dao.Pen;
import com.zoo.repositories.AnimalRepository;
import com.zoo.repositories.PenRepository;

@RestController
public class PenController {
	
	@Autowired
	@Lazy
	PenRepository penRepository;
	
	@Autowired
	@Lazy
	AnimalRepository animalRepository;
	
	@RequestMapping("/pens")
	public @ResponseBody List<Pen> getAllPens(){
		return penRepository.findAll();
	}
	
	@RequestMapping(value="/pens"+"/"+"{id}", method=RequestMethod.GET)
	public Pen getPenById(@PathVariable("id") Integer id) {
		return penRepository.getOne(id);
	}

	@RequestMapping(value="/pens", method=RequestMethod.POST)
	public Pen create(@RequestBody Pen pen) {
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
	
	@RequestMapping(value="/pens"+"/"+"{id}", method=RequestMethod.PUT)
	public Pen update(@RequestBody Pen pen,@PathVariable("id") Integer id) {
		Pen obj = penRepository.getOne(id);
		obj = pen;
		penRepository.save(obj);
		return obj;	
	}
	
	@RequestMapping(value="/pens"+"/"+"{id}", method=RequestMethod.DELETE)
	public boolean remove(@PathVariable("id") Integer id) {
		penRepository.deleteById(id);
		return true;	
	}
}
