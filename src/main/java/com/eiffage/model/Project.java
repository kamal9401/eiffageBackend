package com.eiffage.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.eiffage.model.enumeration.Status;

@Entity
public class Project {
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
 	private Long id;
	private String description;
	private String title;
	private LocalDateTime timeStamp;
	private Status status;

	

	@ManyToOne(targetEntity=User.class)
	private User chefChantier;

	public Project(String description, String title, LocalDateTime timeStamp, Status status,
			User chefChantier) {
		super();
		this.description = description;
		this.title = title;
		this.timeStamp = timeStamp;
		this.status = status;
		this.chefChantier = chefChantier;
	}

	public Project() {
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

	

	public User getChefChantier() {
		return chefChantier;
	}

	public void setChefChantier(User chefChantier) {
		this.chefChantier = chefChantier;
	}

	@Override
	public String toString() {
		return "Projects [id=" + id + ", description=" + description + ", title=" + title + ", timeStamp=" + timeStamp
				+ ", status=" + status + ", chefChantier=" + chefChantier
				+ "]";
	}
	
	
	
}
