package com.david.duck.model;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.neo4j.ogm.annotation.typeconversion.DateString;

@NodeEntity
public class Calendar {

	@GraphId Long id;
	
	 public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@DateString("yy-MM-dd")
	 private Date dateString;

	@DateLong
	private Date dateLong;

	public Date getDateString() {
		return dateString;
	}

	public void setDateString(Date dateString) {
		this.dateString = dateString;
	}

	public Date getDateLong() {
		return dateLong;
	}

	public void setDateLong(Date dateLong) {
		this.dateLong = dateLong;
	}

}
