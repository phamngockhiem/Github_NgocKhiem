package com.ngockhiem.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserEntity extends Base {
	@NotNull
	@Size(min = 4, message = "Your account should have least 4 characters")
	@Column(name = "name")
	private String userName;
	@NotNull
	@Size(min = 6, message = "Your password must be have least 6 character")
	@Column(name = "password")
	private String password;
	@NotNull
	@Column(name = "full_name")
	private String userFullname;
	@NotNull
	@Column(name = "date_of_birth")
	private String userDateOfBirth;
	@Column(name = "phone")
	private String userPhone;
	@Column(name = "email")
	@Email
	@NotNull
	private String userEmail;
	@NotNull
	@Column(name = "position")
	private String userPosition;
	@Column(name = "permission")
	@NotNull
	private String userPermission;
	@Column(name = "notes")
	private String userNotes;
	@Column(name = "last_loggined")
	private String userLastLogined;
	@Column(name = "role")
	@NotNull
	private String userRoles;
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles = new ArrayList<>();
	
	@OneToMany(mappedBy = "userCode", cascade=CascadeType.ALL)
	private List<OrderEntity> orders = new ArrayList<>();

	public UserEntity() {

	}

	public UserEntity(@NotNull @Size(min = 4, message = "Your account should have least 4 characters") String userName,
			@NotNull @Size(min = 6, message = "Your password must be have least 6 character") String password,
			@NotNull String userFullname, @NotNull String userDateOfBirth, String userPhone,
			@Email @NotNull String userEmail, @NotNull String userPosition, @NotNull String userPermission,
			String userNotes, String userLastLogined, String userRoles, List<RoleEntity> roles, List<OrderEntity> orders) {
		super();
		this.userName = userName;
		this.password = password;
		this.userFullname = userFullname;
		this.userDateOfBirth = userDateOfBirth;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPosition = userPosition;
		this.userPermission = userPermission;
		this.userNotes = userNotes;
		this.userLastLogined = userLastLogined;
		this.userRoles = userRoles;
		this.roles = roles;
		this.orders = orders;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFullname() {
		return userFullname;
	}

	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}

	public String getUserDateOfBirth() {
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(String userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(String userPermission) {
		this.userPermission = userPermission;
	}

	public String getUserNotes() {
		return userNotes;
	}

	public void setUserNotes(String userNotes) {
		this.userNotes = userNotes;
	}

	public String getUserLastLogined() {
		return userLastLogined;
	}

	public void setUserLastLogined(String userLastLogined) {
		this.userLastLogined = userLastLogined;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public String getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

}
