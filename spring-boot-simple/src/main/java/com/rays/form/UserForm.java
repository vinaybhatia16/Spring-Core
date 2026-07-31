package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

public class UserForm extends BaseForm {
	
	@NotEmpty(message = "firstName is required")
	private String firstName;

	@NotEmpty(message = "lastName is required")
	private String lastName;

	@NotEmpty(message = "login id is required")
	private String login;

	@NotEmpty(message = "password is required")
	private String password;

	@NotEmpty(message = " role id is required")
	private String roleId;

	@NotEmpty(message = "rolename is required")
	private String roleName;

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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public BaseDTO getDto() {
UserDTO dto = (UserDTO)initDTO(new UserDTO());
dto.setFirstName(firstName);
dto.setLastName(lastName);
dto.setPassword(password);
dto.setLogin(login); 
dto.setRoleId(roleId);
dto.setRoleName(roleName);
return dto;

	
	
	}

}
