package com.eiffage.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.eiffage.model.enumeration.Status;

@Entity
public class Tasks {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String taskNumber;
	private String description;
	private Status status;

	@ManyToOne(targetEntity=Users.class)
	private Users assignTo;
	
	@ManyToOne(targetEntity=Users.class)
	private Users reporter;

	@OneToMany
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Comments> comments;

	public Tasks(Long id, String title, String taskNumber, String description, Status status, Users assignTo,
			Users reporter, List<Comments> comments) {
		super();
		this.id = id;
		this.title = title;
		this.taskNumber = taskNumber;
		this.description = description;
		this.status = status;
		this.assignTo = assignTo;
		this.reporter = reporter;
		this.comments = comments;
	}

	public Tasks() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTaskNumber() {
		return taskNumber;
	}

	public void setTaskNumber(String taskNumber) {
		this.taskNumber = taskNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Users getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(Users assignTo) {
		this.assignTo = assignTo;
	}

	public Users getReporter() {
		return reporter;
	}

	public void setReporter(Users reporter) {
		this.reporter = reporter;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
}
