package com.eiffage.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table(name="roles")
@Entity
public class Roles {
	
	@Id
	private String role;
	private String description;

	@OneToMany
    private List<Users> users;

	public Roles(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}

	public Roles() {
		super();

	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Roles [role=" + role + ", description=" + description + "]";
	}

}
