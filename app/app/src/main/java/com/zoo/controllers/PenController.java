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
import com.zoo.services.PenService;

@RestController
public class PenController {
	
	@Autowired
	PenService penService;
	
	@RequestMapping("/pens")
	public @ResponseBody List<Pen> getAllPens(){
		return penService.findAll();
	}
	
	@RequestMapping(value="/pens"+"/"+"{id}", method=RequestMethod.GET)
	public Pen getPenById(@PathVariable("id") Integer id) {
		return penService.findById(id);
	}

	@RequestMapping(value="/pens", method=RequestMethod.POST)
	public Pen create(@RequestBody Pen pen) {
		return penService.createPen(pen);	
	}
	
	@RequestMapping(value="/pens"+"/"+"{id}", method=RequestMethod.PUT)
	public Pen update(@RequestBody Pen pen,@PathVariable("id") Integer id) {
		return penService.updatePen(pen,id);	
	}
	
	@RequestMapping(value="/pens"+"/"+"{id}", method=RequestMethod.DELETE)
	public boolean remove(@PathVariable("id") Integer id) {
		return penService.deletePen(id);	
	}
}
