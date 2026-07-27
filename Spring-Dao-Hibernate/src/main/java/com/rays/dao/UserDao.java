package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDto;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public int add(UserDto dto) {

		Session session = sessionFactory.getCurrentSession();

		session.save(dto);

		return dto.getId();

	}

	public void update(UserDto dto) {

		Session session = sessionFactory.getCurrentSession();

		session.update(dto);

	}

	public void delete(int id) {

		Session session = sessionFactory.getCurrentSession();

		UserDto dto = findByPk(id);

		session.delete(dto);

	}

	public UserDto findByPk(int id) {

		Session session = sessionFactory.getCurrentSession();

		UserDto dto = session.get(UserDto.class, id);

		return dto;

	}

	public UserDto findByLogin(String login) {

		Session session = sessionFactory.getCurrentSession();

		UserDto dto = null;

		List<UserDto> list = new ArrayList<UserDto>();

		Criteria criteria = session.createCriteria(UserDto.class);
		criteria.add(Restrictions.eq("login", login));

		list = criteria.list();

		if (list.size() == 1) {

			dto = list.get(0);
		}
		return dto;
	}

	public UserDto authenticate(String login, String password) {

		Session session = sessionFactory.getCurrentSession();

		UserDto dto = null;

		List<UserDto> list = new ArrayList<UserDto>();

		Criteria criteria = session.createCriteria(UserDto.class);
		criteria.add(Restrictions.eq("login" , login));

		criteria.add(Restrictions.eq("password" , password));

		list = criteria.list();

		if (list.size() == 1) {

			dto = list.get(0);

		}

		return dto;
	}

	public List<UserDto> search(UserDto dto, int pageNo, int pageSize) {

		Session session = sessionFactory.getCurrentSession();

		List<UserDto> list = new ArrayList<UserDto>();

		Criteria criteria = session.createCriteria(UserDto.class);

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {

				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));

			}

			if (dto.getLastName() != null && dto.getLastName().length() > 0) {

				criteria.add(Restrictions.eq("lastName", dto.getLastName() + "%"));

			}
		}

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list = criteria.list();

		return list;
	}
}
