package com.eiffage.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {

	@Id
	private String role;
	private String description;

	public Roles(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}

	public Roles() {
		super();

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
