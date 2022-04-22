package com.eiffage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Teams {
	@Id
	private Long id;
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name="TEAMS_USERS")
	private List<Users> users;
	
	public Teams(Long id, String name, List<Users> user) {
		super();
		this.id = id;
		this.name = name;
		if(this.users == null) {
			this.users = new ArrayList<Users>();
		}
		this.users.addAll(user);
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

	public List<Users> getUser() {
		return users;
	}

	public void setUser(List<Users> user) {
		this.users = user;
	}

	public Teams() {
		super();
	}

	@Override
	public String toString() {
		return "Teams [id=" + id + ", name=" + name 
				+ ", user=" + users + "]";
	}
	
	
}
