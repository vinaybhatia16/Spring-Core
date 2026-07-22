package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDao;
import com.rays.dto.UserDto;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int add(UserDto dto) {

		UserDto existdto = dao.findbylogin(dto.getLogin());
		if (existdto != null) {
			throw new RuntimeException("login id already exists");
		}

		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int update(UserDto dto) {

		return dao.update(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		dao.delete(id);
	}

	public UserDto authenticate(String login, String password) {

		UserDto dto = dao.findbylogin(login);

		if (dto != null) {
			if (dto.getPassword().equals(password)) {
				return dto;
			}
		}
		return null;
	}

	public List<UserDto> search(UserDto dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);
	}
}
