package com.zoo.services;

import java.util.List;

import com.zoo.dao.Pen;

public interface PenService {
	
	public List<Pen> findAll();
	
	public Pen findById(Integer id);
	
	public Pen createPen(Pen pen);
	
	public Pen updatePen(Pen newValue, Integer id);
	
	public boolean deletePen(Integer id);

}
