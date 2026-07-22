package com.rays.autowire.byname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("user")
public class UserService {

	@Autowired
	@Qualifier("pp")
	public UserDaoInt userDao;
	
	public void add() {
		
		userDao.add();
		
	}
}
