package com.springJdbc.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springJdbc.dao.studentDaoImpl;
import com.springJdbc.dao.studentdao;
import com.springJdbc.entities.student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hey It's started now ..... :) :)");

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springJdbc/springjdbc/config.xml");
		studentDaoImpl bean = (studentDaoImpl) context.getBean("studentDao");

		// -- insert data into Db
		student student = new student();
		student.setId(123);
		student.setName("Mohan");
		student.setCity("Vrindavan");

		int res = bean.insert(student);
		System.out.println("number of record inserted into db : " + res);

		// --update existing data into
		student student1 = new student();

		student1.setId(123);
		student1.setName("Kanha");
		student1.setCity("Gokul");

		int res1 = bean.update(student1);

		System.out.println("Number of rows updated : " + res1);

		/* ---- Delete Operation -------- */
		int res2 = bean.delete(123);

		System.out.println("Number of rows deleted : " + res2);

		/*--------*/
		student student3 = bean.getStudent(121);

		System.out.println(student3);
	}
}
