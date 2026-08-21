package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "st_role")
public class RoleDTO extends BaseDTO{

	
	@Column(name = "Name" )
	private String name;
	
	
	@Column(name = "description")
	private String Description ;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	@Override
	public String getValue() {
		
		return name;
	}

	
	
}
