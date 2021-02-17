package com.ngockhiem.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity extends Base {
	@Column(name = "Code")
	private String code;
	@Column(name = "Name")
	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users = new ArrayList<>();

	public RoleEntity() {

	}

	public RoleEntity(String code, String name, List<UserEntity> users) {
		super();
		this.code = code;
		this.name = name;
		this.users = users;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
