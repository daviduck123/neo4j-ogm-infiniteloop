package com.david.duck.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@RelationshipEntity(type = "HAS_ROLE")
public class UserRole {
	@GraphId
	Long id;
	
	@StartNode
	User user;
	
	@EndNode
	Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRole(){
		super();
	}
	public UserRole(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}
}
