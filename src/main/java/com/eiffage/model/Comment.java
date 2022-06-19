package com.eiffage.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

	@Entity  
	public class Comment {
		@Id  @GeneratedValue(strategy = GenerationType.AUTO)
		private Long id; 
		private String message;
		private LocalDateTime timeStamp;
		
		@ManyToOne(targetEntity=User.class)
		private User reporter;
		
		@ManyToOne(targetEntity=Task.class)
		private Task task;

		public Comment(String message, User reporter, LocalDateTime timeStamp, Task task) {
			super();
			this.message = message;
			this.reporter = reporter;
			this.timeStamp = timeStamp;
			this.task = task;
		}
		public Comment() {
			super();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public User getReporter() {
			return reporter;
		}
		public void setReporter(User reporter) {
			this.reporter = reporter;
		}
		public LocalDateTime getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
		}
		public Task getTask() {
			return task;
		}
		public void setTask(Task task) {
			this.task = task;
		}
		
		
	}
