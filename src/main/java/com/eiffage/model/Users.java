package com.eiffage.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.eiffage.model.enumeration.Roles;
import com.eiffage.model.enumeration.Status;

@Table(name = "users")
@Entity
public class Users {
	//todo  : ADD LOGIN AND PASSWORD US STRING FIELDS
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;
	@Column(unique=true)
	@NotEmpty(message="email cannot empty or null")
	private String email;
	private String firstName;
	private String lastName;
	private String birthday;
	@Column(unique=true)
	@NotEmpty(message="email cannot empty or null")
	private String cin;
	private String password;
	private String photo;
	private String phone;
	private boolean activated;
	private Status status;
	private Roles role;
	
	@ManyToOne(targetEntity=Teams.class)
	private Teams team;
	
	@OneToMany
	private List<Tasks> tasksReported;

	@OneToMany
	private List<Tasks> tasksAssigned;

	@OneToMany
	private List<Comments> comments;

	@OneToMany
	private List<Attachments> attachments;

	@OneToMany
	private List<Projects> projects;

	public Users(@NotEmpty(message = "email cannot empty or null") String email, String firstName,
			String lastName, String birthday, @NotEmpty(message = "email cannot empty or null") String cin,
			String password, String photo, String phone, boolean activated, Status status, Roles role) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.cin = cin;
		this.password = password;
		this.photo = photo;
		this.phone = phone;
		this.activated = activated;
		this.status = status;
		this.role = role;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public List<Tasks> getTasksReported() {
		return tasksReported;
	}

	public void setTasksReported(List<Tasks> tasksReported) {
		this.tasksReported = tasksReported;
	}

	public List<Tasks> getTasksAssigned() {
		return tasksAssigned;
	}

	public void setTasksAssigned(List<Tasks> tasksAssigned) {
		this.tasksAssigned = tasksAssigned;
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

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	
	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthday=" + birthday + ", cin=" + cin + ", password=" + password + ", photo=" + photo + ", phone="
				+ phone + ", activated=" + activated + ", status=" + status + ", role=" + role + ", tasksReported="
				+ tasksReported + ", tasksAssigned=" + tasksAssigned + ", comments=" + comments + ", attachments="
				+ attachments + ", projects=" + projects + "]";
	}
}
