package com.eiffage.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.eiffage.model.enumeration.Status;

	@Entity
	public class Projects {
		@Id
		private Long id; 
		private String description;
		private String title;
		private LocalDateTime timeStamp;
		private Status status; 
		
		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name="PROJECTS_TEAMS")
		private List<Teams> teams;

		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name="PROJECTS_TASKS")
		private List<Tasks> tasks;

		public Projects(Long id, String description,Status status, String title, LocalDateTime timeStamp, List<Teams> team, List<Tasks> tasks) {
			super();
			this.id = id;
			this.description = description;
			this.status = status;
			this.timeStamp = timeStamp;
			if(this.teams == null) {
				this.teams = new ArrayList<Teams>();
			}
			this.teams.addAll(team);
			if(this.tasks== null) {
				this.tasks = new ArrayList<Tasks>();
			}
			this.tasks.addAll(tasks);
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

		public LocalDateTime getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
		}

		public List<Teams> getTeam() {
			return teams;
		}

		public void setTeam(List<Teams> team) {
			this.teams = team;
		}

		public void setTasks(List<Tasks> task) {
			this.tasks = task;
		}
		
		public List<Tasks> getTasks() {
			return tasks;
		}

		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
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

		@Override
		public String toString() {
			return "Projects [id=" + id + ", Title=" + title + ", Description=" + description+ ", Status=" + status + ", TimeStamp=" +timeStamp
					+  ",team=" + teams + "]";
		}
		
	}
