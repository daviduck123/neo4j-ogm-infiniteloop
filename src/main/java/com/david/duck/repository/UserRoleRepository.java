package com.david.duck.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.david.duck.model.UserRole;

public interface UserRoleRepository  extends GraphRepository<UserRole>{

}
