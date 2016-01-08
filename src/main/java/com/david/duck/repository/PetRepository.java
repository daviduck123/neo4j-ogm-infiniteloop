package com.david.duck.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.david.duck.model.Pet;

public interface PetRepository extends GraphRepository<Pet> {

}
