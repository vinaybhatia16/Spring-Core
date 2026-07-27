package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDao;
import com.rays.dto.UserDto;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(UserDto dto) {

		if (dto.getId() > 0) {

			dao.update(dto);
			return;
		}
		dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {

		dao.delete(id);

	}

	@Transactional(readOnly = true)
	public UserDto findbyid(int id) {
		return dao.findByPk(id);
	}

	@Transactional(readOnly = true)
	public UserDto authenticate(String login, String password) {
		return dao.authenticate(login, password);

	}

	@Transactional(readOnly = true)
	public List<UserDto> Search(UserDto dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);
	}
}
