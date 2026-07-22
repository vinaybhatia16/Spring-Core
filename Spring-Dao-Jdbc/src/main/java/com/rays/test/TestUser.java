package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDto;
import com.rays.service.UserService;


@Component("testUser")
public class TestUser {
	
	@Autowired
	UserService service;
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
       TestUser test =context.getBean("testUser" , TestUser.class );

 
		//test.testadd();
		//test.testupdate();
		test.testsearch();
	}
	
	
	private void testsearch() {
		
		UserDto d = new UserDto();
		//d.setFirstName("v");
		d.setLastName("bhatia");
		
		List<UserDto> list = service.search(d, 1, 1);
		
		Iterator<UserDto> it = list.iterator();
	while (it.hasNext()) {
		UserDto dto =  it.next();
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		
		
		
	}
			
			
		
	}

	private void testupdate() {
		
		 UserDto dto = new UserDto();
		 dto.setFirstName("mohit");
			dto.setLastName("sharma");
			dto.setLogin("sharma33@gmail.com");
			dto.setPassword("mohit123");
			dto.setId(2);
			
			int id = service.update(dto);

			System.out.println("data inserted successfully at id: " + id);
	}


	private void testadd() {
		 UserDto dto = new UserDto();
		 
		 dto.setId(2);
		 dto.setFirstName("rahul");
		dto.setLastName("bhaa");
		dto.setLogin("vinay33@gmail.com");
		dto.setPassword("vinay123");
		int id = service.add(dto);

		System.out.println("data inserted successfully at id: " + id);
 
	}

	
}
