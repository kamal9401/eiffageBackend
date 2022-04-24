package com.eiffage.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	@ManyToOne(targetEntity=Projects.class)
	private Projects project;

	@OneToMany
	private List<Comments> comments;

	@OneToMany
	private List<Attachments> attachments;

	public Tasks(String title, String taskNumber, String description, Status status, Users assignTo,
			Users reporter) {
		super();
		this.title = title;
		this.taskNumber = taskNumber;
		this.description = description;
		this.status = status;
		this.assignTo = assignTo;
		this.reporter = reporter;
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

	public List<Attachments> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "Tasks [id=" + id + ", title=" + title + ", taskNumber=" + taskNumber + ", description=" + description
				+ ", status=" + status + ", assignTo=" + assignTo + ", reporter=" + reporter + ", comments=" + comments
				+ ", attachments=" + attachments + "]";
	}

	
}
