package com.eiffage.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
	
	@Entity
	public class Attachments {

		@Id  @GeneratedValue(strategy = GenerationType.AUTO)
		private Long id; 
		
		@ManyToOne(targetEntity=Tasks.class)
		private Tasks task;

		@ManyToOne(targetEntity=Users.class)
		private Users uploadedBy;

		private String title;
		private String path;
		private String icon;
		public Attachments(Tasks task, Users uploadedBy, String title, String path, String icon) {
			super();
			this.task = task;
			this.uploadedBy = uploadedBy;
			this.title = title;
			this.path = path;
			this.icon = icon;
		}
		public Attachments() {
			super();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Tasks getTask() {
			return task;
		}
		public void setTask(Tasks task) {
			this.task = task;
		}
		public Users getUploadedBy() {
			return uploadedBy;
		}
		public void setUploadedBy(Users uploadedBy) {
			this.uploadedBy = uploadedBy;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		@Override
		public String toString() {
			return "Attachments [id=" + id + ", task=" + task + ", uploadedBy=" + uploadedBy + ", title=" + title + ", path="
					+ path + ", icon=" + icon + "]";
		}

	
	}
