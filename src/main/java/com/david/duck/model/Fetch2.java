package com.david.duck.model;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NodeEntity
public class Fetch2 {

	@GraphId Long id;
	
	private String name;
	
	@Relationship(type="HAS_FETCH2", direction=Relationship.INCOMING)
	@JsonIgnore
	private Fetch1 fetch1;
	
	@Relationship(type="HAS_FETCH3")
	@JsonIgnore
	private List<Fetch3> fetch3;

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

	@Relationship(type="HAS_FETCH2", direction=Relationship.INCOMING)
	@JsonIgnore
	public Fetch1 getFetch1() {
		return fetch1;
	}

	@Relationship(type="HAS_FETCH2", direction=Relationship.INCOMING)
	@JsonIgnore
	public void setFetch1(Fetch1 fetch1) {
		this.fetch1 = fetch1;
	}

	@Relationship(type="HAS_FETCH3")
	@JsonIgnore
	public List<Fetch3> getFetch3() {
		return fetch3;
	}

	@Relationship(type="HAS_FETCH3")
	@JsonIgnore
	public void setFetch3(List<Fetch3> fetch3) {
		this.fetch3 = fetch3;
	}

	@Override
	public String toString() {
		return "Fetch2 [id=" + id + ", name=" + name + ", fetch1=" + fetch1 + ", fetch3=" + fetch3 + "]";
	}
	
	

}
