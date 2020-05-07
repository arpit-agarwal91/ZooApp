package com.zoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.dao.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
