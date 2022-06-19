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
public class Task {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String taskNumber;
	private String description;
	private Status status;

	@ManyToOne(targetEntity=User.class)
	private User assignTo;
	
	@ManyToOne(targetEntity=User.class)
	private User reporter;

	@ManyToOne(targetEntity=Project.class)
	private Project project;

	@OneToMany
	private List<Comment> comment;

	@OneToMany
	private List<Attachment> attachment;

	public Task(String title, String taskNumber, String description, Status status, User assignTo,
			User reporter, Project project) {
		super();
		this.title = title;
		this.taskNumber = taskNumber;
		this.description = description;
		this.status = status;
		this.assignTo = assignTo;
		this.reporter = reporter;
		this.project = project;
	}

	public Task() {
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

	public User getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(User assignTo) {
		this.assignTo = assignTo;
	}

	public User getReporter() {
		return reporter;
	}

	public void setReporter(User reporter) {
		this.reporter = reporter;
	}

	public List<Comment> getComments() {
		return comment;
	}

	public void setComments(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Attachment> getAttachments() {
		return attachment;
	}

	public void setAttachments(List<Attachment> attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "Tasks [id=" + id + ", title=" + title + ", taskNumber=" + taskNumber + ", description=" + description
				+ ", status=" + status + ", assignTo=" + assignTo + ", reporter=" + reporter + ", comments=" + comment
				+ ", attachments=" + attachment + ", project="+project+"]";
	}
}
