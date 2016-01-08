package com.david.duck.model;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NodeEntity
public class Pet {
	@GraphId
	Long id;

	@NotNull
	private String name;
	
	@Relationship(type="OWNS",direction=Relationship.INCOMING)
	@JsonIgnore
	private Master master;
	
	@Relationship(type="OWNS",direction=Relationship.INCOMING)
	@JsonIgnore
	public Master getMaster() {
		return master;
	}
	
	@Relationship(type="OWNS",direction=Relationship.INCOMING)
	@JsonIgnore
	public void setMaster(Master master) {
		this.master = master;
	}

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
	
	public Pet(){
		super();
	}
}
