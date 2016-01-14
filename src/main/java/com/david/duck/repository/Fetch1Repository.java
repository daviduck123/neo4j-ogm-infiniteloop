package com.david.duck.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.david.duck.model.Fetch1;
import com.david.duck.model.Fetch2;

import java.util.List;
import java.lang.Long;
import java.lang.String;

public interface Fetch1Repository extends GraphRepository<Fetch1>{

	Fetch1 findById(Long id);
}
