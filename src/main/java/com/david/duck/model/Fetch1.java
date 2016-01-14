package com.david.duck.model;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NodeEntity
public class Fetch1 {

	@GraphId Long id;
	
	private String name;
	
	@Relationship(type="HAS_FETCH2")
	@JsonIgnore
	private List<Fetch2> fetch2;

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

	@Relationship(type="HAS_FETCH2")
	@JsonIgnore
	public List<Fetch2> getFetch2() {
		return fetch2;
	}

	@Relationship(type="HAS_FETCH2")
	@JsonIgnore
	public void setFetch2(List<Fetch2> fetch2) {
		this.fetch2 = fetch2;
	}

	@Override
	public String toString() {
		return "Fetch1 [id=" + id + ", name=" + name + ", fetch2=" + fetch2 + "]";
	}
	
	

}
