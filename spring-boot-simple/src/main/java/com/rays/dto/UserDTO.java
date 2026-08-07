package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;
@Entity
@Table(name = "st_user")
public class UserDTO  extends BaseDTO{

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name ="Login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "roleId")
	private long roleId;
	
	@Column(name ="roleName")
	private String roleName;
	
}
