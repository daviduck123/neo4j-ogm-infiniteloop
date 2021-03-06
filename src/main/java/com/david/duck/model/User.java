package com.david.duck.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@NodeEntity
public class User {
	@GraphId
	Long id;

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;
	
	@NotNull
	private String role;

	@NotNull
	private Boolean active;
	
	@Relationship(type = "HAS_ROLE")
	@JsonIgnore
	private Set<UserRole> userRoles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Relationship(type = "HAS_ROLE")
	@JsonIgnore
	public Set<UserRole> getRoles() {
		return userRoles;
	}

	@Relationship(type = "HAS_ROLE")
	@JsonIgnore
	public void setRoles(Set<UserRole> roles) {
		this.userRoles = roles;
	}

	public User(){
		super();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", role=" + role + ", active=" + active + ", userRoles=" + userRoles + "]";
	}
}