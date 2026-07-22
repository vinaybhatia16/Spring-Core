package com.rays.autowire.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.test.AppConfig;

public class TestByName {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("AppConfig.xml");
		 
		UserService s = context.getBean("user" , UserService.class);
		
		s.add();
	}

}
