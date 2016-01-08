package com.david.duck.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.david.duck.model.Master;

public interface MasterRepository extends GraphRepository<Master> {

}
