package com.eiffage.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.eiffage.model.enumeration.Status;

@Entity
public class Projects {
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
 	private Long id;
	private String description;
	private String title;
	private LocalDateTime timeStamp;
	private Status status;

	@OneToMany
	private List<Teams> teams;

	@OneToMany
	private List<Tasks> tasks;

	@ManyToOne(targetEntity=Users.class)
	private Users chefChantier;

	public Projects(String description, String title, LocalDateTime timeStamp, Status status,
			Users chefChantier) {
		super();
		this.description = description;
		this.title = title;
		this.timeStamp = timeStamp;
		this.status = status;
		this.chefChantier = chefChantier;
	}

	public Projects() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Teams> getTeams() {
		return teams;
	}

	public void setTeams(List<Teams> teams) {
		this.teams = teams;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	public Users getChefChantier() {
		return chefChantier;
	}

	public void setChefChantier(Users chefChantier) {
		this.chefChantier = chefChantier;
	}

	@Override
	public String toString() {
		return "Projects [id=" + id + ", description=" + description + ", title=" + title + ", timeStamp=" + timeStamp
				+ ", status=" + status + ", teams=" + teams + ", tasks=" + tasks + ", chefChantier=" + chefChantier
				+ "]";
	}
	
	
	
}
