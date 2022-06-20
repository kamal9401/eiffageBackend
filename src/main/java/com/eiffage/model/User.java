package com.eiffage.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eiffage.model.enumeration.Role;
import com.eiffage.model.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.ManyToOne;


@Entity
public class User implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@Column(name = "USER_NAME", unique = true)
	private String userName;

	@Column(name = "USER_KEY")
	private String password;
	
	@NotEmpty(message = "email cannot empty or null")
	@JsonIgnore
	private String email;
	@JsonIgnore
	private String firstName;
	@JsonIgnore
	private String lastName;
	@JsonIgnore
	private String birthday;
	@NotEmpty(message = "email cannot empty or null")
	@JsonIgnore
	private String cin;
	@JsonIgnore
	private Boolean locked = false;
	@JsonIgnore
	private boolean enabled = true;
	@JsonIgnore
	private String photo;
	@JsonIgnore
	private String phone;
	@JsonIgnore
	private boolean activated;
	@JsonIgnore
	private Status status;
	@JsonIgnore
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Authority authority;
	@Transient
	private List<Authority> authorities;
	
	

	public User(@NotEmpty(message = "email cannot empty or null") String email, String firstName, String lastName,
			String birthday, @NotEmpty(message = "email cannot empty or null") String cin, String password,
			String photo, String phone, boolean activated, Status status, boolean enabled) {
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
		this.enabled=enabled;
	}

	public User(String firstName, String lastName, String email, String password, Role role

	) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		authorities.add(authority);
		return authorities;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long idUser) {
		this.id = idUser;
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

	@Override
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Users [idUser=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthday=" + birthday + ", cin=" + cin + ", password=" + password + ", photo=" + photo + ", phone="
				+ phone + ", activated=" + activated + ", status=" + status + ", role=" + role + ", tasksReported="
				 +"]";
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
