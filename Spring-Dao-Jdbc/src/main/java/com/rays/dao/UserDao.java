package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDto;

@Repository
public class UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public int add(UserDto dto) {

		String sql = "insert into st_user values(?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword());

		return dto.getId();

	}

	public int update(UserDto dto) {

		String sql = "UPDATE st_user SET first_name=?, last_name=?, login=?, password=? WHERE id=?";

		jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(), dto.getId());

		return dto.getId();

	}

	public void delete(int id) {

		String sql = "delete from st_user where id = ?";

		int i = jdbcTemplate.update(sql, id);

		System.out.println("record deleted successfully: " + i);
	}

	public UserDto findbylogin(String login) {

		String sql = "select * from st_user where login =?";

		Object[] param = { login };

		UserDto dto = jdbcTemplate.queryForObject(sql, param, new UserMapper());

		return dto;

	}

	public List<UserDto> search(UserDto dto, int pageNo, int pageSize) {

		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				sql.append(" and first_name like '" + dto.getFirstName() + "%'");
			}
			
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				sql.append(" and last_name like '" + dto.getLastName() + "%'");
			}

		}
		
		if (pageSize > 0 ) {
			pageNo = (pageNo - 1) * pageSize;
			
			sql.append("limit " + pageNo + "," + pageSize);
		}
		
		List<UserDto> list = jdbcTemplate.query(sql.toString(), new UserMapper());
		
		

		return list;

	} 

}
