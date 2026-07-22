package com.rays.autowire.byname;

import org.springframework.stereotype.Component;

@Component("pp")
public class UserDaoImpl implements UserDaoInt {

	@Override
	public void add() {
		System.out.println("in add method.............");
		
	}

}
