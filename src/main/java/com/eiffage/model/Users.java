package com.eiffage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import com.eiffage.model.enumeration.Status;


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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="USERS_ROLES")
	private List<Roles> role;
	
	public Users(@NotEmpty(message = "email cannot empty or null") String email, String firstName,
			String lastName, String birthday, @NotEmpty(message = "email cannot empty or null") String cin,
			String photo, String phone, boolean activated, Status status) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.cin = cin;
		this.photo = photo;
		this.phone = phone;
		this.activated = activated;
		this.status = status;
	}
	public Users(@NotEmpty(message = "email cannot empty or null") String email, 
					@NotEmpty(message = "email cannot empty or null") String cin,
					Roles role) {
		super();
		this.email = email;
		this.cin = cin;
		if(this.role == null) {
			this.role = new ArrayList<Roles>();
		}
		this.role.add(role);
	}
	public Users() {
		super();
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
	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthday=" + birthday + ", cin=" + cin + ", photo=" + photo + ", phone=" + phone + ", activated="
				+ activated + ", status=" + status + ", role=" + role + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Roles> getRole() {
		return role;
	}
	public void setRole(List<Roles> role) {
		this.role = role;
	}

	
	
}
