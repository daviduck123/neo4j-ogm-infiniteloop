package com.david.duck.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NodeEntity
public class Fetch3 {

	@GraphId Long id;
	
	private String name;
	
	@Relationship(type="HAS_FETCH3", direction=Relationship.INCOMING)
	@JsonIgnore
	private Fetch2 fetch2;

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

	@Relationship(type="HAS_FETCH3", direction=Relationship.INCOMING)
	@JsonIgnore
	public Fetch2 getFetch2() {
		return fetch2;
	}

	@Relationship(type="HAS_FETCH3", direction=Relationship.INCOMING)
	@JsonIgnore
	public void setFetch2(Fetch2 fetch2) {
		this.fetch2 = fetch2;
	}

}

