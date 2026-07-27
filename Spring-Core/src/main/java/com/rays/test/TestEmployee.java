package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestEmployee {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("person.xml"));

		Employee emp = factory.getBean("employee", Employee.class);

		System.out.println(emp);

	}

}
