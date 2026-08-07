package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	RoleDAO roleDao;

	public void populate(UserDTO dto) {
		RoleDTO roleDto = roleDao.findByPk(dto.getRoleId());
		dto.setRoleName(roleDto.getName());
	}


	
	public long add(UserDTO dto) {

		populate(dto);
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(UserDTO dto) {
		entityManager.merge(dto);
	}

	public void delete(long id) {
		UserDTO dto = findByPk(id);
		entityManager.remove(dto);
	}

	public UserDTO findByPk(long id) {

		UserDTO dto = entityManager.find(UserDTO.class, id);

		return dto;
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> root = cq.from(UserDTO.class);

		List<Predicate> predicatelist = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getId() != null && dto.getId() > 0) {
				predicatelist.add(builder.equal(root.get("id"), dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				predicatelist.add(builder.like(root.get("firstName"), dto.getFirstName() + "%"));

			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				predicatelist.add(builder.like(root.get("lastName"), dto.getLastName() + "%"));

			}
		}

		cq.where(predicatelist.toArray(new Predicate[predicatelist.size()]));

		TypedQuery<UserDTO> query = entityManager.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}
		List<UserDTO> list = query.getResultList();
		return list;
	}

	public UserDTO findBYUniqueKey(String attribute, String value) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> root = cq.from(UserDTO.class);

		Predicate condition = builder.equal(root.get(attribute), value);

		cq.where(condition);

		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		List<UserDTO> list = tq.getResultList();

		UserDTO dto = null;
		if (list.size() == 1) {
			dto = list.get(0);
		}
		return dto;
	}

}
