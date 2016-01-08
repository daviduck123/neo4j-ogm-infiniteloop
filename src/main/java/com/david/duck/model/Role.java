package com.david.duck.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.*;


@NodeEntity
public class Role {
	@GraphId
	Long id;
	
	@NotNull
	String name;
	
	
	@Relationship(type = "HAS_ROLE", direction=Relationship.INCOMING)
	private Set<UserRole> userRoles;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Relationship(type = "HAS_ROLE", direction=Relationship.INCOMING)
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	@Relationship(type = "HAS_ROLE", direction=Relationship.INCOMING)
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Role(Integer no, String name, String viewName, String category) {
		super();
		this.name = name;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
}