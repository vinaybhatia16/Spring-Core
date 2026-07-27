package com.rays.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDto;
import com.rays.service.UserService;

@Component("testUser")
public class UserTest {

	@Autowired
	UserService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserTest test = context.getBean("testUser", UserTest.class);

		// test.testadd();

		// test.testupdate();

		// test.testdelete();

		//test.testauthenticate();
		
		test.testsearch();
	}

	private void testadd() {

		UserDto dto = new UserDto();
		dto.setFirstName("sachin");
		dto.setLastName("bhatia");
		dto.setLogin("sachinbhatia@gmail.com");
		dto.setPassword("1234");

		service.save(dto);

		System.out.println("data added successfully at id " + dto.getId());

	}

	private void testupdate() {
		UserDto dto = new UserDto();
		dto.setFirstName("rahul");
		dto.setLastName("bhatia");
		dto.setLogin("vinay16uk@gmail.com");
		dto.setPassword("abc123");
		dto.setId(1);
		service.save(dto);

	}

	private void testdelete() {

		UserDto dto = new UserDto();

		service.delete(4);

	}

	public void testauthenticate() {

		UserDto dto = new UserDto();
//		dto.setLogin("vinay16uk@gmail.com");
//		dto.setPassword("abc123");
		
		dto = service.authenticate("vinay16uk@gmail.com", "bc123" );
		if (dto != null) {
			System.out.println("user login successfully");
		}
		
		else {
			
			System.out.println("user not found ");
		}
		}

	public void testsearch() {
		
		UserDto dto = new UserDto();
		dto.setFirstName("vinay");
		int pageNo = 1;
		int pageSize = 5;
		List<UserDto> list = service.Search(dto, pageNo, pageSize);
		
		Iterator<UserDto> it = list.iterator();
		while (it.hasNext()) {
			dto =  it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
			
		}
		
	}
}
