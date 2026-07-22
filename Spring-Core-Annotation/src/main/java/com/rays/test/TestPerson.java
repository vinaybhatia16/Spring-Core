package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestPerson {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Person p = context.getBean("p" ,Person.class);
		
		p.setName("shyam");
		p.setAddress("indore");
		
		System.out.println(p.getName());
		System.out.println(p.getAddress());
	}
}
