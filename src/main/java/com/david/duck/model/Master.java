package com.david.duck.model;

import java.util.Set;

import org.neo4j.ogm.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NodeEntity
public class Master {

	@GraphId
	private Long id;
	
	private String name;
	
	@Relationship(type="OWNS", direction=Relationship.OUTGOING)
	private Set<Pet> pets;

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

	@Relationship(type="OWNS", direction=Relationship.OUTGOING)
	public Set<Pet> getPets() {
		return pets;
	}

	@Relationship(type="OWNS", direction=Relationship.OUTGOING)
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	public Master(){
		super();
	}
}
