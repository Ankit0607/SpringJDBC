package com.springJdbc.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springJdbc.dao.studentDaoImpl;
import com.springJdbc.entities.student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hey It's started now ..... :) :)");

		ApplicationContext context = new ClassPathXmlApplicationContext("com/springJdbc/springjdbc/config.xml");
		studentDaoImpl bean = (studentDaoImpl) context.getBean("studentDao");

		student student = new student();
		student.setId(123);
		student.setName("Mohan");
		student.setCity("Vrindavan");

		int res = bean.insert(student);

		System.out.println( "number of record inserted into db : "+res);
	}
}
