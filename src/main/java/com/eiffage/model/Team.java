package com.eiffage.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
public class Team {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	@ManyToMany( fetch = FetchType.EAGER)
	
	private List<User> user;
	
	@ManyToOne(targetEntity=Project.class)
	private Project currentProject;

	public Team() {
		super();
	}

	public Team(String name, Project currentProject) {
		super();
		this.name = name;
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

	public List<User> getUsers() {
		return user;
	}

	public void setUsers(List<User> user) {
		this.user = user;
	}

	public Project getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}

	@Override
	public String toString() {
		return "Teams [id=" + id + ", name=" + name + ", users=" + user + ", currentProject=" + currentProject + "]";
	}

}
