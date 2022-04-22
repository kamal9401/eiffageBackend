package com.eiffage.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
	
	@Entity
	public class Files {

		@Id @GeneratedValue
		private Long id; 
		
		private String title;
		private String path;
		private String icon;
		
		public Files(Long id, String title, String path, String icon, Tasks task) {
			super();
			this.id = id;
			this.title = title;
			this.path = path;
			this.icon = icon;
			this.task = task;
		}
		@ManyToOne
		private Tasks task;
		public Files() {
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
		public Tasks getTask() {
			return task;
		}
		public void setTask(Tasks task) {
			this.task = task;
		}
	}
