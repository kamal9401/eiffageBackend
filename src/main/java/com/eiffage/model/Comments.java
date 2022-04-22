package com.eiffage.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

	@Entity  
	public class Comments {
		@Id @GeneratedValue
		private Long id; 
		private String message;
		private LocalDateTime timeStamp;
		
		@ManyToOne
		private Users reporter;
		
		@ManyToOne
		private Tasks task;

		public Comments(Long id, String message, Users reporter, LocalDateTime timeStamp, Tasks task) {
			super();
			this.id = id;
			this.message = message;
			this.reporter = reporter;
			this.timeStamp = timeStamp;
			this.task = task;
		}
		public Comments() {
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
		public Users getReporter() {
			return reporter;
		}
		public void setReporter(Users reporter) {
			this.reporter = reporter;
		}
		public LocalDateTime getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
		}
		public Tasks getTask() {
			return task;
		}
		public void setTask(Tasks task) {
			this.task = task;
		}
		
		
	}
