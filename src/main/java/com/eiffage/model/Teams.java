package com.eiffage.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name = "teams")
@Entity
public class Teams {
	@Id
	private Long id;
	private String name;

	@ManyToMany( fetch = FetchType.EAGER)
	private List<Users> users;
	
	@ManyToOne(targetEntity=Projects.class)
	private Projects currentProject;

	public Teams() {
		super();
	}

	public Teams(Long id, String name, List<Users> users, Projects currentProject) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.currentProject = currentProject;
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

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Projects getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Projects currentProject) {
		this.currentProject = currentProject;
	}

	@Override
	public String toString() {
		return "Teams [id=" + id + ", name=" + name + ", users=" + users + ", currentProject=" + currentProject + "]";
	}

}
