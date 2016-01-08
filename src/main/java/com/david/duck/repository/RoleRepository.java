package com.david.duck.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.david.duck.model.Role;

public interface RoleRepository extends GraphRepository<Role>{

}
