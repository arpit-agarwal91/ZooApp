package com.zoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.dao.Pen;

public interface PenRepository extends JpaRepository<Pen, Integer> {

}
