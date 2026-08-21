package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

public class UserForm extends BaseForm {

	@NotEmpty(message = "firstName is required")
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Name should contain only letters and spaces")
	private String firstName;

	@NotEmpty(message = "lastName is required")
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Name should contain only letters and spaces")
	private String lastName;

	@NotEmpty(message = "loginId is required")
	@Email
	private String login;

	@NotEmpty(message = "password is required")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}$", message = "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number, and one special character.")
	private String password;

	@NotNull(message = "role is required")
	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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

	@Override
	public BaseDTO getDto() {
		UserDTO dto = (UserDTO) initDTO(new UserDTO());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setPassword(password);
		dto.setRoleId(0);
		return dto;
	}

}